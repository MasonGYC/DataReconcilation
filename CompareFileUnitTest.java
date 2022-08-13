import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompareFileUnitTest { 

    private Scanner scanner;
    private Map<String, Set<String>> f2_map = new HashMap<String, Set<String>>();
    private Map<String, String> f2_text_map = new HashMap<String, String>();
    File fileIn = new File("D:/DataReconcilation/data/unit_test_in.csv");
    File fileOut = new File("D:/DataReconcilation/out/unit_test_out.csv");
    CompareFile compareFile;

    @Before
    public void runBeforeEachTest() throws FileNotFoundException
	{
		System.out.println("setting up");
		compareFile = new CompareFile(); 
        scanner = new Scanner(fileIn);
        scanner.useDelimiter(",");
	}

    @After 
	public void runAfterEachTest()
	{
	    scanner.close();
        f2_map.clear();
        f2_text_map.clear();
		System.out.println("setting down");
	}

    @Test
    public void storeFile2Test() { 
        try{
            compareFile.storeFile2(scanner,f2_map,f2_text_map);
            assertEquals(f2_map.keySet(),Set.<String>of("ID1","ID2"));
            assertEquals(f2_map.get("ID1"), Set.<String>of("BOS492681","CAD", "CURRENT", "426505")); 
            assertEquals(f2_map.get("ID2"), Set.<String>of("BOS760122","EUR", "SAVINGS", "87278")); 
        }
        finally{    
        }

    }

    @Test
    public void writeDiffTest() throws Exception { 
        compareFile.storeFile2(scanner,f2_map,f2_text_map);
        compareFile.writeDiff(fileOut,scanner,f2_map,f2_text_map);
        assertEquals(0, fileOut.length());
    }

   @Test
   public void CompareTest () throws Exception { 

    // convert file names to absolute paths
    String cwd = "D:/DataReconcilation/"; // replace with files' dir path
    String fi1 = cwd + "data/sample_file_1.csv";
    String fi2 = cwd + "data/sample_file_3.csv";
    String fo1 = cwd + "out/compare_out.csv";
    String fAns1 = cwd + "data/sample_file_output_comparing_1_and_3.csv";

    // test
    String[] filenames = {fi1,fi2,fo1,"compare"};
    compareFile.compare(filenames);
    assertEquals(new File(fAns1).length()-6, new File(fo1).length());


   
   }


}