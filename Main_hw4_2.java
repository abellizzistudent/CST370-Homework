/*
 * Title: Main_hw4_2.java
 * Abstract: display the largest number in an array with n integer numbers using a divide-and-conquer technique.
 * Name: Anna Bellizzi
 * Date: 11/27/2022
*/

 import java.util.*;
class Main 
{
    //Helper function to call in dacForMaxVal. Returns middle index number of a series
    public static int divideSet(int i, int j)
    {
      //calculate the middpoint index number of a set of numbers: add first index val to last index val in a series then divide by 2
      int middle = (i + j) / 2;
      return middle;
    }
  
    public static int dacForMaxVal(int[] array, int i, int j)
    {
      //Check for case of having an array with array length of 1. This is eventually         left and right max after recursively dividing the main array.
      if (i == j)
      {
        return array[i];
      }
      //handle an empty array
      if (array.length == 0)
      {
        return 0;
      }
      
      //Divide into sub-problems and call recursively until two maxes are found
      //Where i is value from left, j is value from right
      
     int leftMax = dacForMaxVal(array, i, divideSet(i,j));
     int rightMax = dacForMaxVal(array, divideSet(i,j) + 1, j);

      //Check for the max of two maxes from each half and return
      if (leftMax < rightMax)
      {
        return rightMax;
      }
      else return leftMax;
    }
  
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // get number of elements that the user will enter. n = array.length
        int n = input.nextInt();
        int myArray[] = new int[n];
        //As long as there is a user entry, write it to the array
        for (int i = 0 ; i < myArray.length; i++ )
        {
           myArray[i] = input.nextInt();
        }
        input.close();

        // method inputs represent first array index num (0) and last index num (not index values!)
        System.out.println(dacForMaxVal(myArray, 0, myArray.length - 1));
    }
}
