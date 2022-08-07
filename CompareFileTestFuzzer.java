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
    String fo2 = cwd + "compare_out_a.csv";
    String fAns1 = cwd + filesubnames[2];

    CompareFile compareFile = new CompareFile(); 

    // test
    String[] filenames = {fi1,fi2,fo1,"test"};
    compareFile.compare(filenames);
    String[] filenames1 = {fo1,fAns1,fo2};
    compareFile.compareAnswer(filenames1);
    assertEquals(0, new File(fo2).length());


   
   }


}