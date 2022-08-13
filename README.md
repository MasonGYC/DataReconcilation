# Data Reconcilation
Guo Yuchen 1004885

This program is for comparing 2 csv files and record their difference in a new csv file.

## Use Case Diagram
See `docs/use_case_diagram.png`.

## User Mannual

### Getting Started (a quick start)
1. Clone/download the repository to your computer;
2. Change `cwd` inside `CompareFileTest.java` `compare` function with test files' dir
3. Compile and run `CompareFile.java`, check `compare_out.csv` for the differences detected in 2 input files;
4. Test using `CompareFileTest.java`, should be able to pass the test. (download JUnit before testing).

### Compare files
Put the 2 files that you want to compare inside data folder, replace their filenamess in `CompareFile.java.main` function, and the output file that you want the compared result to be printed to. Then run `main` function to compare.

### CSV input file format
Example:

1. id column must be the leftmost column, and must be unique
2. 2 compared files must have same number of rows
3. 2 compared files must have headers
4. 2 files must have same headers
5. each row must have same number of data as header suggests

### Testing (week9)
 <!-- Work out an equivalence class partitioning and boundary value analysis for blackbox testing of your program. Explain all the equivalence classes, examples of boundary/middle values in each equivalence class and the rationale behind your choices. -->
 Equivalence classes:
 1. input file data format - row& column order  
 >*To determine rows and columns in different order with the same data can be compared*  
 - same order for row and column  
 - diffrent order for row and column  
 - same order for row, different order for column  
 - different order for row, same order for column  

 - boundary value: null
 - middle values: null

 2. input file number  
 > *To determine whether there are only 2 input files to compare*
 - valid: 2
 - invalid: <2 or >2
 - boundary value: 2
 - middle values: 2, 6




