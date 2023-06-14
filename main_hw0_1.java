/*
 * INSTRUCTION:
 *     This is a Java staring code for hw0_1.
 *     When you finish the development, download this file.
 *     Note that the current filename is "Main.java".
 *     But rename it to "Main_hw0_1.java". Please DO NOT change
 *     the name of the main class "Main"
 *     After that, upload the renamed file on Canvas.
 */

// Finish the head comment with Abstract, Name, and Date.
/*
 * Title: hw0_1 (Java)
 * Abstract: calculate the sum and difference of two user entered numbers
 * Name: Anna Bellizzi
 * Date: 10/25/2022
 */
import java.util.*; 
class Main 
{
    public static void main(String[] args) {
        // Develop your program here.
        // The following is just a sample statement.
        //System.out.println("Hello world!");
        Scanner scan = new Scanner(System.in);//for user input
        
       // System.out.println("Enter a number:");
        int a = scan.nextInt(); //read user input
        
      //  System.out.println("Enter another number:");
        int b = scan.nextInt(); //read user input
        
        int sum = a - (-b); //add the two numbers
		int diff = a - b;
		//System.out.println(a + " " + b);
        System.out.println("SUM:" + sum);
		System.out.println("DIFF:" + diff);
    }
}

