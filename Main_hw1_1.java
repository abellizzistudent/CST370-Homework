/*
 * Title: Main_hw1_1.java
 * Abstract: Write a program that reads input numbers from a user and displays the closest distance between two numbers among all input numbers.
 * Name: Anna Bellizzi
 * Date: 10/31/2022
 */

import java.util.*;
import java.lang.Math;
class Main 
{  
  //Method takes the user entry array and array length n as args
  //Calculates the difference between each number in the set
  //Writes each pair and diff value in seperate rows of a 3 by X matrix
  static void myMethod(int array[], int n)
  {
    int a,b,i,j;
    int distance; // d(a,b) = |b-a|
    int x = (n*(n-1))/2;
    //Counter for Matrix array
    int row = 0;
    //Declaration for Matrix array holding pairs and differences
    int[][] distArray = new int[x][3];
    //loop through the user entry array
      //take the left number
      for (i=0; i<n; i++)
        {
        //take the right number
        for (j=i+1; j<n; j++)
          {
            if (array[i] != array[j])
            {
              int col = 0;
              distArray[row][col] = array[i];
                col++;
              distArray[row][col] = array[j];
                col++;
              distArray[row][col] = Math.abs(array[j]-array[i]);
                row++;
              //System.out.println("a: " + array[i] + " b: " + array[j] + " distance: " + distance);
            }
          }
        }
    //printMatrix(distArray);
    //Find smallest Difference(s) and print
    sortMatrix(distArray, 3);
    //System.out.println("Sorted: ");
    int comp = distArray[0][2];
    System.out.println("Min Distance:" + comp);
    sortMatrix(distArray, 1);
    printMatrix(distArray, comp);
    
    return;
  }

  static void sortMatrix(int array[][], int colNum)
  {
        Arrays.sort(array, new Comparator<int[]>()
        {
                    public int compare(int[] first, int[] second)
                    {
                          if(first[colNum-1] > second[colNum-1])
                          {
                                 return 1;
                          }
                          else return -1;
                    }
        });
    /*
    for(int i = 0; i< array.length; i++)
    {
      for (int j = 0; j < array[i].length; j++)
      {
        System.out.print(array[i][j] + " ");
      }
       System.out.println();
    } */
  }
  
  public static void printMatrix(int array[][], int comp)
  {
  //for (int[] row : array)
   // {
    //System.out.println(Arrays.toString(row));
   // }
    //start compare and print
    int numRows = array.length;
    //int comp = array[0][2];
    //System.out.println("array length: "+numRows);
    for (int row=0; row<numRows; row++)
      {
        if (comp == array[row][2])
          {
           //System.out.println("a: "+array[row][0]+" b: "+array[row][1]+" Difference: "+ array[row][2]);
           System.out.println("Pair:" + array[row][0] + " " + array[row][1]); 
          }
      }
  }  
    public static void main(String[] args) {

      //testing without having to enter numbers as a user each time
      //int[] myArray = new int[] {7, -7, 20, 8, 15, 40};
      //int n = 6; //array length, provided by user as first entry
      //System.out.println(Arrays.toString(myArray));
        //Get user entry
        Scanner input = new Scanner(System.in);
        //Write user entry to input array
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
        //Label in use for testing
        //System.out.println("Pairs and Differences:");
        //Method to pair and calculate distances per pair
        myMethod(myArray, n);
    }
}

