/*
 * Title: Main_hw4_3.java
 * Abstract: Conducts a topological sorting based on the Kahn algorithm. This does not fulfil; the assignment requirement, however it wil ltake a user input per hte spec, and print the adjacency matrix to the console.
 * Name: Anna Bellizzi
 * Date: 11/29/2022
 */
 import java.util.*;
class Main 
{ 
  
        
    public void sort(int[][] adjMat, int n)
    {
      int inDeg[] = new int[n];
      
      for (int i = 0; i < n; i++)
        {
         // ArrayList<Integer> temp = (ArrayList<Integer>) adjMat[i];
         // for (int node : temp)
            {
          //    inDeg[node]++;
            }
        }
      Queue<Integer> stack = new LinkedList<Integer>();
      for (int i = 0; i < n; i++)
        {
          if (inDeg[i] == 0)
            {
              stack.add(i);
            }
        }
      
    }

  
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int[][] adjMat = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++)
        {
            int u = input.nextInt();
            int v = input.nextInt();
            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }
        /*
        final int V = input.nextInt();  //NUMBER OF VERTICES
        final int E = input.nextInt();  //NUMBER OF EDGES

        Graph myGraph = new Graph(E);
        
        for (int i = 0 ; i < E; i++ )
        {
            i = input.nextInt();
            j = input.nextInt();
            myGraph.addUserEdge(i,j);
        }
        */
        input.close();
      printMatrix(adjMat);
    }



    //TESTING HELPER FUNCTION
    public static void printMatrix(int matrix[][])
    {
        // Loop through all rows
        for (int[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }
}

