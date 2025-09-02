/**
*
*/
package assignments.module8;

/**
 * Definition of a Person
 *
 * @author Your Name
 * @version Module 8
 *
 */
public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private String middleName;
    private String cityName;

    /**
     *
     * Construct a new Person object.
     *
     * @param firstName Person's first name
     * @param lastName Person's last name
     * @param middleName Person's middle name
     * @param cityName City
     */
    public Person(String firstName, String lastName, String middleName, String cityName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.cityName = cityName;
    }

    /**
     * Returns the person's first name
     *
     * @return String
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Returns the person's last name
     *
     * @return String
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the person's middle name
     *
     * @return String
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * Returns the person's city
     *
     * @return String
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * {@inheritDoc}
     */
    @Override
    public int compareTo(Person other) {
        int lastComparision = lastName.compareTo(other.lastName);
        if (lastComparision != 0) {
            return lastComparision;
        }
        int firstComparision = firstName.compareTo(other.firstName);
        if (firstComparision != 0) {
            return firstComparision;
        }
        return middleName.compareTo(other.middleName);
    }

    /**
     *
     * {@inheritDoc}
     */
    public String toString() {
        return String.format("%s, %s, %s, %s\n", lastName, firstName, middleName,
            cityName);
    }
}