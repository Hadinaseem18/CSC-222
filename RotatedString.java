package assignment.module2;

import java.util.Scanner;

/**
 * We are checking if two strings are rotation of each other or no purpose and how to use it.
 *
 * @author muhammadnaseem
 * @version Mar 3, 2025
 *
 */
public class RotatedString {

    /**
     * Place a description of your method here.
     *
     * @param args none
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Input the first string: ");
        String firstString = input.next();

        System.out.print("Input the second string: ");
        String secondString = input.next();

        firstString = firstString.toUpperCase();
        secondString = secondString.toUpperCase();

        if (firstString.length() != secondString.length()) {
            System.out.println("The two strings are not of equal length");
            System.out.println("Goodbye");

        } else if ((firstString + firstString).contains(secondString)) {
            System.out.println(secondString + " is a rotation of " + firstString);
            System.out.print("Success");

        } else {
            System.out.println(secondString + " is not a rotation of " + firstString);
            System.out.print("Goodbye");
        }
        input.close();
    }

}
