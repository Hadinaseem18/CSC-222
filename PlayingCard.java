/**
 * 
 */
package assignments.module7.inheritance;

/**
 * This class defines a Playing Card as a child class of Card
 *
 * @author Your Name
 * @version module 7
 *
 */
public class PlayingCard extends Card {

    private Suit suit;
    private CardValue cardValue;
    private static final String SIZE = "MEDIUM";

    /**
     * Construct a new PlayingCard object.
     *
     * @param material
     * @param suit
     * @param cardValue
     */
    public PlayingCard(String material, String suit, String cardValue) {
        super(material, SIZE);

        try {
            this.suit = Suit.valueOf(suit.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid suit: " + suit + ". Allowed values are: " + Arrays.toString(Suit.values()));
        }

        try {
            this.cardValue = CardValue.valueOf(cardValue.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid card value: " + cardValue + ". Allowed values are: " + Arrays.toString(CardValue.values()));
        }
    }


    /**
     * Returns the card value
     *
     * @return CardValue
     */
    public CardValue getCardValue() {
        return cardValue;
    }
    
    /**
     * 
     * Returns the suit of the card
     *
     * @return suit
     */
    public Suit getSuit() {
        return suit;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String toString() {
        //TODO: complete the method to display the suit and the value for the card object. 
        // TODO: However, for the Joker, display only the value since there is no suit for Joker.
        
        return null;
    }

}

