import java.io.File;
import java.io.FileWriter;
import java.nio.charset.Charset;
import java.util.*;


public class Fuzzer {
    

    public String[] writeFuzzyFiles(String filebase) throws Exception{
        // filenames
        String f1 = filebase+"_1.csv";
        String f2 = filebase+"_2.csv";
        String fa = filebase+"_ans.csv";
        String[] filenames = {f1,f2,fa};

        // files
        File file1 = new File(f1);
        File file2 = new File(f2);
        File fileAns = new File(fa);

        HashMap<String, String> keymap = generateKeyIndex();


        // writer
        FileWriter fileWriter1 = new FileWriter(file1);
        FileWriter fileWriter2 = new FileWriter(file2);
        FileWriter fileWriterAns = new FileWriter(fileAns);

        Random random = new Random();
        int rows = random.nextInt((int)Math.pow(10, 3));
                // System.out.println(rows);

        for(int i = 1; i < rows;i++){
            HashMap<String, String> randomAccount = generateRandomAccount();
            
            int selector = random.nextInt(20);
            Boolean writeAns;

            if (selector <5){
                writeAns = true;
            }
            else{
                writeAns = false;
            }

            String mutatedValue;
            String oriValue;
            String key;
            String mutatedValues = "";
            String oriValues = "";

            for (int j=0; j<5; j++){

                key = keymap.get(String.valueOf(j));
                oriValue = randomAccount.get(key);
                fileWriter1.append(oriValue);

                if (j == 4){
                    mutatedValue = oriValue.substring(0,(int)oriValue.length()/2)+"\n";
                }
                else{
                    mutatedValue = oriValue.substring(0,(int)oriValue.length()/2)+",";
                }

                oriValues = oriValues + oriValue;

                if (j == selector) {

                    fileWriter2.append(mutatedValue);
                    mutatedValues = mutatedValues + mutatedValue;
                }
                else{
                    fileWriter2.append(oriValue);
                    mutatedValues = mutatedValues + oriValue;
                }

            }
            if (writeAns == true){
                fileWriterAns.append(oriValues);
                fileWriterAns.append(mutatedValues);
            }

            
        }
        
        fileWriter1.flush();
        fileWriter1.close();
        fileWriter2.flush();
        fileWriter2.close();
        fileWriterAns.flush();
        fileWriterAns.close();

        return filenames;
      }
    

      private HashMap<String, String> generateRandomAccount() {
        Random random = new Random();
        HashMap<String, String> account = new HashMap<String, String>();
        account.put("CustomerID",generateRandomString(random.nextInt(50))+ ",");
        account.put("AccountNo",generateRandomString(random.nextInt(50))+ ",");
        account.put("Balance",generateRandomString(random.nextInt(50))+ ",");
        account.put("Type",generateRandomString(random.nextInt(50))+ ",");
        account.put("Currency",generateRandomString(random.nextInt(50))+ "\n");
        return account;
      }

      private HashMap<String, String> generateKeyIndex() {
        HashMap<String, String> keymap = new HashMap<String, String>();
        keymap.put("0","CustomerID");
        keymap.put("1","AccountNo");
        keymap.put("2","Balance");
        keymap.put("3","Type");
        keymap.put("4","Currency");
        return keymap;
      }

      private String generateRandomString(int length) {
        byte[] array = new byte[length]; // length is bounded by length
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        generatedString = generatedString.replace(",", "").replace("\r", "").replace("\n", "");
        return generatedString;
    }

    
  // public static void main(String[] args) {
  //   try {
  //       // String filebase = args[0];
  //       String filebase = "fuzzerInput";
  //       Fuzzer fuzzer = new Fuzzer();
  //       fuzzer.writeFuzzyFiles(filebase);
  //   } catch (Exception e) {
  //     System.out.println(e);
  //     ;
  //   }

  // }
  public static void main(String[] args) {
      try {
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
        System.out.println(new File(fAns1).length()+ new File(fo1).length());
      } 
      catch (Exception e) {
        System.out.println(e);
        
    }

  }



      

}
