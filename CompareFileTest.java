import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)

public class CompareFileTest {
	public String[] comparedArr, inputArr;
    
	// classic constructor
	public CompareFileTest (String[] comparedArr, String[] inputArr ) { 
    	this.comparedArr =  comparedArr; 
    	this.inputArr = inputArr;  
    }


   @Parameters public static Collection<String[][]> parameters() {
      // convert file names to absolute paths
      String cwd = "D:/DataReconcilation/"; // replace with files' dir path
      // filein
      String fi1 = cwd + "sample_file_1.csv";
      String fi2 = cwd + "sample_file_3.csv";
      String fi1r = cwd + "sample_file_1_row.csv";
      String fi1c = cwd + "sample_file_1_col.csv";
      String fi1rc = cwd + "sample_file_1_row_col.csv";

      //file out
      String fo1 = cwd + "compare_out_1.csv";
      String fo2 = cwd + "compare_out_2.csv";
      String fo3 = cwd + "compare_out_3.csv";
      String fo4 = cwd + "compare_out_4.csv";

      // file out test
      String fot1 = cwd + "test_out_1.csv";
      String fot2 = cwd + "test_out_2.csv";
      String fot3 = cwd + "test_out_3.csv";
      String fot4 = cwd + "test_out_4.csv";

      // answer
      String fAns1 = cwd + "sample_file_output_comparing_1_and_3.csv";

        return Arrays.asList (new String [][][] {
         {{fi1,fi2,fo1},{fo1,fAns1,fot1}}, // same row & col orders
         {{fi1r,fi2,fo2},{fo2,fAns1,fot2}}, // diff row order, same col order
         {{fi1c,fi2,fo3},{fo3,fAns1,fot3}},  // same row order, diff col order
         {{fi1rc,fi2,fo3},{fo4,fAns1,fot4}}  // diff row order, diff col order
   }); 
    }

	 
   @Test public void compareTest() { 
      CompareFile compareFileClass = new CompareFile(); 

      try { 
         compareFileClass.compare(inputArr);
         compareFileClass.compare(comparedArr);
         assertEquals(0, new File(comparedArr[2]).length());
      } 
      catch(Exception e){
         System.out.println(e);
      }  
         
}
}

// public class CompareFileTest { 
//    @Test
//    public void Compare () throws Exception { 

//     // convert file names to absolute paths
//     String cwd = "D:/DataReconcilation/"; // replace with files' dir path
//     String fi1 = cwd + "sample_file_1.csv";
//     String fi2 = cwd + "sample_file_3.csv";
//     String fo1 = cwd + "compare_out.csv";
//     String fo2 = cwd + "test_out.csv";
//     String fAns1 = cwd + "sample_file_output_comparing_1_and_3.csv";

//     // test
//     CompareFile compareFileClass = new CompareFile(); 
//     String[] filenames = {fi1,fi2,fo1};
//     compareFileClass.compare(filenames);
//     String[] filenamesTest = {fo1,fAns1,fo2};
//     compareFileClass.compare(filenamesTest);
//     File test_out = new File(fo2);
//     assertEquals(0, test_out.length());


//    }

   
// }
