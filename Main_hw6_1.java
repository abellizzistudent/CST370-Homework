
/*
 * Title: Main_hw6_1.java
 * Abstract: Collect maximum number of coins on an n x m board
 * Name: Anna Bellizzi
 * Date: 12/12/2022
 */
import java.util.*; 
class Main 
{
    public static int r; //n
    public static int c; //m


    public static int checkAdj(String c, int i, int j, int myArray[][])
    {
      int celVal = 0;
      
        if (c.equals("left"))
          {
            celVal = myArray[i][j-1];
          }
      
          if (c.equals("top"))
          {
            celVal = myArray[i-1][j];
          }
        
      return celVal;  
    }

     public static void backtrack(int[][] myArray)
      {
      //System.out.println("Input Array should be collected Coins matrix: ");
      //printMatrix(myArray);
      int numRows = myArray.length - 1;
      int numCols =  myArray[0].length - 1;
      int left = 0;
      int top = 0;
      int i = numRows;
      int j = numCols;

      String out = "";
      
        while ( j != 1 && i != 1)
        {
              left = checkAdj("left", i, j, myArray);
              top = checkAdj("top", i, j, myArray);
                
                if (top > left)
                {
                    if (i == numRows && j == numCols)
                    {
                      out = "("+i+","+j+")" + out;
                    }
                    else
                    {
                      out = "("+i+","+j+")->" + out;
                    }
                  i--;  
                }
  
                if (left == top)
                {
                  if (i == numRows && j == numCols)
                    {
                      out = "("+i+","+j+")" + out;
                    }
                    else
                    {
                      out = "("+i+","+j+")->" + out;
                    }
                  j--;
                }
                if (left > top)
                {
                  if (i == numRows && j == numCols)
                    {
                      out = "("+i+","+j+")" + out;
                    }
                    else
                    {
                      out = "("+i+","+j+")->" + out;
                    }
                  j--;
                }
        } 

        boolean mark = true;
        while (mark == true)
        {
          if (j == 1)
          {
            if (i == 1)
            {
              mark = false;
            }
            if (i == numRows && j == numCols)
                    {
                      out = "("+i+","+j+")" + out;
                    }
                    else
                    {
                      out = "("+i+","+j+")->" + out;
                    }
            i--;
          }
          
          if (i == 1)
          {
            if (j == 1)
            {
              mark = false;
            }
            if (i == numRows && j == numCols)
                    {
                      out = "("+i+","+j+")" + out;
                    }
                    else
                    {
                      out = "("+i+","+j+")->" + out;
                    }
            j--;
          } 
        }
      System.out.println("Max coins:" + myArray[numRows][numCols]);
      System.out.println("Path:" + out);
    }

  
    public static int[][] collectCoins(int[][] myArray)
    {
      int a = myArray[0].length;
      int b =  myArray.length;
      int left = 0;
      int top = 0;
      
      for (int i=1; i < b; i++)
        {
        for (int j=1; j < a; j++)
          {
            left = checkAdj("left", i, j, myArray);
            top = checkAdj("top", i, j, myArray);
            if (left >= top)
            {
              myArray[i][j] = left + myArray[i][j];
            }
            if (left < top)
            {
              myArray[i][j] = top + myArray[i][j];
            }
          }
        } 
        //System.out.println("coins collected matrix: ");
        //printMatrix(myArray);
      return myArray;
     // System.out.println("row length (num cols) = " + a);
     // System.out.println("col length (num rows) = " + b);
    }
  
    //////////////HELPER FUNCTIONS////////////////////
    public static void printMatrix(int matrix[][])
    {
        // Loop through all rows
        for (int[] row : matrix)
        {
          // converting each row to string and print
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[][] printHelper(int matrix[][], int dummyLoad)
    {
      for (int j = 0; j < c+1; j++)
          {
             matrix[0][j] = dummyLoad;
          }
        for (int i = 0; i < r+1; i++)
          {
             matrix[i][0] = dummyLoad;
          }
      return matrix;
    }
  
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        // get number of elements that the user will enter on the next line
        
        r = input.nextInt();
        c = input.nextInt();
        int[][] myMatrix = new int[r+1][c+1];

        for (int i = 1; i < myMatrix.length; i++)
        {
          for (int j = 1; j < myMatrix[i].length; j++)
          {
             myMatrix[i][j] = input.nextInt();
          }
        }
        input.close();
      
        backtrack(collectCoins(myMatrix));
    }
}

