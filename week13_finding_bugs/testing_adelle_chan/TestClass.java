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
    String expFileName = "exceptions.csv";
    File expFile = new File(expFileName);


    @Test
    // null entry
    public void compareTest1(){
        String secFile = "test1.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        comparedCSV.getCSV(expFileName);
        Scanner sc = new Scanner(expFile);
        int line_count = 0;
        Set<String> hSet = new HashSet<String>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            line_count ++;
            hSet.add(line.split(",")[0]);
          }
        assertEquals(hSet.size(),1);
        assertTrue(hSet.contains("ID1"));
        assertEquals(line_count,2);
        sc.close();
    }

    @Test
    // duplicate ids
    public void compareTest2(){
        String secFile = "test2.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        ;
        assertThrows(FileFormatException.class, () -> {
            comparedCSV.getCSV(expFileName);
        });
        de.generateExceptions();

    }

    @Test
    // Not able to deal with entry with "," inside
    public void compareTest3(){
        String secFile = "test3.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        comparedCSV.getCSV(expFileName);
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
    // Not able to switch columns
    public void compareTest4(){
        String secFile = "test1.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        comparedCSV.getCSV(expFileName);
        assertEquals(expFile.length(), 0);
    }

    @Test
    // Not able to output difference for id that exists in only one file
    public void compareTest5(){
        String secFile = "test1.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        comparedCSV.getCSV(expFileName);
        Scanner sc = new Scanner(expFile);
        int line_count = 0;
        Set<String> hSet = new HashSet<String>();
        while (sc.hasNextLine()){
            String line = sc.nextLine();
            line_count ++;
            hSet.add(line.split(",")[0]);
          }
        assertEquals(hSet.size(),1);
        assertTrue(hSet.contains("ID7"));
        assertEquals(line_count,1);
        sc.close();
    }

    @Test
    // different rows with same content
    public void compareTest6(){
        String secFile = "test6.csv";
        CompareCSV comparedCSV = new CompareCSV(firstFile, secFile);
        comparedCSV.getCSV(expFileName);
        assertEquals(expFile.length(), 0);
    }



}


