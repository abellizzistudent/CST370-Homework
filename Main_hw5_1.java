/*
 * Title: Main_hw5_1.java
 * Abstract: Program conducts heap operations based on user input.
 * Name: Anna Bellizzi
 * Date: 12/5/2022
 */

import java.util.*;

class Main 
{
    //int size;
    static int[] theHeap;
    static boolean prevHeap = true;


    //HEAPIFY OPERATION
    public static void heapify(int[] myArray)
    {
      prevHeap = true;
      for (int i = (myArray.length - 1)/2; i >= 1; i--)
        {
          int j = i;
          int temp = myArray[j];
          boolean isHeap = false;
    
      //whatever is swapped, keep moving down to the end
		 //once in the loop, j is the parent node
          
          while (isHeap != true && 2 * j <= myArray.length - 1)
            {
              int k = 2 * j;
              if (k < myArray.length - 1)
              {
                if (myArray[k] < myArray[k + 1])
                {
                  k = k + 1;
                }
              }
              if (temp >+ myArray[k])
              {
                isHeap = true;
              }
              else
              {
                myArray[j] = myArray[k];
                j = k;
                myArray[j] = temp;
              }
              if (isHeap == false) //only if it made a swap
              {
                prevHeap = false;
              }
            }
        }
    }

    //FIND THE MAX VALUE AND RETURN
    public static int displayMax(int myArray[])
    {
      int max = myArray[1];
      return max;
    }

    public static void deleteMax(int myArray[])
    {      
      
      int tempArray[] = new int[myArray.length - 1];
      //System.out.println("create temp array");
      //System.out.println("tempArray length: " + tempArray.length + " myArray length: " + myArray.length);
      //Copy values to indexes
      for (int i = 2; i < myArray.length - 1; i++)
        {
          tempArray[i] = myArray[i];
        }
      tempArray[1] = myArray[myArray.length - 1];
      //System.out.println("copy my array index values to temparray. display temp then display myarray:");
      //display(tempArray);
      //display(myArray);
      //System.out.println("tempArray length: " + tempArray.length + " myArray length: " + myArray.length);
      theHeap = new int[tempArray.length];
      for (int i = 1; i < tempArray.length; i++)
        {
          theHeap[i] = tempArray[i];
        }
      //System.out.println("copy temp array back into theHeap array");
      //System.out.println("tempArray length: " + tempArray.length + " myArray length: " + myArray.length);
      heapify(theHeap);
    }

    // PRINT AN ARRAY
    public static void display(int array[])
    {
      for (int i = 1; i < array.length; i++)
        {
            System.out.print(array[i]);
            if (i < array.length -1)
            {
              System.out.print(" ");
            }
        }
        System.out.println();
    }

 
    // PARSE THE VALUE TO INSERT INTO AN INT FROM THE STRING
    // USE A TEMPORARY ARRAY TO EXPAND AND INSERT THE NEW VALUE
    public static void insert(int[] array, String insertVal) //insert the heap array and string value from command array
    {
      String numberOnly = insertVal.replaceAll("[^0-9]", "");
      int insertThisNum = Integer.parseInt(numberOnly);
      //System.out.println("insert entered. insert value is: " + i);
      int tempArray[] = new int[array.length + 1];
      for (int i = 1; i < (tempArray.length - 1); i++)
        {
          tempArray[i] = array[i];
        }
        tempArray[tempArray.length-1] = insertThisNum;
        heapify(tempArray);
        theHeap = new int[tempArray.length];

      for (int i = 1; i < theHeap.length; i++)
        {
          theHeap[i] = tempArray[i];
        }     
    }
      
    public static void main(String[] args)
    {
      Scanner input = new Scanner(System.in);

        // get number of elements that the user will enter on the next line
        int n = input.nextInt();
        // instantiate array to fill with user input

        theHeap = new int[n + 1];
        //write user entry to the array
        for (int i = 1 ; i < theHeap.length ; i++ )
        {
           theHeap[i] = input.nextInt();
        }
        //Number of user commands that will be entered
        int c = input.nextInt();
      
        //instantiate array to hold user commands
        String cmdArray[] = new String[c];

        input.nextLine();
      
        //write user entry to the array
        for (int i = 0 ; i < cmdArray.length; i++ )
        { 
          cmdArray[i] = input.nextLine();
        }

        input.close();
        
        heapify(theHeap);
      
        if (prevHeap == true)
        {
          System.out.println("This is a heap.");
        }
        if (prevHeap == false)
        {
          System.out.println("This is NOT a heap.");
        }
        //Check user entered command array, and go to appropriate function for each command
        for (int i = 0 ; i < cmdArray.length; i++ )
        {
          String Str = new String(cmdArray[i]);
          boolean matchInsert = Str.matches("insert(.*)");
          boolean matchDispMax = Str.matches("displayMax");
          boolean matchDelMax = Str.matches("deleteMax");
          boolean matchDisp = Str.matches("display");
          if (matchInsert == true)
          {
            //Function takes the string at the current index if it matches "insert" and value will be parsed out
            insert(theHeap, cmdArray[i]);
          }
          if (matchDispMax == true)
          {
            System.out.println(displayMax(theHeap));
          }
          if (matchDelMax == true)
          {
            deleteMax(theHeap);
          }
          if (matchDisp == true)
          {
            display(theHeap);
          }
        }
    }
}


