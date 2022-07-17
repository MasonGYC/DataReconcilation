import java.io. * ;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;

public class CompareFile {
  public void compare(String[] filenames) throws Exception {
    // File file1 = new File("sample_file_1.csv");
    // File file2 = new File("sample_file_3.csv");
    // File fileOut = new File("compare_out.csv");

    File file1 = new File(filenames[0]);
    File file2 = new File(filenames[1]);
    File fileOut = new File(filenames[2]);

    // reader
    Scanner scanner1 = new Scanner(file1);
    Scanner scanner2 = new Scanner(file2);

    scanner1.useDelimiter(",");
    scanner2.useDelimiter(",");

    // writer
    FileWriter fileWriter = new FileWriter(fileOut);

  // if same order
    // while (scanner1.hasNextLine() && scanner2.hasNextLine()) {
    //   String s1 = scanner1.nextLine();
    //   String s2 = scanner2.nextLine();
    //   if (!s1.equals(s2)){
    //     fileWriter.append(s1+"\n");
    //     fileWriter.append(s2+"\n");
    //   }
    // }

    ArrayList<String> f2_list = new ArrayList<String>();

    while (scanner2.hasNextLine()){
      String s2 = scanner2.nextLine();
      f2_list.add(s2);
    }

    while (scanner1.hasNextLine()) {
      String s1 = scanner1.nextLine();

      boolean found = false;
      if (f2_list.contains(s1)){
        // System.out.println(f2_list.contains(s1));
        found = true;
      }
      if (!found){
        for (String s: f2_list){
          if (s1.split(",")[0].equals(s.split(",")[0])){
            fileWriter.append(s1+"\n");
            fileWriter.append(s+"\n");
            break;
          }
        }

      }

    }
    // close
    scanner1.close();
    scanner2.close();
    fileWriter.flush();
    fileWriter.close();
  
  }
  public static void main(String[] args) throws Exception {
    String[] filenames = {"sample_file_1.csv","sample_file_3.csv","compare_out.csv"};
    CompareFile compareFile = new CompareFile();
    compareFile.compare(filenames);
  }
}