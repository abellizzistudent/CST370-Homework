/*
 * Title: Main_hw3_3.java
 * Abstract: The program should impliment the DFS algorithm and output the mark array of the DFS.
This program is incomplete. While I understand the mechanics of DFS, implimenting it programmatically was a challenge I could not meet.
 * Name: Anna Bellizzi
 * Date: 11/15/2022
 */
import java.util.*;
import java.text.*;

class Main 
{
  
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
        
        final int V = input.nextInt();  //NUMBER OF VERTICES
        final int E = input.nextInt();  //NUMBER OF EDGES
      
        int myMatrix[][] = new int[E][2];
        //As long as there is a user entry, write it to the array
        for (int i = 0 ; i < E; i++ )
        {
          for (int j = 0; j < 2; j++) 
          {
            myMatrix[i][j] = input.nextInt();
          }
        }
        input.close();
        //PRINT FOR TESTING//
        System.out.println("Vertices: " + V);
        System.out.println("Edges: " + E);
        System.out.println("Edge List: ");
        printMatrix(myMatrix);
    }
}

