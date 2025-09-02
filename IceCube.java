/**
 * 
 */
package assignments.module7.abstraction;

/**
 * This class creates an object of type Ice Cube as an implementation of the abstract Cube class
 *
 * @author Your Name
 * @version module 7
 *
 */
public class IceCube extends Cube {

    private double tempInCelsius;
    private boolean isFlavored;

    /**
     * 
     * Construct a new IceCube object.
     *
     * @param side
     * @param tempInCelsius
     * @param isFlavored
     */
    public IceCube(double side, double tempInCelsius, boolean isFlavored) {
        super(side);
        this.tempInCelsius = tempInCelsius;
        this.isFlavored = isFlavored;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double calculateVolume() {
        return 0;
    }

    /**
     * Returns true if the ice cube is flavored, false otherwise
     *
     * @return the isFlavored value
     */
    public boolean isFlavored() {
        return isFlavored;
    }

    /**
     * Returns the current temperature of the ice cube in Celsuis
     *
     * @return double
     */
    public double getTempInCelsius() {
        return tempInCelsius;
    }

    /**
     * Returns the current temperature of the ice cube in Fahrenheit
     *
     * @return double
     */
    public double getTempInFahrenheit() {

        return (tempInCelsius) * 9 / 5;
    }

    /**
     * 
     * Returns a status if the cube is still frozen or not True if melted, false otherwise
     * 
     * @return boolean
     */
    public boolean isMelted() {

        return tempInCelsius > 0 ? true : false;
    }

    /**
     * 
     * This method updates the current temperature and the side of the ice cube based on the new
     * temperature. The argument provided can be positive, negative or zero.
     * 
     * @param degrees
     */
    public void melt(double degrees) {
        tempInCelsius += degrees;
        System.out.println("IceCube warmed to: " + tempInCelsius + "°C");

        if (tempInCelsius > 0 && getSide() > 0) {
            double meltRatio = Math.min(1.0, tempInCelsius / 10.0);
            double newVolume = calculateVolume() * (1 - meltRatio);

            if (newVolume <= 0) {
                setSide(0);
            } else {
                setSide(Math.cbrt(newVolume));
            }
        }

    }

}
