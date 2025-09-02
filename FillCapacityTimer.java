package assignment.module2;

import java.util.Scanner;

/**
 * Write a one-sentence summary of your class here. Follow it with additional details about its
 * purpose and how to use it.
 *
 * @author muhammadnaseem
 * @version Feb 25, 2025
 *
 */
public class FillCapacityTimer {
    /**
     * Place a description of your method here.
     *
     * @param args None
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Calculating the time taken to fill a container: ");

        System.out.print("Input Container capacity in gallons: ");
        double capacity = input.nextDouble();
        System.out.print("Input the water flow in liters per second: ");
        int flow = input.nextInt();

        if ((capacity > 1e5 || capacity < 0) || (flow > 100 || flow < 0)) {
            System.out.print("invalid input");
        } else {
            double capacityInLiters = capacity * 3.78541;
            double time = capacityInLiters / flow;
            System.out.print("The time taken to fill a " + capacity
                + " gallon container using water flowing at " + flow + " liters per second is ");
            System.out.printf("%.0f seconds", time);
        }

        input.close();
    }

}
