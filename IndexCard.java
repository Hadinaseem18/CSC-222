/**
 * 
 */
package assignments.module7.inheritance;

/**
 * This class defines an index card as a child class of Card
 *
 * @author Your name here
 * @version module 7
 *
 */
public class IndexCard extends Card {

    private static final String SIZE = "LARGE";
    private String[] content;

    /**
     * Construct a new IndexCard object.
     * 
     * @param material
     * @param content
     */
    public IndexCard(String material, String[] content) {
        super(material, SIZE);
        this.content = content;      
    }
    
    
    /**
     * Returns the content of the question component
     *
     * @return String
     */
    public String getQuestion() {
        return content[0];
    }
    
    /**
     * Returns the content of the question component
     *
     * @return the content value
     */
    public String getAnswer() {
        return content[1];
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String toString() {
        //TODO: complete the method to show the question and answer  (use formatting)
        return null;
    }
}
