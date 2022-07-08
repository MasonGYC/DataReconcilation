import java.io. * ;
import java.util.Scanner;
public class ReadFile {
  public static void main(String[] args) throws Exception {
    File file = new File("sample_file_1.csv");
    Scanner scanner = new Scanner(file);
    //parsing a CSV file into the constructor of Scanner class 
    scanner.useDelimiter(",");
    //setting comma as delimiter pattern
    while (scanner.hasNext()) {
      System.out.print(scanner.next());
    }
    scanner.close();
  }
}