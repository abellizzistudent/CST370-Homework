/*
 * Title: Main_hw3_2.java
 * Abstract: Read graph input from a user then present a path for the TSP problem, with an     output of the path and cost.
    This program is incomplete. While I understand the mechanics of the TSP problem, implimenting it programmatically was a challenge I could not meet.
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
      
        int myMatrix[][] = new int[E][3];
        //As long as there is a user entry, write it to the array
        for (int i = 0 ; i < E; i++ )
        {
          for (int j = 0; j < 3; j++) 
          {
            myMatrix[i][j] = input.nextInt();
          }
        }
        final int S = input.nextInt();  //STARTING VERTEX
        input.close();

        System.out.println("Vertices: " + V);
        System.out.println("Edges: " + E);
        System.out.println("Starting vertex: " + S);
        System.out.println("Edge List: ");
        printMatrix(myMatrix);
    }
}

