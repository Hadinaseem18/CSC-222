/**
 * 
 */
package assignments.module7.abstraction;

/**
 * This class defines a Die as an implementation of the Cube abstract class
 *
 * @author muhammadnaseem
 * @version module 7
 *
 */
public class Die extends Cube {

    private int topFace;
    private int[] faces = { 1, 2, 3, 4, 5, 6 };

    /**
     * 
     * Construct a new Die object.
     *
     * @param side
     */
    protected Die(double side) {
        super(side);
        rollDie();
    }

    /**
     * 
     * {@inheritDoc}
     */
    @Override
    public double calculateVolume() {
        return Math.pow(getSide(), 3);

    }

    /**
     * 
     * Returns the face value for a given face index
     *
     * @param faceNumber
     * @return int
     */
    public int getFaceValue(int faceNumber) {
        if (faceNumber >= 0 && faceNumber < faces.length) {
            return faces[faceNumber];
        } else {
            return -1;
        }
    }

    /**
     * 
     * Returns the index of the side of the die currently facing up This value will change every
     * time the die is rolled
     * 
     * @return int
     */
    public int getTopFace() {
        return topFace;
    }

    /**
     * This method simulates the rolling of a die
     *
     */
    public void rollDie() {
        int index = (int) (Math.random() * 6);
        topFace = index;
    }

    /**
     * 
     * {@inheritDoc}
     */
    public String toString() {
        int value = faces[topFace];
        String[][] grid = {
            { "\u25CB", "\u25CB", "\u25CB" },
            { "\u25CB", "\u25CB", "\u25CB" },
            { "\u25CB", "\u25CB", "\u25CB" }
        };

        switch (value) {
        case 1:
            grid[1][1] = "\u25CF";
            break;
        case 2:
            grid[0][0] = "\u25CF";
            grid[2][2] = "\u25CF";
            break;
        case 3:
            grid[0][0] = "\u25CF";
            grid[1][1] = "\u25CF";
            grid[2][2] = "\u25CF";
            break;
        case 4:
            grid[0][0] = "\u25CF";
            grid[0][2] = "\u25CF";
            grid[2][0] = "\u25CF";
            grid[2][2] = "\u25CF";
            break;
        case 5:
            grid[0][0] = "\u25CF";
            grid[0][2] = "\u25CF";
            grid[1][1] = "\u25CF";
            grid[2][0] = "\u25CF";
            grid[2][2] = "\u25CF";
            break;
        case 6:
            grid[0][0] = "\u25CF";
            grid[1][0] = "\u25CF";
            grid[2][0] = "\u25CF";
            grid[0][2] = "\u25CF";
            grid[1][2] = "\u25CF";
            grid[2][2] = "\u25CF";
            break;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(grid[i][j]).append(" ");
            }
            sb.append("\n");
        }

        return sb.toString();
    }
}
