import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import java.nio.file.Paths;



public class CompareFileTest { 
   @Test
   public void Compare () throws Exception { 

    // convert file names to absolute paths
    String cwd = "D:/DataReconcilation/"; // replace with files' dir path
    String filein1 = cwd + "sample_file_1.csv";
    String filein2 = cwd + "sample_file_3.csv";
    String fileout1 = cwd + "compare_out.csv";
    String fileout2 = cwd + "test_out.csv";
    String fileAnswer = cwd + "sample_file_output_comparing_1_and_3.csv";

    // test
    CompareFile a = new CompareFile(); 
    String[] filenames = {filein1,filein2,fileout1};
    a.compare(filenames);
    String[] filenamesTest = {fileout1,fileAnswer,fileout2};
    a.compare(filenamesTest);
    File test_out = new File(fileout2);
    assertEquals(0, test_out.length());


   }

   
}
