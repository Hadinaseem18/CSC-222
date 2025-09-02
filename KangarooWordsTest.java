package assignment.module5;

import java.util.Scanner;

public class KangarooWordsTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Searching for Kangaroo words...\n");

        boolean continueSearching = true;

        while (continueSearching) {
            System.out.print("Input words separated by a space: ");
            String input = scanner.nextLine().trim().toLowerCase();

            if (input.isEmpty()) {
                System.err.println("Input cannot be empty.");
                continue;
            }

            String[] words = input.split("\\s+");
            if (words.length < 2) {
                System.err.println("Please enter at least a kangaroo word and one joey word.");
                continue;
            }

            KangarooWords kangarooWords = new KangarooWords();
            kangarooWords.setKangarooWord(words[0]);
            kangarooWords.setJoeyWord(words[1]);

            if (words.length > 2) {
                kangarooWords.setTwinJoeyWord(words[2]);
            }

            if (kangarooWords.isGrandKangarooWord()) {
                System.out.println("Grand Kangaroo Word");
            } else if (kangarooWords.isTwinKangarooWord()) {
                System.out.println("Twin Kangaroo Word");
            } else if (kangarooWords.isKangarooWord()) {
                System.out.println("Kangaroo Word");
            } else {
                System.out.println("Invalid Kangaroo Word");
            }
            System.out.print("\nContinue? (Y/N): ");
            String response = scanner.nextLine().trim().toLowerCase();
            if (!response.equals("y")) {
                continueSearching = false;
            }
        }

        System.out.println("Goodbye!");
        scanner.close();
    }
}
