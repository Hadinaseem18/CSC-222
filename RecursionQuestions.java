/**
*
*/
package exam2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Complete the solution for ANY TWO methods Please do not modify the main method. The contents of
 * the main method will be used to grade your solution
 *
 * The output for each of the methods is provided in the question in Canvas Each method you attempt
 * must use recursive logic.
 *
 * The solutions will be considered incorrect if any loop is used
 *
 * @author muhammadnaseem:
 * @version Exam 2 Spring 25
 *
 */
public class RecursionQuestions {
    /**
     * main method
     *
     * @param args None
     */
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
            Arrays.asList("She called My number this morning".split("\\s")));
        filterWords(words, 0);
        System.out.println("Filtered words: " + String.join(" ", words) + "\n");
        System.out.println("=".repeat(70) + "\n");
        List<String> yodasWords = new ArrayList<>(
            Arrays.asList("must Named fear your before be it banish canyou".split("\\s")));
        flipper(yodasWords, 0);
        System.out.println("Flipped words: " + String.join(" ", yodasWords) +
            "\n");
        System.out.println("=".repeat(70) + "\n");
        System.out.println("a2cd4e5 decoded is " + decode("a2cd4e5") + "\n");
        System.out.println("=".repeat(70) + "\n");
        ArrayList<Integer> nums1 = new ArrayList<>(List.of(-1, 2, 3, 4, 5, 2, 8));
        int[] result = findLargestSum(nums1, 0, nums1.size() - 1, new int[2]);
        System.out.println("Pair with largest sum in : " + Arrays.toString(result)
            + "\n");
    }

    /**
     *
     * Filter words from a list where the ASCII value of the first character of the word is
     * divisible by 11. Recursive logic to remove all words from the list that satisfy the above
     * constraint.
     *
     * @param words
     * @param index
     */
    private static void filterWords(List<String> words, int index) {
        if (index > words.size()) {
            return;
        }
        String word = words.get(index);
        if (!words.isEmpty() && word.charAt(0) % 11 == 0) {
            words.remove(index);
            filterWords(words, index);
        } else {
            filterWords(words, index + 1);
        }

    }

    /**
     *
     * This method takes as input a list of strings and modifies it IN PLACE as follows: the first
     * input element becomes the second output element and the second input element the first output
     * element, the third input element becomes the fourth output element and the fourth input
     * element the third output element, and so on.
     *
     * If the input list has no other element with which to flip the last element, then it should
     * remain in its initial position.
     *
     * You are not allowed to create a new list.
     *
     * @param wordList
     * @param index
     */
    private static void flipper(List<String> wordList, int index) {
        if (index >= wordList.size() - 1) {
            return;
        }

        String input = wordList.get(index);
        wordList.set(index, wordList.get(index + 1));
        wordList.set(index + 1, input);

        flipper(wordList, index + 2);
    }

    /**
     *
     * Decodes a custom encoded string where a letter may be followed by a single digit indicating
     * how many times the letter should be repeated.
     *
     * If a letter is not followed by a digit, it is included once in the output. The method uses
     * recursion to process the string safely and avoids index out-of-bounds exceptions by checking
     * string length before accessing characters.
     *
     * Examples: decode("a3b2") → "aaabb" decode("ab2c3") → "abbccc" decode("x4yz") → "xxxxyz"
     * decode("q") → "q" decode("") → ""
     *
     * @param encoded
     * @return String
     */
    private static String decode(String encoded) {
        if (encoded.isEmpty()) {
            return "";
        }
        char current = encoded.charAt(0);
        if (encoded.length() > 1 && Character.isDigit(encoded.charAt(1))) {
            int count = Character.getNumericValue(encoded.charAt(1));
            String repeated = String.valueOf(current).repeat(count);

            return repeated + decode(encoded.substring(2));

        } else {
            return current + decode(encoded.substring(1));
        }
    }

    /**
     *
     * Recursively finds the pair of values from the ends of the input ArrayList that yields the
     * largest sum, considering pairs (first, last), (index 1, index last - 1), and so on. *
     *
     * @param numbers
     * @param left
     * @param right
     * @param largestPair
     * @return int[]
     */
    private static int[] findLargestSum(ArrayList<Integer> numbers, int left, int right,
        int[] largestPair) {
        if (left > right) {
            return largestPair;
        }
        int sum = numbers.get(right) + numbers.get(left);
        int currentLargest = largestPair[0] + largestPair[1];

        if (sum > currentLargest) {
            largestPair[0] = numbers.get(left);
            largestPair[1] = numbers.get(right);

        }

        return findLargestSum(numbers, left + 1, right - 1, largestPair);
    }
}
