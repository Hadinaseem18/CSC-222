/**
 * 
 */
package assignment.module4;

import java.util.Scanner;

/**
 * This class consists of 3 recursive methods that must be implemented. The details are provided in
 * the javadoc for each method. Please implement the logic and submit the file.
 * 
 * Any method not implemented must be left as is
 * 
 * Note:
 * 
 * 1. the file must be formatted before uploading.
 * 
 * 2. Please read assignment instructions about formatting in Eclipse.
 * 
 * 3. If you have any specific explanation to add to each method, please add it to the method's
 * javadoc and NOT as line comments
 * 
 * 4. Please DO NOT change the main method.
 *
 * 
 * @author csc 222
 * @version module 4 assignment
 *
 */
public class RecursionExercises {

    private static Scanner input = new Scanner(System.in);

    /**
     * main method
     *
     * @param args None
     */
    public static void main(String[] args) {

        System.out.println("Recursion Exercises...\n");

        System.out.print("Input a number: ");
        int number = input.nextInt();
        double goldenRatio = calculateGoldenRatio(number);
        System.out.printf("Golden Ratio converges to: %.2f\n", goldenRatio);

        System.out.print("\nInput the base: ");
        double base = input.nextDouble();
        System.out.print("Input the exponent: ");
        double exponent = input.nextDouble();
        double result = calculateExponentialValue(base, exponent);
        System.out.println(formatResult(base, exponent, result));

        System.out.println("\nFormatted haiku: ");
        formatPoem(args[0].split(" "), 0);
        input.close();
    }

    /**
     * 
     * Recursive method to calculate the golden ratio given a number The Golden Ratio can be
     * calculated as f(n) = 1 + 1/(f(n - 1) where n is the number provided. More information about
     * the Golden Ratio is available at https://en.wikipedia.org/wiki/Golden_ratio
     *
     * @param number
     * @return double
     */
    private static double calculateGoldenRatio(int number) {
        if (number == 0) {

            return 1.0;

        }
        return 1 + 1 / (calculateGoldenRatio(number - 1));

    }

    /**
     * 
     * Recursive method to calculate the exponential value of a number
     *
     * @param base
     * @param exponent
     * @return double
     */
    private static double calculateExponentialValue(double base, double exponent) {
        if (exponent == 0) {
            return 1.0;
        } else if (exponent < 0) {
            return 1 / calculateExponentialValue(base, -exponent);
        }
        return base * calculateExponentialValue(base, exponent - 1);

    }

    /**
     * 
     * Format the result and return the String containing the output String.
     * 
     * A char array of unicode values is provided. You must use array indexing to get the relevant
     * character for the format of the exponent. Please DO NOT use an if statement for this.
     * 
     * If the exponent is negative, then the negative sign must also be included the unicode for the
     * negative sign is "\u207B"
     *
     * @param base
     * @param exponent
     * @param result
     * @return String
     */
    private static String formatResult(double base, double exponent, double result) {

        char[] superscripts = { '\u2070', '\u00B9', '\u00B2', '\u00B3', '\u2074', '\u2075',
            '\u2076', '\u2077', '\u2078', '\u2079' };

        int exp = (int) exponent;

        StringBuilder expFormatted = new StringBuilder();

        if (exp < 0) {
            expFormatted.append('\u207B');
            exp = -exp;
        }

        String expStr = Integer.toString(exp);
        for (char c : expStr.toCharArray()) {
            expFormatted.append(superscripts[c - '0']);
        }

        return String.format("%.0f%s = %.0f", base, expFormatted, result);
    }

    /**
     * Recursive method to format and display the provided String array Some of the words have a ':'
     * as the last character. This should be substituted with a \n to indicate the end of the line
     * The returned String when displayed will be:
     * 
     * Why doesnt this work Checked the syntax ninety times Oh one missed bracket
     * 
     * More information about haiku at https://www.britannica.com/art/haiku
     *
     * @param haiku the string containing the unformatted haiku
     * @param index starting index
     * @return String
     */
    private static String formatPoem(String[] haiku, int index) {
        if (index >= haiku.length) {
            return "";
        }
        String word = haiku[index];
        return word + " " + formatPoem(haiku, index + 1);

    }

}
