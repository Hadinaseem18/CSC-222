package project;

import java.util.Scanner;

/**
 * The ElevatorTest class demonstrates the behavior of the Elevator class. 
 * 
 * @author muhammadnaseem
 * @version Apr 9, 2025
 */
public class ElevatorTest {

    /**
     * The main method to run the elevator simulation
     * 
     * @param args None
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("\nCreating a new Elevator object");
        System.out.print("Input maximum passenger capacity: ");
        int maxCapacity = input.nextInt();
        System.out.print("Input number of floors in the building: ");
        int floor = input.nextInt();

        Elevator elevator = new Elevator(maxCapacity, floor, 0);

        System.out.println("\nMoving down from start position");
        elevator.setDestination(-1);
        elevator.moveToFloor();
        System.out.println(elevator.getStatus());

        System.out.println("\nMoving up to Floor 3 with 3 passengers");
        elevator.addPassenger(3);
        elevator.setDestination(3);
        elevator.closeDoor();
        elevator.moveToFloor();
        System.out.println(elevator.getStatus());

        System.out.println("\nStop elevator, open door and 2 passengers leave");
        elevator.openDoor();
        elevator.removePassenger(2);
        elevator.closeDoor();
        System.out.println(elevator.getStatus());

        System.out.println(
            "\nMoving down to Floor 1 with remaining passengers or 0 passengers to new floor");
        elevator.setDestination(1);
        elevator.moveToFloor();
        System.out.println(elevator.getStatus());

        System.out.println("\nEmergency Stop");
        elevator.emergencyStop();
        System.out.println(elevator.getStatus());

        System.out.println("\nMoving when elevator door is open at current floor");
        elevator.openDoor();
        elevator.moveToFloor();
        System.out.println(elevator.getStatus());

        System.out
            .println("\nAdding more than allowable passengers to the elevator capacity: 3006");
        elevator.addPassenger(3006);
        System.out.println(elevator.getStatus());

        System.out.println("\nMoving to a non-existent floor: 500");
        elevator.setDestination(500);
        elevator.moveToFloor();
        System.out.println(elevator.getStatus());

        input.close();
    }
}
