package week13_finding_bugs.testing_soh_pei_xuan;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.*;


public class TestClass {

    String firstFile = "test_ori.csv";
    String columns = "Customer ID#,Account No.,Currency,Type,Balance";
    File expFile = new File("D:/esc-software-testing-campaign/output/exceptions.csv");


    @Test
    // different order of row with same content
    public void compareTest1() throws IOException, InvalidColumnException, InvalidDataException {
        String secFile = "test1.csv";
        DataExtractor de = new DataExtractor(columns);
        de.setColumns(firstFile, secFile);
        de.setAccount(firstFile, secFile);
        de.generateExceptions();
        assertEquals(expFile.length(), 0);
    }

    @Test
    // duplicate ids
    public void compareTest2() throws IOException, InvalidColumnException, InvalidDataException {
        String secFile = "test2.csv";
        DataExtractor de = new DataExtractor(columns);
        de.setColumns(firstFile, secFile);
        assertThrows(InvalidDataException.class, () -> {
            de.setAccount(firstFile, secFile);
        });
        de.generateExceptions();

    }

    @Test
    public void compareTest3() throws IOException, InvalidColumnException, InvalidDataException {
        String secFile = "test3.csv";
        DataExtractor de = new DataExtractor(columns);
        de.setColumns(firstFile, secFile);
        de.setAccount(firstFile, secFile);
        de.generateExceptions();
        Scanner sc = new Scanner(expFile);
        int line_count = 0;
        Set<String> hSet = new HashSet<String>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            line_count ++;
            hSet.add(line.split(",")[0]);
          }
        assertEquals(hSet.size(),1);
        assertEquals(line_count,2);
        sc.close();
    }

    @Test
    // less columns in args
    public void compareTest4() throws IOException, InvalidColumnException, InvalidDataException {
        String secFile = "test4.csv";
        String columns = "Customer ID#,Account No.,Currency,Type";
        DataExtractor de = new DataExtractor(columns);
        de.setColumns(firstFile, secFile);
        de.setAccount(firstFile, secFile);
        de.generateExceptions();
        Scanner sc = new Scanner(expFile);
        int line_count = 0;
        Set<String> hSet = new HashSet<String>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            line_count ++;
            hSet.add(line.split(",")[0]);
          }
        assertEquals(hSet.size(),1);
        assertEquals(line_count,2);
        sc.close();

    }

}


