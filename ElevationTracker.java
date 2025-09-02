package assignment.module2;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Finding the maximum and minimum elevation points of the trip.
 * 
 *
 * @author muhammadnaseem
 * @version Mar 6, 2025
 *
 */
public class ElevationTracker {

    /**
     * 
     *
     * @param args none
     */
    public static void main(String[] args) {
        System.out.print("Finding the maximum and minimum elevation points of your road trip...");
        System.out
            .println("Finding the maximum and minimum elevation points of your road trip...\n");
        int[] elevationGains = createArray();
        int[] altitudes = findAltitudes(elevationGains);
        int maxElevation = findMaxElevation(altitudes);
        int minElevation = findMinElevation(altitudes);
        int mode = findMode(altitudes);
        displayResult(elevationGains, altitudes, maxElevation, minElevation, mode);
    }

    /**
     * I am making an array in this method. I am using a scanner and a do while loop method to get
     * the size of the array. If the user enters the value outside the range they will re enter the
     * value. Then I used do while loop again to get the input for array.
     *
     * @return array
     */
    public static int[] createArray() {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.print("Enter array size (between 3 and 19): ");
            size = input.nextInt();
        }
        while (size <= 2 || size >= 20);

        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            int elevation;
            do {
                System.out.print("Enter elevation gain value (between -25 and 25) for index: ");
                elevation = input.nextInt();
            }
            while (elevation < -25 || elevation > 25);
            array[i] = elevation;
        }
        input.close();
        return array;
    }

    /**
     * this method is returning all the altitudes in the given range.
     *
     * @param elevationGains
     * @return altitudes
     */
    @SuppressWarnings("javadoc")
    public static int[] findAltitudes(int[] elevationGains) {
        int[] altitudes = new int[elevationGains.length + 1];
        for (int i = 1; i < altitudes.length; ++i) {
            altitudes[i] = altitudes[i - 1] + elevationGains[i - 1];
        }
        return altitudes;
    }

    /**
     * This method is finding the maximum elevation.
     *
     * @param altitudes array
     * @return max
     */
    public static int findMaxElevation(int[] altitudes) {
        int max = altitudes[0];
        for (int altitude : altitudes) {
            if (altitude > max) {
                max = altitude;
            }
        }
        return max;
    }

    /**
     * This method is finding the minimum elevation
     *
     * @param altitudes array
     * @return minimum
     */
    public static int findMinElevation(int[] altitudes) {
        int min = altitudes[0];
        for (int altitude : altitudes) {
            if (altitude < min) {
                min = altitude;
            }
        }
        return min;
    }

    /**
     * This method is finding the mode
     *
     * @param altitudes array
     * @return mode
     */
    public static int findMode(int[] altitudes) {
        int mostCount = 0, mode = altitudes[0];

        mode = altitudes[0];
        for (int i = 0; i < altitudes.length; ++i) {
            int count = 0;
            for (int j = 0; j < altitudes.length; ++j) {
                if (altitudes[i] == altitudes[j]) {
                    count = count + 1;

                }
            }
            if (count > mostCount) {
                mostCount = count;
                mode = altitudes[i];
            }

        }
        return mode;
    }

    /**
     * This method is printing the outputs
     *
     * @param elevationGains array of elevation gains
     * @param altitudes array of elevation gains
     * @param maxElevation maximum elevation
     * @param minElevation minimum elevation
     * @param mode most frequent value of altitude
     */
    public static void displayResult(int[] elevationGains, int[] altitudes, int maxElevation,
        int minElevation, int mode) {
        System.out.println("Elevation gain during trip: " + Arrays.toString(elevationGains));
        System.out.println("The altitudes are " + Arrays.toString(altitudes));
        System.out.println("Highest altitude: " + maxElevation);
        System.out.println("Lowest altitude: " + minElevation);
        System.out.println("Mode: " + "{" + mode + "}");

    }

}
