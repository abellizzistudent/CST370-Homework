/*
 * Title: Main_hw3_1.java
 * Abstract: The program reads the number of input values from a user then a list of entries from the user. Display the entries in ascending order. Use a short representation if there are consecutive numbers. For example, if there are three numbers such as 51, 52, and 53 in the input values, display them as 51–53 to save space. Assume that the input values are positive integers and there is no duplication in the input number list.
 * Name: Anna Bellizzi
 * Date: 11/12/2022
 */
import java.util.*;
import java.text.*;

class Main 
{  
  public static List<String> compactArray(int[] array)
  {
    List<String> result = new ArrayList<String>();
    int counter = 1;
    //start looking at the array at index 1, and while it is no larger than the arrya length
    for (int i = 1 ; i <= array.length; i++ )
      {
        //if we've come to the end of the array OR comparing current index value to
        //previous value does not equal 1 (it is not part of a range)
        if (i == array.length || array[i] - array[i - 1] != 1)
        {
          //output text to test
          //System.out.println("diff is not 1");
          if (counter == 1)
          {
            result.add(String.valueOf(array[i-counter]));
          }
          else
          {
            result.add(array[i - counter] + "-" + array[i-1]);
            //output text to test
            //System.out.println("build range");
          }
          //reset counter to calculate the next range
          counter = 1;
        }
        //otherwise do something else
        else
        {
          //incriment the counter to keep looking for the end of hte range
          counter++;
          //output text to test
          //System.out.println("diff is 1");
        }
      }
    //System.out.println(result);
    return result;
  }

  public static String printResult(List<String> myList)
  {
    //declare return value
    String result = "";
    //give array list a variable
    int k = myList.size();
    //loop through the list and assemble index values into a single string
    for (int i = 0; i < k; i++)
      {
        result = result + myList.get(i);
        //to solve for not adding a space at the end of the string to pass testing
        if (i < k - 1)
        {
          result = result + " ";
        }
      }
    System.out.println(result);
    return result;
  }

public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int myArray[] = new int[n];
        //As long as there is a user entry, write it to the array
        for (int i = 0 ; i < myArray.length; i++ )
        {
           myArray[i] = input.nextInt();
        }
        input.close();
        //Sort the user array
        Arrays.sort(myArray);

        //System.out.println(Arrays.toString(myArray));
        printResult(compactArray(myArray));
    }
}








/////FIRST ATTEMPT. INCORRECT APPROACH. KEEPING CODE FOR REFERENCE /////////////
/*    
  public static int[][] makeMatrix(int array[])
    {
    //Counter for Matrix array
    int row = 0;
    //Declaration for Matrix array
    int[][] myMatrix = new int[array.length][2];
    //loop through the user entry array
      //take the left number
      for (int i=0; i<array.length; i++)
        {
          int col = 0;
          myMatrix[i][col] = array[i];
        }
      return myMatrix;
    }

    public static void printMatrix(int matrix[][])
    {
        // Loop through all rows
        for (int[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }
    public static int[][] calcDiffs(int matrix[][])
    {
      int n = matrix.length;
      System.out.println("matrix length: " + n);
      
      for (int i=0; i<n-1; i++)
        {
          matrix[i][1] = matrix[i+1][0] - matrix[i][0];
        }
      return matrix;
    }

    public static void resultDisplay(int matrix[][])
    {
      int b = 0;
      for (int i = 0; i < matrix.length; i++)
      {
        if (matrix[i][1] == 0)
        {
          System.out.println(matrix[i][0]);
        }
        if (matrix[i][1] > 1)
        {
          System.out.println(matrix[i][0]);
        }  
        if (matrix[i][1] == 1)
        {
          //System.out.println("diff of 1");
          int a = matrix[i][0];
          
        }
      }
    }

    public static String showRange(int a, int b)
    {        
      String stringA = String.valueOf(a) + "-" + String.valueOf(b);
      return stringA;
    }
    
  
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);
        
        int n = input.nextInt();
        int myArray[] = new int[n];
        //As long as there is a user entry, write it to the array
        for (int i = 0 ; i < myArray.length; i++ )
        {
           myArray[i] = input.nextInt();
        }
        input.close();
        //Sort the user array
        Arrays.sort(myArray);

        System.out.println(Arrays.toString(myArray));

        System.out.println("Sorted Matrix: ");
        printMatrix(makeMatrix(myArray));
        System.out.println("Matrix with Diffs: ");
        printMatrix(calcDiffs(makeMatrix(myArray)));
        System.out.println("Print results: ");
        resultDisplay(calcDiffs(makeMatrix(myArray)));

    }
*/


