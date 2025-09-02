package assignment.module2;
import java.util.Scanner;
/**
 * The objective of this class is to demonstrate your understanding of Java datatypes and its capabilities.
 * 
 * and how to use it.
 *
 * @author muhammadnaseem
 * @version Feb 24, 2025
 *
 */

public class DatatypeCircus {
    /**
     * main method
     *
     * @param  args None
     */
    public static void main(String[] args) {
    
     Scanner input = new Scanner(System.in);
     System.out.print("Input a base: ");
     short base = input.nextShort();
     System.out.print("Input a exponent: ");
     short exponent = input.nextShort();
     
     
     System.out.print("Input first char: ");
     char firstChar = input.next().charAt(0);
     System.out.print("Input second char: ");
     char secondChar = input.next().charAt(0);
     System.out.print("Input third char: ");
     char thirdChar = input.next().charAt(0);
     System.out.print("Input fourth char; ");
     char fourthChar = input.next().charAt(0);
     
     System.out.print("Enter a string without white space: ");
     String withoutWhiteSpace = input.next();
     input.nextLine();
     
     System.out.print("Enter a string with white space: ");
     String withWhiteSpace = input.nextLine();
     
     System.out.print("Input a string without whitespace: ");
     String secondWithoutWhiteSpace = input.next();
     input.nextLine();
     
    
     
     System.out.print("Input a float value:");
     float floatValue = input.nextFloat();
     
     System.out.print("Input first long value: ");
     long firstLong = input.nextLong();
     System.out.print("Input second long value: ");
     long secondLong = input.nextLong();
     
     System.out.print("Input a double value: ");
     double doubleValue = input.nextDouble();
     
     
     
     double result = Math.pow(base, exponent);
     System.out.println(base + "^" + exponent + "=" + result);
    
     
     double rootOfFloat = Math.sqrt(floatValue);
     System.out.print("\u221A" + floatValue);
     System.out.printf(" = %.2f", rootOfFloat);
     System.out.println();
     
     System.out.println("The concated char value after reducing each by 1 : ");
     System.out.println("" + (char) (firstChar - 1) + (char) (secondChar - 1) + (char) (thirdChar - 1) + (char) (fourthChar - 1));

     double mathematicalResult = (2*(firstLong-secondLong)/doubleValue);
     System.out.println("The result of arithmetic is = " + mathematicalResult);
     
     System.out.print("the concated String values: " + withoutWhiteSpace + " : " +  withWhiteSpace + " " + secondWithoutWhiteSpace );

     
     
     

     
     
     
     
     
     

     
     
     
     
     
     
 
     
    
     input.close();
    }
}
