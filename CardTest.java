/**
 * 
 */
package assignments.module7.inheritance;

import java.util.ArrayList;
import java.util.Scanner;

import assignments.module7.inheritancesolution.PlayingCard;

/**
 * This class tests the methods of the IndexCard, PlayingCard and BusinessCard classes
 *
 * @author Your Name
 * @version module 7
 *
 */
public class CardTest {

    private static Scanner input = new Scanner(System.in);

    private static String[][] data = {
        { "California", "Sacramento" },
        { "Texas", "Austin" },
        { "Florida", "Tallahassee" },
        { "New York", "Albany" },
        { "Illinois", "Springfield" },
        { "Pennsylvania", "Harrisburg" },
        { "Ohio", "Columbus" },
        { "Georgia", "Atlanta" },
        { "North Carolina", "Raleigh" },
        { "Michigan", "Lansing" }
    };

    /**
     * main method
     *
     * @param args None
     */
    public static void main(String[] args) {
        testParentClass();

        testPlayingCard();

        testIndexCard();

        testBusinessCard();

        input.close();
    }

    /**
     * 
     * Test the parent class methods
     *
     */
    private static void testParentClass() {
        Card blankCard = new Card("", "SMALL");
        Card plasticCard = new Card("Plastic", "SMALL");
        System.out.println(blankCard);
        System.out.println(plasticCard);
    }

    /**
     * 
     * Tests the methods of the BusinessCard class
     *
     */
    private static void testBusinessCard() {
        ArrayList<BusinessCard> myBusCards = new ArrayList<>();
        for (int count = 0; count < 100; count++) {
            myBusCards.add(new BusinessCard("Ada Lovelace", "World's First Programmer",
                "Lovelace, Babbage and Co"));
        }

        System.out.println(myBusCards.get(0));
        System.out.print("\nNumber of business cards to distribute: ");
        int count = input.nextInt();
        reduceBusinessCardCount(myBusCards, count);

        System.out.println("Remaining business cards: " + myBusCards.size());
    }

    /**
     * 
     * Tests the methods of the IndexCard class
     *
     */
    private static void testIndexCard() {
        ArrayList<IndexCard> cards = createIndexCards();
        System.out.print("\nInput number of cards to use: ");
        int count = input.nextInt();
        input.nextLine();
        prepareForQuiz(cards, count);
    }

    /**
     * 
     * Creates a deck of cards and displays the deck
     *
     */
    private static void testPlayingCard() {
        PlayingCard[] deck = createDeck();
        System.out.print("\nNumber of unique cards to pick at random: ");
        int count = input.nextInt();
        input.nextLine();
        displayRandomCards(deck, count);

    }

    /**
     * 
     * This method demonstrates how the count of business cards in the ArrayList is reduced
     *
     * @param myBusCards
     * @param count
     */
    private static void reduceBusinessCardCount(ArrayList<BusinessCard> myBusCards, int count) {
        System.out.printf("Distributing %d business cards\n", count);
        myBusCards.subList(0, Math.min(count, myBusCards.size())).clear();
    }

    /**
     * 
     * This method creates a deck of PlayingCards
     *
     * @return
     */
    private static PlayingCard[] createDeck() {
        PlayingCard[] deck = new PlayingCard[58];
        int index = 0;
        String material = "CARDSTOCK";
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {
            "Ace", "Two", "Three", "Four", "Five", "Six", "Seven",
            "Eight", "Nine", "Ten", "Jack", "Queen", "King", "One"
        };
        
        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = new PlayingCard(material, suit, rank);
            }
        }
        
        deck[index++] = new PlayingCard(material, "NONE", "JOKER");
        deck[index++] = new PlayingCard(material, "NONE", "JOKER");

        return deck;
    }
    

    /**
     * 
     * Displays the number of random cards using String formatting
     *
     * @param deck
     * @param count
     */
    private static void displayRandomCards(PlayingCard[] deck, int count) {
        ArrayList<PlayingCard> deckList = new ArrayList<>();
        Collections.addAll(deckList, deck);
        
        Collections.shuffle(deckList);
        
        System.out.println("Random cards chosen...");
        for (int i = 0; i < Math.min(count, deckList.size()); i++) {
            System.out.println(deckList.get(i));
        }
    }

    /**
     * 
     * This method creates a list of IndexCards using the array provided at the top of this file
     *
     * @return ArrayList<IndexCard>
     */
    private static ArrayList<IndexCard> createIndexCards() {
        ArrayList<IndexCard> indexCards = new ArrayList<>();
        String material = "CARDSTOCK";
        
        System.out.print("\nInput material used for index card: ");
        String size = input.nextLine(); 
        
        for (int count = 0; count < data.length; count++) {
            try {
                indexCards.add(new IndexCard(material, size, data[count][0], data[count][1]));
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid size for IndexCard. Card not added: " + data[count][0]);
            }
        }
        return indexCards;
    }


    /**
     * 
     * This method uses the a list of index cards and tests the user with the questions on each card
     *
     * @param cards
     * @param count
     */
    private static void prepareForQuiz(ArrayList<IndexCard> cards, int count) {
        System.out.println("\nUse Index Cards for the States and Capitals Quiz prep...");
        int score = 0;

        ArrayList<IndexCard> shuffledCards = new ArrayList<>(cards);
        Collections.shuffle(shuffledCards);
        
        for (int i = 0; i < Math.min(count, shuffledCards.size()); i++) {
            IndexCard card = shuffledCards.get(i);
            System.out.println(card.getQuestion());
            System.out.print("Answer: ");
            String answer = input.nextLine();
            if (answer.trim().equalsIgnoreCase(card.getAnswer())) {
                score++;
            }
        }

        System.out.println("Score: " + score);
    }

}
