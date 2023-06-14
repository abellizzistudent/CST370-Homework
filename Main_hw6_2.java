/*
 * Title: Main_hw6_2.java
 * Abstract: Implements the Floyd algorithm to display all-pairs shortest paths
 * Name: Anna Bellizzi
 * Date:12/13/2022
 */

import java.util.*;  
class Main 
{
    public static int v; 

    public static void floydAlgorithm(int myMatrix[][])
    {
      for (int k = 0; k < v; k++)
        {
          for (int i = 0; i < v; i++)
            {
              for (int j = 0; j < v; j++)
                {
                  if (myMatrix[i][j] > myMatrix[i][k] + myMatrix[k][j])
                  {
                    myMatrix[i][j] = myMatrix[i][k] + myMatrix[k][j];
                  }
                }
            }
        }
      //System.out.println("new matrix after applying algorithm: ");
      printMatrix(myMatrix);
    }

    public static void printResult(int myMatrix[][])
    {
        // Loop through all rows
        for (int i = 0; i < v; ++i)
          {
            for (int j = 0; j < v; ++j)
              {
                if (myMatrix[i][j] == -1)
                {
                  System.out.print(-1);
                }
                else
                {
                  System.out.print(myMatrix[i][j]+" ");
                }
                System.out.println();
              }
          }
    }

    
    
    
    ////////////HELPER FUNCTION //////////////////////
    public static void printMatrix(int matrix[][])
    {
        // Loop through all rows
        for (int[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }

  
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // get number of elements that the user will enter on the next line
        
        v = input.nextInt();

        int[][] myMatrix = new int[v][v];

        for (int i = 0; i < myMatrix.length; i++)
        {
          for (int j = 0; j < myMatrix[i].length; j++)
          {
             myMatrix[i][j] = input.nextInt();
          }
        }
        
        input.close();
        //printMatrix(myMatrix);
        floydAlgorithm(myMatrix);
    }
}

