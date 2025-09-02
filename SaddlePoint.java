package projects;


import java.util.Random;
import java.util.Scanner;

public class SaddlePoint {
    private static byte[][] array;
    private static int size;

    /**
     * This is the main method where all the others methods are called
     *
     * @param args NONE
     */
    public static void main(String[] args) {
        System.out.println("Finding the Saddle Point for a given 2D array...\n");
        createArray();
        assignValuesToArray();
        displayArray("The generated array:");

        int[] saddlePoint = findSaddlePoint();
        displaySaddlePoint(saddlePoint);

        rotateArray();
        displayArray("Rotated array by 90 degrees:");

        saddlePoint = findSaddlePoint();
        displaySaddlePoint(saddlePoint);
    }

    /**
     * I am creating a 2D array
     *
     */
    public static void createArray() {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        size = input.nextInt();
        array = new byte[size][size];
        input.close();
    }

    /**
     * assigning values to 2D array
     *
     */
    @SuppressWarnings("resource")
    public static void assignValuesToArray() {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the lower limit: ");
        int lowerLimit = input.nextInt();
        System.out.print("Input the upper limit: ");
        int upperLimit = input.nextInt();

        if (lowerLimit >= upperLimit || lowerLimit < 0) {
            System.out.println("Invalid range! Ensure lower < upper and both are positive.");
            return;
        }

        Random rand = new Random();
        boolean[] used = new boolean[upperLimit - lowerLimit + 1];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                int num;
                do {
                    num = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
                } while (used[num - lowerLimit]);
                used[num - lowerLimit] = true;
                array[i][j] = (byte) num;
            }
            
        }
    }

    /**
     * displaying array 
     *
     * @param message 
     */
    public static void displayArray(String message) {
        System.out.println(message);
        for (byte[] row : array) {
            for (byte num : row) {
                System.out.printf("%d ", num);
            }
            System.out.println();
        }
    }

    public static int[] findSaddlePoint() {
        for (int i = 0; i < size; i++) {
            int rowMin = array[i][0];
            int index = 0;

            for (int j = 1; j < size; j++) {
                if (array[i][j] < rowMin) {
                    rowMin = array[i][j];
                    index = j;
                }
            }

            boolean isSaddlePoint = true;
            for (int k = 0; k < size; k++) {
                if (array[k][index] > rowMin) {
                    isSaddlePoint = false;
                    break;
                }
            }

            if (isSaddlePoint) {
                return new int[]{i, index};
            }
        }
        return new int[]{-1, -1};
    }

    /**
     * Place a description of your method here.
     *
     * @param saddlePoint 
     */
    public static void displaySaddlePoint(int[] saddlePoint) {
        if (saddlePoint[0] != -1) {
            System.out.printf("The Saddle Point is located at row %d, column %d: %d\n", 
                    saddlePoint[0], saddlePoint[1], array[saddlePoint[0]][saddlePoint[1]]);
        } else {
            System.out.println("There is no Saddle Point in the array.");
        }
    }

    /**
     * rotating array by using for loop
     *
     */
    public static void rotateArray() {
        for (int x = 0; x < size / 2; x++) {
            for (int y = x; y < size ; y++) {
                byte temp = array[x][y];
                array[x][y] = array[size - 1][x];
                array[size - 1][x] = array[size - 1 ][size - 1 ];
                array[size - 1][size - 1 ] = array[y][size - 1 ];
                array[y][size - 1] = temp;
            }
        }
    }
    
}
