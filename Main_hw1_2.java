/*
 * Title: Main_hw1_2.java
 * Abstract: Checks to see if a user input is a pallindrome. Exclude special characters and do not consider letter case.
 * Name: Anna Bellizzi
 * Date: 10/31/2022
 */
import java.util.*;

class Main 
{
    
  public static String parseString(String userIn)
  {
    String parsed = userIn.replaceAll("[^a-zA-Z0-9]","");
    String stringParsed = parsed.toUpperCase();
    return stringParsed;
  }

  public static String reverseString(String stringParsed)
  {
    // Store the reversed string
    String reversed = "";
    String stringReversed = "";
 
    for (int i = stringParsed.length() - 1; i >= 0; i--) 
    {
      reversed = reversed + stringParsed.charAt(i);
      stringReversed = reversed.toUpperCase();
    }
    return stringReversed;
  }

  public static String compareStrings(String a, String b)
  {
    Boolean resultBool = false;
    String result = "FALSE";
    // Check strings
    if (a.equals(b))
    {
      resultBool = true;
      result = "TRUE";
    }
    return result;
  }
  
  public static void printStrings(String a, String b, String c, String d)
    {
      //System.out.println("UserIn is: " + a);  // Output user input
     // System.out.println("stringParsed is: " + b);  //output string with letters only
      //System.out.println("stringReversed is: " + c);   //output reversed string
      System.out.println(d);   //output palindrome state
    }

    public static void main(String[] args)
    {
    Scanner input = new Scanner(System.in);  // Create a Scanner object
    String userIn = input.nextLine();  // Read user input
    input.close();

    String stringParsed = parseString(userIn);
    String stringReversed = reverseString(stringParsed);
    printStrings(userIn, stringParsed, stringReversed, compareStrings(stringParsed, stringReversed));
    }
}

