package project;

import java.util.Scanner;

/**
 * This class is running the parity check to see if error is been made while transfer.
 *
 * @author muhammadnaseem
 * @version Apr 21, 2025
 *
 */
public class ParityCheckTest {

    /**
     * A main method which calls ParityCheck class and outputs the data
     *
     * @param args None
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ParityCheck check = new ParityCheck();

        System.out.print("Enter the length of binary string: ");
        int length = input.nextInt();

        System.out.println("Enter error probability: ");
        double probility = input.nextDouble();

        String transmitted = check.generateRandomBinary(length);
        String received = check.introduceError(transmitted, probility);

        boolean transmittedParity = check.checkParity(transmitted);
        boolean errorDetected = check.detectError(transmitted, received);

        System.out.println("Transmitted Data: " + transmitted);
        System.out.println(
            "Parity of Transmitted Data: " + (transmittedParity ? "Even Parity" : "Odd Parity"));

        System.out.println("\nReceived data: " + received);
        System.out.println("Error Detected: " + (errorDetected ? "Yes" : "No"));

        input.close();

    }

}
