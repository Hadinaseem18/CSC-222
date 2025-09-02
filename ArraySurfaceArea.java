package exam;

import java.util.Random;
import java.util.Scanner;

/**
 * We are finding the surface area
 * 
 * 
 *
 * @author muhammadnaseem
 * @version Mar 13, 2025
 *
 */
public class ArraySurfaceArea {

    /**
     * Main method
     *
     * @param args None
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char continueFlag = 'Y';

        while (continueFlag == 'Y' || continueFlag == 'y') {
            int size = getInput();

            int[] heights = createArray(size);

            int surfaceArea = calculateSurfaceArea(heights);

            System.out.print("Surface area of the array of stacked cubes with heights [");
            for (int i = 0; i < heights.length; i++) {
                System.out.print(heights[i]);
                if (i < heights.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]: " + surfaceArea + " sq units");

            System.out.print("Create new Stack? Y: ");
            continueFlag = scanner.next().charAt(0);
        }

        System.out.println("Goodbye!");
        scanner.close();
    }

    /**
     * getting inputs
     *
     * @return size
     */
    public static int getInput() {
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print("How many stacks of cubes are in the array? ");
            int size = input.nextInt();
            if (size >= 1 && size <= 10) {
                return size;
            } else {
                System.out.println("Invalid array size");
            }
        }
    }

    /**
     * creating an array
     * 
     * @param size of numbers of stacks
     *
     * @return array
     */
    public static int[] createArray(int size) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(11);
        }
        return array;
    }

    /**
     * calculating surface area
     *
     * @param heights array for height of stacks
     * @return surfaceArea
     */
    public static int calculateSurfaceArea(int[] heights) {
        int surfaceArea = 0;

        for (int height : heights) {
            surfaceArea += 6 * height;
        }

        for (int height : heights) {
            if (height > 1) {
                surfaceArea += 2 * (height - 1);
            }
        }

        for (int i = 1; i < heights.length; i++) {
            int difference = heights[i] - heights[i - 1];
            if (difference > 0) {
                surfaceArea -= 2 * difference;
            }
        }

        if (heights.length > 0) {
            surfaceArea += heights[0];
            surfaceArea += heights[heights.length - 1];
        }

        return surfaceArea;
    }
}
