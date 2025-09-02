package projects;

import java.util.Scanner;

/**
 * We are finding whether a number is palindromic base ten and ternary
 * 
 * 
 *
 * @author muhammadnaseem
 * @version Mar 18, 2025
 *
 */
public class MultiBasePalindromes {

    /**
     * This is the main method calling all the methods.
     *
     * @param args none
     */
    public static void main(String[] args) {
        long[] limits = getInput();
        if (limits != null) {
            displayPalindromesInBothBases(limits[0], limits[1]);
        }
    }

    /**
     * Place a description of your method here.
     *
     * @return inputs
     */
    public static long[] getInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input a lower limit: ");
        long lowerLimit = input.nextLong();
        System.out.print("Input an upper limit: ");
        long upperLimit = input.nextLong();
        input.close();
        if (lowerLimit < 0 || upperLimit < 0) {
            System.out.println("Invalid value");
            return null;
        } else if (lowerLimit > upperLimit) {
            System.out.println("Upper limit must be greater than lower limit");
            return null;
        } else if (upperLimit >= 1e12) {
            System.out.println("Upper limit must be less than 10^12");
            return null;
        }
        return new long[] { lowerLimit, upperLimit };
    }

    /**
     * I am displaying the output
     * 
     * @param lower none
     * @param upper none
     */
    public static void displayPalindromesInBothBases(long lower, long upper) {
        System.out.println("\nPalindromic numbers in base 10 and ternary are\n");
        System.out.println("Base   |   Base");
        System.out.println("10     |   3");
        System.out.println("-------|-------");

        for (long i = lower; i <= upper; i++) {
            if (isPalindromicBaseTen(i)) {
                String ternary = convertToTernary(i);
                if (isPalindromicTernary(ternary)) {
                    displayOutput(i, ternary);
                }
            }
        }
    }

    /**
     * Using mathematical equation to check if the last and first digit of a number is same
     *
     * @param number checking whether it is Palindromic base ten
     * @return boolean
     */
    public static boolean isPalindromicBaseTen(long number) {
        long reversed = 0;
        long original = number;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return original == reversed;
    }

    /**
     * I am using String builder to convert base ten number to ternary and returning the value as
     * string
     *
     * @param baseTenNum a number which has a base as 10
     * @return ternary value in string form
     */
    public static String convertToTernary(long baseTenNum) {
        if (baseTenNum == 0)
            return "0";

        StringBuilder ternary = new StringBuilder();
        while (baseTenNum > 0) {
            ternary.append(baseTenNum % 3);
            baseTenNum /= 3;
        }
        return ternary.reverse().toString();
    }

    /**
     * Place a description of your method here.
     *
     * @param ternaryValue of base 10
     * @return true or false
     */
    public static boolean isPalindromicTernary(String ternaryValue) {
        int leftEnd = 0;
        int rightEnd = ternaryValue.length() - 1;
        while (leftEnd < rightEnd) {
            if (ternaryValue.charAt(leftEnd) != ternaryValue.charAt(rightEnd)) {
                return false;
            }
            leftEnd++;
            rightEnd--;
        }
        return true;
    }

    /**
     * formatting a string 
     *
     * @param baseTen none
     * @param ternary none
     */
    public static void displayOutput(long baseTen, String ternary) {
        System.out.printf("%-6d | %s\n", baseTen, ternary);
    }
}
