/*
 * Title: Main_hw4_1.java
 * Abstract: Read a number of input values and the values themselves. Then put all negative numbers in front of all positive numbers using two different methods from the study material.
 * Name: Anna Bellizzi
 * Date: 11/29/2022
 */
import java.util.*;

class Main 
{
    //Print array contents
    public static void printArray(int array[])
    {
      for (int i = 0; i < array.length; i++)
        {
            if (i < array.length - 1)
            {
            System.out.print(array[i] + " ");
            }
            else
            {
              System.out.print(array[i]);
            }
        }
    }

    //helper method for swapping values of two given indexes in an array
    public static void swapVals(int array[], int i, int j)
    {
      int temp = array[i];
      array[i] = array[j];
      array[j] = temp;
    }

    //First method of sorting, per document
    public static int[] sortArray(int array[])
    {
      int i = 0;
      int j = array.length - 1;
      
      while (i <= j)
      {
        if (array[i] < 0 && array[j] < 0)
          i++;
        
        else if (array[i] > 0 && array[j] < 0)
        {
          swapVals(array, i, j);
          j--;
          i++;
        }
        else if (array[i] > 0 && array[j] > 0)
        {
          j--;
        }
        else
        {
          i++;
          j--;
        }
      }  
          //printArray(array);
      return array;
    }

  //second method of sorting, per document
  public static int[] quickSortArray(int array[])
    {
      int j = 0;
      int end = array.length - 1;
      int i = 0;

      while (i == j)
        {
          if (array[i] > 0)
          {
            j++;
          }
          else
          {
            i++;
            j++;
          }  
        }
      while (j <= end)
      {
        if (array[j] < 0)
        {
          swapVals(array, i, j);
          i++;
          j++;
        }
        else if (array[j] > 0)
        {
          j++;
        }
      }
      //printArray(array);
      return array;
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
        //COPY THE USER INPUT ARRAY FOR USE IN SECOND SORT
        int myArray2[] = Arrays.copyOf(myArray, myArray.length);
        
          printArray(sortArray(myArray));
          System.out.println();
          printArray(quickSortArray(myArray2));
          System.out.println();

    }
}

