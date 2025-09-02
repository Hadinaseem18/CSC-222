package project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * This is the main method which ask the user for a size of 2d array, create matrix and compress it.
 * 
 * 
 *
 * @author muhammadnaseem
 * @version Apr 19, 2025
 *
 */
public class SparseMatrixToList {

    /**
     * This is the main method which ask the user for a size of 2d array, create matrix and compress it.
     *
     * @param args None
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Input the size of the 2D array: ");
        int size = input.nextInt();
        int[][] myArray = new int[size][size];

        createArray(myArray);
        System.out.println("\n\nThe array:");
        displayMatrix(myArray);

        ArrayList<int[]> locations = compressMatrix(myArray);
        displayCompressedList(locations);

        int[][] reconstructed = convertingListToArray(locations);
        System.out.println("\nCreating a 2D array using the ArrayList:");
        displayMatrix(reconstructed);

        input.close();
    }

    /**
     * Creates an array where a random number of 1's are placed while the other remain 0
     *
     * @param matrix The 2D array with values
     */
    public static void createArray(int[][] matrix) {
        int totalSize = matrix.length * matrix.length;
        int upperLimit = totalSize / 2;
        Random rand = new Random();
        int randomNumber = rand.nextInt(upperLimit) + 1;
        System.out.println("Number of values to be set to 1: " + randomNumber);

        int count = 0;

        while (count < randomNumber) {
            int row = rand.nextInt(matrix.length);
            int col = rand.nextInt(matrix.length);

            if (matrix[row][col] == 0) {
                matrix[row][col] = 1;
                count++;
            }
        }
    }

    /**
     * compress a matrix into an Array list
     *
     * @param matrix input of 2D array to be compressed
     * @return ArrayList 
     */ 
    public static ArrayList<int[]> compressMatrix(int[][] matrix) {
        ArrayList<int[]> list = new ArrayList<>();

        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 1) {
                    list.add(new int[] { i, j });
                }
            }
        }

        return list;
    }

    /**
     * display the ArrayList
     *
     * @param list the array list containing row and column
     */
    public static void displayCompressedList(ArrayList<int[]> list) {
        System.out.println("\nArrayList containing the locations where 1 is assigned:");
        for (int[] pair : list) {
            System.out.println(pair[0] + "," + pair[1]);
        }
    }

    /**
     * Converting ArrayList back to 2D array.
     *
     * @param list The array list containing row and column
     * @return new 2d array
     */
    public static int[][] convertingListToArray(ArrayList<int[]> list) {
        int maxRow = 0;
        int maxCol = 0;

        for (int[] pair : list) {
            if (pair[0] > maxRow)
                maxRow = pair[0];
            if (pair[1] > maxCol)
                maxCol = pair[1];
        }

        int[][] newArray = new int[maxRow + 1][maxCol + 1];

        for (int[] pair : list) {
            newArray[pair[0]][pair[1]] = 1;
        }

        return newArray;
    }

    /**
     * displaying the newly created array
     *
     * @param matrix the displayed 2d array
     */
    public static void displayMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; ++i) {
            System.out.print("[");
            for (int j = 0; j < matrix[i].length; ++j) {
                System.out.print(matrix[i][j]);
                if (j < matrix[i].length - 1)
                    System.out.print(", ");
            }
            System.out.println("]");
        }
    }
}
