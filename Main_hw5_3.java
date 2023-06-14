
/*
 * Title: Main_hw5_3.java
 * Abstract: simulate the operations of linear probing
 * Name: Anna Bellizzi
 * Date: 12/6/2022
 */
import java.util.*;

class Main 
{
    static int[] theStack;

    // PARSE THE VALUE TO INSERT INTO AN INT FROM THE STRING
    public static void insert(int[] array, String insertVal)
    {
      String numberOnly = insertVal.replaceAll("[^0-9]", "");
      int insertThisNum = Integer.parseInt(numberOnly);
      //System.out.println("insert entered. insert value is: " + i);    
    }

    // PARSE THE INDEX OF THE VALUE TO DISPLAY INTO AN INT FROM THE STRING
    public static void displayStatus(int[] array, String insertVal)
    {
      String numberOnly = insertVal.replaceAll("[^0-9]", "");
      int insertThisNum = Integer.parseInt(numberOnly);
      //System.out.println("insert entered. insert value is: " + i);    
    }

    // PARSE THE INDEX OF THE VALUE TO SEARCH INTO AN INT FROM THE STRING
    public static void search(int[] array, String insertVal)
    {
      String numberOnly = insertVal.replaceAll("[^0-9]", "");
      int insertThisNum = Integer.parseInt(numberOnly);
      //System.out.println("insert entered. insert value is: " + i);    
    }
  
  
    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);

        // initial size of the hash table
        int n = input.nextInt();

        //the number of commands you have to conduct to the hash table
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
      
        //Check user entered command array, and go to appropriate function for each command
        for (int i = 0 ; i < cmdArray.length; i++ )
        {
          String Str = new String(cmdArray[i]);
          boolean matchInsert = Str.matches("insert(.*)");
          boolean matchDispStat = Str.matches("displayStatus(.*)");
          boolean matchTableSize = Str.matches("tableSize");
          boolean matchSearch = Str.matches("search(.*)");
          if (matchInsert == true)
          {
            insert(theStack, cmdArray[i]);
          }
          if (matchDispStat == true)
          {
            displayStatus(theStack, cmdArray[i]);
          }
          if (matchTableSize == true)
          {
            //
          }
          if (matchSearch == true)
          {
            search(theStack, cmdArray[i]);
          }
        }
    }
}

