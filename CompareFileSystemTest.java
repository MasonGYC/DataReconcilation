import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import java.util.*;

@RunWith(Parameterized.class)

public class CompareFileSystemTest {
	public String[] comparedArr, inputArr;
    
	// classic constructor
	public CompareFileSystemTest (String[] comparedArr, String[] inputArr ) { 
    	this.comparedArr =  comparedArr; 
    	this.inputArr = inputArr;  
    }


   @Parameters public static Collection<String[][]> parameters() {
      // convert file names to absolute paths
      String cwd = "D:/DataReconcilation/"; // replace with files' dir path
      // filein
      String datapath = "data/";
      String fi1 = cwd + datapath + "data/sample_file_1.csv";
      String fi2 = cwd + datapath + "sample_file_3.csv";
      String fi1r = cwd + datapath + "sample_file_1_row.csv";
      String fi1c = cwd + datapath + "sample_file_1_col.csv";
      String fi1rc = cwd + datapath + "sample_file_1_row_col.csv";

      //file out
      String outpath = "out/";
      String fo1 = cwd + outpath + "compare_out_1.csv";
      String fo2 = cwd + outpath + "compare_out_2.csv";
      String fo3 = cwd + outpath + "compare_out_3.csv";
      String fo4 = cwd + outpath + "compare_out_4.csv";

      // file out test
      String fot1 = cwd + outpath + "test_out_1.csv";
      String fot2 = cwd + outpath + "test_out_2.csv";
      String fot3 = cwd + outpath + "test_out_3.csv";
      String fot4 = cwd + outpath + "test_out_4.csv";

      // answer
      String fAns1 = cwd + datapath + "sample_file_output_comparing_1_and_3.csv";

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