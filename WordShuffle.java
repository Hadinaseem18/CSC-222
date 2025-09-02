package exam;

import java.util.Scanner;

/**
 * We are shuffling the string in this program
 * 
 * 
 *
 * @author muhammadnaseem
 * @version Mar 13, 2025
 *
 */
public class WordShuffle {

    /**
     * we are shuffling the word
     *
     * @param args None
     */
    public static void main(String[] args) {
        String word = getInput();

        String shuffleWord = shuffleWords(word);
        System.out.println("Result of Shuffle: " + shuffleWord);
    }

    /**
     * getting inputs
     *
     * @return inputs
     */
    @SuppressWarnings("resource")
    public static String getInput() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input word: ");
        String word = input.nextLine();

        if (word.length() >= 4 && word.length() % 2 == 0) {
            return word;
        } else {
            System.out.println("String length is invalid");
            input.close();
            return "";

        }
    }

    private static String shuffleWords(String word) {
        int midString = word.length() / 2;
        StringBuilder shuffled = new StringBuilder();

        for (int i = 0; i < midString; i++) {
            shuffled.append(word.charAt(i + midString));
            shuffled.append(word.charAt(i));
        }

        return shuffled.toString();
    }
}
