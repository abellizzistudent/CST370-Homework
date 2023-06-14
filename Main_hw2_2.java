/*
 * Title: Main_hw2_2.java
 * Abstract: The program reads a number of elements in a set given by the user, then read the elements of the set  * given by the user. After that, display all possible decimal numbers (number of unique combinations of the user  * elements), their corresponding binary numbers, and bitmap the element values to the binary numbers. It should   * look like:
 * number of elements in a set given by the user--> 3
 * the elements of the set given by the user-->     A B C
 *                               Output Rows-->     0:000:EMPTY
 *                                                  1:001:C 
 *                                                  2:010:B 
 *                                                  3:011:B C 
 *                                                  4:100:A 
 *                                                  5:101:A C 
 *                                                  6:110:A B 
 *                                                  7:111:A B C 
 *
 * Name: Anna Bellizzi
 * Date:11/7/2022
 */
import java.io.*;
import java.util.*;

class Main 
{
    //Convert any number n to its binary value
    public static int decToBin(int n)
    {  
      int count = 0;
      int binNum = 0;
      while (n != 0)
        {
          int remainder = n % 2;
          double a = Math.pow(10, count);
          binNum += remainder * a;
          n /= 2;
          count ++;
        }
      return binNum;
    }

    //Create the 2D array, three columns and n rows based on array size from user input
    //Col 0 Decimal 0 to n-1
    //Col 1 Binary values of Col 0
    public static int[][] makeMatrix(int n)
    {
    //Counter for Matrix array
    int row = 0;
    int col;
    //Declaration for Matrix array
    int[][] myMatrix = new int[n][3];
    //loop through the user entry array
      //take the left number
      for (int i=0; i<n; i++)
        {
          col = 0;
          myMatrix[i][col] = i;
        }
      for (int i=0; i<n; i++)
        {
          col = 1;
          myMatrix[i][col] = decToBin(i);
        }
      return myMatrix;
    }

    //Bitmap the matrix values
    public static void bitMap(int array2[][], String array1[])
    {
      int array1Length = array1.length;
      
      String[][] stringArray2 = intToStringArray(array2, array1Length);
      
      //iterate through second column of matrix array
      for (int i = 0; i < stringArray2.length; i++)
        {
          //convert value at index row i col 1 into a seperate single array
          String numToString = String.valueOf(stringArray2[i][1]);
          String[] array = numToString.split("");
          
          //Write "EMPTY" because there is no value at this index
          stringArray2[0][2] = "EMPTY";

          int j = array.length-1;
          stringArray2[i][2] = "";
          do
            {
              if (array[j].equals("1") && array1[j].length() <= 1)
              {
                //stringArray2[i][2] = array1[j] + " " + stringArray2[i][2];
                String line = array1[j] + stringArray2[i][2];
                stringArray2[i][2] = line.replaceAll("(?<=[A-Z])(?=[A-Z])", " ");
              }
              if (array1[j].length() > 1 && array[j].equals("1"))
              {
                //stringArray2[i][2] = array1[j] + " " + stringArray2[i][2];
                
                String delimiter = " ";
 
                stringArray2[i][2] = String.join(delimiter, array1[j], stringArray2[i][2]);
              }
              stringArray2[i][2] = stringArray2[i][2];
              j--;
              
            } while (j > -1);
        } 
      printFinalMatrix(stringArray2);
    }
    
    public static String[][] intToStringArray(int array[][], int n)
    {
      //declare a new String array same length as int array parameter
      String[][] stringArray = new String[array.length][];
      for(int i = 0; i < array.length; i++)
      {
        stringArray[i] = new String[array[i].length];
        for(int j=0; j<array[i].length; j++)
        {
          //String stringVal = Integer.toString(array[i][j]);
          if (j == 1)
          {
            //PAD binary numbers with apropriate leading zeros
            stringArray[i][j] = String.format("%" + n + "s",Integer.toString(array[i][j])).replace(" ", "0");
          }
          else
          stringArray[i][j] = Integer.toString(array[i][j]); 
        }
      }
      return stringArray;
    }
    // Array size is based on number of nibbles(4) possible out of combining the number of user entered strings. Calculated from the user-entered number of elements they will then enter (the first value entered)
    static int arrSize(int n)
    {
      int numLines = 2 * ((int) Math.pow(2, n-1));
      return numLines;
    }
    
    //Takes user inputed single line String, parses on space delimiter, returns the array
    public static String[] parseString(String u)
    {
      String parts[] = u.split(" ");
      return parts;
    }

    //Print an array
    public static void printArray(String array[])
    {
      System.out.println(Arrays.toString(array)); 
    }

    //Print a 2D Array Matrix
    public static void printMatrix(int matrix[][])
    {
        // Loop through all rows
        for (int[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }

    //Print a 2D String Array Matrix
    public static void printStringMatrix(String matrix[][])
    {
        // Loop through all rows
        for (String[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }

    public static void printFinalMatrix(String matrix[][])
    {
        for (int i = 0; i < matrix.length; i++)
        {
          for (int j = 0; j < matrix[i].length; j++)
          {
            System.out.print(matrix[i][j]);
            if (j < matrix[i].length - 1)
            {
              System.out.print(":");
            }
          }
    System.out.println();
        }
    }
  ////////////////////////////////////////////////////////////////////////////////
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in).useDelimiter("\n");
        //get user inputs
        int n = input.nextInt();
        String s = input.next(); 
        input.close();

        bitMap(makeMatrix(arrSize(n)), parseString(s));
        if (n == 0)
        {
          System.out.println("0:0:EMPTY");
        }
    }  
}

