package exam2;

/**
 * This class shows the growth of magical plant. Growth of leaves is handled by recursion. The
 * number of branches is determined by number of leaves. If year id=s divisible by 3 the number of
 * leaves triple. otherwise it doubles.
 *
 * @author muhammadnaseem
 * @version Apr 22, 2025
 *
 */
public class MagicalPlant {
    private int age;
    private int numberOfLeaves;
    private int numberOfBranches;

    /**
     * Construct a new MagicalPlant object.
     *
     */
    public MagicalPlant() {
        this.age = 0;
        this.numberOfBranches = 0;
        this.numberOfLeaves = 0;
    }

    /**
     * Getting age of plant
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * getting number of leaves
     *
     * @return numberofLeaves
     */
    public int getNumLeaves() {
        return numberOfLeaves;
    }

    /**
     * Getting number of branches
     *
     * @return numberofBranches
     */
    public int getBranches() {
        return numberOfBranches;
    }

    /**
     * Setting age of plant and update number of leaves and branches
     *
     * @param age the age for the plant
     */
    public void setAge(int age) {
        this.age = age;
        updateNumberOfLeaves();
        updateNumberOfBranches();
    }

    /**
     * Setting number of leaves for the plant
     *
     * @param numberOfLeaves the number of leaves to set
     */
    public void setNumberOfLeaves(int numberOfLeaves) {
        this.numberOfLeaves = numberOfLeaves;
        updateAge(1, 2);
        updateNumberOfBranches();
    }

    /**
     * 
     * updates the age of plant. The method change the age once the calculated number of leaves is
     * greater than or equal to the current number of leaves
     *
     * @param currentYear the current year in the plant's growth
     * @param leaves the current number of leaves
     */
    private void updateAge(int currentYear, int leaves) {
        if (leaves >= numberOfLeaves) {
            this.age = currentYear;
            return;
        }
        if ((currentYear + 1) % 3 == 0) {
            leaves *= 3;
        } else {
            leaves *= 2;
        }
        updateAge(currentYear + 1, leaves);
    }

    /**
     * 
     * Updating number of leaves based on age of plant
     *
     */

    private void updateNumberOfLeaves() {
        numberOfLeaves = 2;
        for (int i = 2; i <= age; i++) {
            if (i % 3 == 0) {
                numberOfLeaves *= 3;
            } else {
                numberOfLeaves *= 2;
            }
        }
    }

    /**
     * 
     * updates the number of branches based on number of leaves
     *
     */
    private void updateNumberOfBranches() {
        numberOfBranches = numberOfLeaves / 7;
        if (numberOfLeaves % 7 != 0) {
            numberOfBranches++;
        }
    }
}
