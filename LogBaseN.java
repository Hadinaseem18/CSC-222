package assignment.module4;

import java.util.Scanner;

/**
 * We are solving the logarithms
 * 
 *
 * @author muhammadnaseem
 * @version Mar 22, 2025
 *
 */
public class LogBaseN {
    private static final int maxAttempts = 10;
    private static String[][] logResults = new String[maxAttempts][2];
    private static int attemptCount = 0;
    private static final char[] subscripts = { '\u2080', '\u2081', '\u2082', '\u2083', '\u2084',
        '\u2085', '\u2086', '\u2087', '\u2088', '\u2089' };

    /**
     * This is the main method where I am using max attempts to get put max attempts to 10
     *
     * @param args NONE
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (attemptCount < maxAttempts) {
            String inputResult = getInput(scanner);
            if (inputResult == null)
                continue;

            String[] inputs = inputResult.split(",");
            int number = Integer.parseInt(inputs[0]);
            int base = Integer.parseInt(inputs[1]);

            int logValue = computeLog(number, base, 0);
            String formattedLog = "log" + getSubscript(base) + " " + number;
            String formattedResult = String.valueOf(logValue);
            logResults[attemptCount][0] = formattedLog;
            logResults[attemptCount][1] = formattedResult;
            attemptCount++;
            System.out.println(formattedLog + " = " + formattedResult);

            if (attemptCount < maxAttempts) {
                System.out.println((maxAttempts - attemptCount) + " attempts left");
                System.out.println(
                    "Would you like to input another pair of numbers?\n\"y\" for yes or \"n\" for no.");
                char choice = scanner.next().charAt(0);
                if (choice == 'n' || choice == 'N') {
                    break;
                }
            }
        }
        scanner.close();
        displayResults();
        System.out.println("Goodbye!");
    }

    /**
     * I am getting inputs for calculations
     *
     * @param input for calculation
     * @return string of inputs
     */
    public static String getInput(Scanner input) {
        System.out.print("Input a number to find the integer log of: ");
        int argument = input.nextInt();
        System.out.print("Input the base for calclation: ");
        int base = input.nextInt();

        if (argument <= 0) {
            System.out.println("Logarithm of negative numbers or zero is undefined");
            return null;
        } else if (argument >= 1_000_000) {
            System.out.println("Invalid argument for calculation");
            return null;
        } else if (base < 2 || base > 10) {
            System.out.println("Invalid base. Base must be between 2 and 10");
            return null;
        }
        return argument + "," + base;
    }

    private static int computeLog(int number, int base, int count) {
        if (number < base) {
            return count;
        }
        return computeLog(number / base, base, count + 1);
    }

    private static String getSubscript(int number) {
        StringBuilder subscript = new StringBuilder();
        for (char digit : String.valueOf(number).toCharArray()) {
            subscript.append(subscripts[digit - '0']);
        }
        return subscript.toString();
    }

    private static void displayResults() {
        if (attemptCount == 0) {
            System.out.println("No successful attempts.");
            return;
        }
        System.out.println("\nSuccessful attempts at calculating logarithmic values:");
        System.out.println("--------------------");
        System.out.printf("%.10s %.5s%n", "Problem", "Result");
        System.out.println("--------------------");
        for (int i = 0; i < attemptCount; i++) {
            System.out.printf("%.10s %5s%n", logResults[i][0], logResults[i][1]);
        }
        System.out.println("--------------------");
    }
}
