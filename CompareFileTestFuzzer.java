import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CompareFileTestFuzzer { 

    

 
   @Test
   public void CompareTest () throws Exception { 

    String filebase = "fuzzerInput";
    Fuzzer fuzzer = new Fuzzer();
    String[] filesubnames = fuzzer.writeFuzzyFiles(filebase);

    // convert file names to absolute paths
    String cwd = "D:/DataReconcilation/"; // replace with files' dir path
    String fi1 = cwd + filesubnames[0];
    String fi2 = cwd + filesubnames[1];
    String fo1 = cwd + "compare_out.csv";
    String fAns1 = cwd + filesubnames[2];

    CompareFile compareFile = new CompareFile(); 

    // test
    String[] filenames = {fi1,fi2,fo1,"test"};
    compareFile.compare(filenames);
    assertEquals(new File(fAns1).length(), new File(fo1).length());


   
   }


}