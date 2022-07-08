import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;

public class CompareFileTest { 
   @Test
   public void Compare () throws Exception { 
    CompareFile a = new CompareFile(); 
    String[] filenames = {"D:/DataReconcilation/sample_file_1.csv","D:/DataReconcilation/sample_file_3.csv","D:/DataReconcilation/compare_out.csv"};
    a.compare(filenames);
    String[] filenamesTest = {"D:/DataReconcilation/compare_out.csv","D:/DataReconcilation/sample_file_output_comparing_1_and_3.csv","D:/DataReconcilation/test_out.csv"};
    a.compare(filenamesTest);
    File test_out = new File("D:/DataReconcilation/test_out.csv");
    assertEquals(0, test_out.length());


   }

   
}
