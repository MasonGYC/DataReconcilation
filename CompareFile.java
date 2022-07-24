import java.io.*;
import java.util.*;

import java.io.FileWriter;

public class CompareFile {
  public void compare(String[] filenames) throws Exception {
    // File file1 = new File("sample_file_1.csv");
    // File file2 = new File("sample_file_3.csv");
    // File fileOut = new File("compare_out.csv");

    File file1 = new File(filenames[0]);
    File file2 = new File(filenames[1]);
    File fileOut = new File(filenames[2]);
    String mode = filenames[3];

    // reader
    Scanner scanner1 = new Scanner(file1);
    Scanner scanner2 = new Scanner(file2);

    scanner1.useDelimiter(",");
    scanner2.useDelimiter(",");

    // writer
    FileWriter fileWriter = new FileWriter(fileOut);

    // store f2 values
    Map<String, Set<String>> f2_map = new HashMap<String, Set<String>>();
    Map<String, String> f2_text_map = new HashMap<String, String>();

    // header
    if (mode == "compare") {
      // has headers
      String[] h1 = scanner1.nextLine().split(",");
      String[] h2 = scanner2.nextLine().split(",");

    }

    while (scanner2.hasNextLine()) {
      String s2_ori_text = scanner2.nextLine();
      String[] s2_ori =s2_ori_text.split(",");

      String id = s2_ori[0];

      String[] s2 = Arrays.copyOfRange(s2_ori, 1, s2_ori.length );
      Set<String> hSet = new HashSet<String>();
      for (String x : s2)
        hSet.add(x);
      f2_map.put(id, hSet);
      f2_text_map.put(id, s2_ori_text);
    }

    while (scanner1.hasNextLine()) {
      String s1_ori_text = scanner1.nextLine();
      String[] s1_ori = s1_ori_text.split(",");
      String s1_id = s1_ori[0];

      String[] s1 = Arrays.copyOfRange(s1_ori, 1, s1_ori.length );

      Set<String> hSet = new HashSet<String>();
      for (String x : s1)
        hSet.add(x);

      boolean found = false;
      if (f2_map.get(s1_id) == null){
      System.out.println(s1_id);
      System.out.println(f2_map.keySet());
      }

      if (f2_map.get(s1_id).equals(hSet)) {
        // System.out.println(f2_map.get(s1_id));
        // System.out.println(hSet);
        found = true;
      }
      if (!found) {
        System.out.println(f2_map.get(s1_id));
        System.out.println(hSet);
      
        fileWriter.append(s1_ori_text + "\n");
        fileWriter.append(f2_text_map.get(s1_id) + "\n");

      }

    }

    // close
    scanner1.close();
    scanner2.close();
    fileWriter.flush();
    fileWriter.close();
  }

  public static void main(String[] args) {
    try {
      String[] filenames = { "sample_file_1_row_col.csv", "sample_file_3.csv", "compare_out_a.csv", "compare" };
      CompareFile compareFile = new CompareFile();
      compareFile.compare(filenames);
    } catch (Exception e) {
      System.out.println(e);
      ;
    }

  }
}