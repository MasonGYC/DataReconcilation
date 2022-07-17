# Data Reconcilation
Guo Yuchen 1004885

This program is for comparing 2 csv files and record their difference in a new csv file.

## Use Case Diagram
See `use_case_diagram.png`.

## User Mannual

### Getting Started (a quick start)
1. Clone/download the repository to your computer;
2. Change `cwd` inside `CompareFileTest.java` `compare` function with test files' dir
3. Compile and run `CompareFile.java`, check `compare_out.csv` for the differences detected in 2 input files;
4. Test using `CompareFileTest.java`, should be able to pass the test. (download JUnit before testing).

### Compare files
Replace the filenames in `CompareFile.java.main` function with 2 files that you want to compare, and the output file that you want the compared result to be printed to. Then run `main` function to compare.

### CSV file format
Example:

### Testing (week9)
 <!-- Work out an equivalence class partitioning and boundary value analysis for blackbox testing of your program. Explain all the equivalence classes, examples of boundary/middle values in each equivalence class and the rationale behind your choices. -->
 Equivalence classes:
 1. input file format  
 > *To determine whether the input file format is correct*
 - valid: csv, xlsx
 - invalid: others
 - boundary values: csv, xlxs
 - middle values: csv, jpg, doc  
 
 2. input file number  
 > *To determine whether there are only 2 input files to compare*
 - valid: 2
 - invalid: <2 or >2
 - boundary value: 2
 - middle values: 2, 6

3. input file data format - column header  
 >*To determine whether the data in the input files have column header*
 - valid:  

| Customer ID# | Account No.  | Currency  | ...|   
| ------------- |:-------------:| -----:| --:|  
| ID1     | BOS96321 | USD |...|  
| ID2      | BOS85992      |  AUD |...|  
| ID3 | BOS656613     |    USD |...|  
| ...|  ...|  ...|  ...|  


 - invalid: 
  
| ID1     | BOS96321 | USD |...|  
| ------------- |:-------------:| -----:| --:|
| ID2      | BOS85992      |  AUD |...|  
| ID3 | BOS656613     |    USD |...|  
| ...|  ...|  ...|  ...|  

 - boundary value: null
 - middle values: null

3. input file data format - row& column order  
 >*To determine rows and columns in different order with the same data can be compared*  
 - same order for row and column  
 - diffrent order for row and column  
 - same order for row, different order for column  
 - different order for row, same order for column  

 - boundary value: null
 - middle values: null

