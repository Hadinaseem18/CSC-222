/**
 * 
 */
package assignments.module7.inheritance;

/**
 * This class defines a business card
 *
 * @author csc222
 * @version module 7
 *
 */
public class BusinessCard extends Card{

    private String content;
    private static final String BUSINESSCARDSIZE = "SMALL";

    /**
     * Construct a new BusinessCard object.
     *
     * @param material
     * @param content
     */
    public BusinessCard(String material, String content) {
        // TODO: make a call to the parent class constructor with the required arguments
        this.content = content;
    }

    /**
     * Returns the content displayed on the business card
     *
     * @return String
     */
    public String getContent() {
        return content;
    }

    /**
     * Updates the content on the business card
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String toString() {
        // TODO: Format the business card content as shown in the example in the assignment.
        return null;
    }

}

