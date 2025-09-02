package project;

import java.util.Random;

/**
 * This class provide methods to check for transmission errors and checking the parity
 *
 * @author muhammadnaseem
 * @version Apr 21, 2025
 *
 */
public class ParityCheck {

    /**
     * generating number of 1's and zero within the given length
     *
     * @param length length of binary string
     * @return generated random binary string
     */
    public String generateRandomBinary(int length) {
        if (length < 5 || length > 64) {
            throw new IllegalArgumentException("Length is outside the given range.");
        }
        Random rand = new Random();
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            binary.append(rand.nextBoolean() ? '1' : '0');
        }
        return binary.toString();
    }

    /**
     * In this I am using random position to cause an error by switching 0 with 1
     *
     * @param binary the original binary string
     * @param probability the probability of introducing an error
     * @return String after error has been introduced
     */
    public String introduceError(String binary, double probability) {
        if (probability < 0.00 || probability > 100.00) {
            throw new IllegalArgumentException("The probability is outside the given range.");
        }
        Random randError = new Random();
        StringBuilder corrupted = new StringBuilder(binary);

        for (int i = 0; i < corrupted.length(); ++i) {
            if (randError.nextDouble() * 100 < probability) {
                char current = corrupted.charAt(i);
                corrupted.setCharAt(i, (current == '0') ? '1' : '0'); // fix: '0' not 0
            }
        }

        return corrupted.toString();
    }

    /**
     * calculating the number of 1.
     *
     * @param binaryString the binary string to check for parity or hamming weight
     * @return the number of 1's in the string
     */
    public int hammingWeight(String binaryString) {
        int numberOf1 = 0;
        for (int i = 0; i < binaryString.length(); ++i) {
            if (binaryString.charAt(i) == '1') {
                numberOf1++;
            }
        }
        return numberOf1;
    }

    /**
     * checking if it is a even parity or a odd parity
     *
     * @param binaryString the binary string to check for parity or hamming weight
     * @return true if 1 is even otherwise false
     */
    public boolean checkParity(String binaryString) {
        int count = 0;
        for (int i = 0; i < binaryString.length(); ++i) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count % 2 == 0;
    }

    /**
     * detecting the error between the transmitted data and received data.
     *
     * @param transmitted the original transmitted binary string
     * @param received the received binary string after errors
     * @return true if error is detected
     */
    public boolean detectError(String transmitted, String received) {
        return checkParity(transmitted) != checkParity(received);
    }

    public String toString() {
        return "ParityCheck utility class";
    }

}
