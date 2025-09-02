package assignment.module2;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

/**
 * Write a one-sentence summary of your class here. Follow it with additional details about its
 * purpose and how to use it.
 *
 * @author muhammadnaseem
 * @version Feb 27, 2025
 *
 */
public class PrimeTriplets {

    /**
     * Place a description of your method here.
     *
     * @param args
     */
    public static void main(String[] args) {
        // inputs
        Scanner input = new Scanner(System.in);

        System.out.println("Searching for Prime Triplets...");

        int lowerLimit;
        int upperLimit;

        while (true) {
            System.out.print("Input lower limit: ");
            lowerLimit = input.nextInt();

            System.out.print("Input upper limit: ");
            upperLimit = input.nextInt();

            // conditions

            if ((lowerLimit < 0 || upperLimit < 0) || (upperLimit < lowerLimit)) {
                System.out.print("Invlaid input!");
                continue;
            }
            break;
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);

        boolean found = false;
        for (int n = lowerLimit; n <= upperLimit; ++n) {
            if (isPrime(n) && isPrime(n + 2) && isPrime(n + 6)) {
                printWriter.print("{" + n + ", " + (n + 2) + ", " + (n + 6) + "}");
                found = true;
            }
            if (isPrime(n) && isPrime(n + 4) && isPrime(n + 6)) {
                printWriter.print("{" + n + ", " + (n + 4) + ", " + (n + 6) + "}");
                found = true;
            }
        }

        if (!found) {
            System.out.print("No prime triplet within the given range");
        }
        System.out.println(stringWriter.toString());

        input.close();
    }

    private static boolean isPrime(int num) {
        if (num < 2)
            return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0)
                return false;
        }
        return true;

    }

}
