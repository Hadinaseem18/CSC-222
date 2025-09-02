package project;

public class Elevator {
    private int maxCapacity;
    private int numOfFloor;
    private int currentFloor;
    private int currentPassenger;
    private boolean doorOpen;
    private boolean moving;
    private boolean emergencyStop;
    private int destinationFloor;
    private String direction;

    public Elevator(int maxCapacity, int numOfFloor, int currentFloor) {
        this.maxCapacity = maxCapacity;
        this.numOfFloor = numOfFloor;
        this.currentFloor = currentFloor;
        this.currentPassenger = 0;
        this.doorOpen = true;
        this.moving = false;
        this.emergencyStop = false;
        this.direction = "STATIONARY";
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getNumOfFloor() {
        return numOfFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public int getCurrentPassenger() {
        return currentPassenger;
    }

    public boolean isDoorOpen() {
        return doorOpen;
    }

    public boolean isMoving() {
        return moving;
    }

    public String getDirection() {
        return direction;
    }

    public void addPassenger(int count) {
        if (currentPassenger + count > maxCapacity) {
            System.err.println(count + " is exceeding the limit of the elevator");
        } else {
            currentPassenger += count;
        }
    }

    public void removePassenger(int count) {
        if (count > currentPassenger) {
            currentPassenger = 0;
        } else {
            currentPassenger -= count;
        }
    }

    public void openDoor() {
        if (!moving) {
            doorOpen = true;
        } else {
            System.err.println("Cannot open door while moving");
        }
    }

    public void closeDoor() {
        if (doorOpen) {
            doorOpen = false;
        }
    }

    public void setDestination(int destinationFloor) {
        if (destinationFloor < 0 || destinationFloor > numOfFloor) {
            System.err.println("Invalid floor number.");
            return;
        }
        this.destinationFloor = destinationFloor;

        if (destinationFloor > currentFloor) {
            direction = "UP";
        } else if (destinationFloor < currentFloor) {
            direction = "DOWN";
        } else {
            direction = "STATIONARY";
        }
    }

    public void moveToFloor() {
        if (doorOpen) {
            System.err.println("Cannot move while doors are open");
            return;
        }
        if (emergencyStop) {
            System.err.println("Cannot move while in emergency stop mode");
            return;
        }
        if (destinationFloor == currentFloor) {
            System.err.println("Already at the destination floor");
            return;
        }

        moving = true;
        simulateMovement();
        moving = false;
        doorOpen = true;
        direction = "STATIONARY";
    }

    private void simulateMovement() {
        while (currentFloor != destinationFloor) {
            if (direction.equals("UP")) {
                currentFloor++;
            } else if (direction.equals("DOWN")) {
                currentFloor--;
            }
            // You could simulate time here if needed.
        }
    }

    public void emergencyStop() {
        emergencyStop = true;
        moving = false;
        doorOpen = true;
    }

    public void cancelEmergencyStop() {
        emergencyStop = false;
    }

    public String getStatus() {
        String state = emergencyStop ? "EMERGENCY STOPPED" :
                      moving ? "MOVING" :
                      "STOPPED";
        return "Elevator " + state.toLowerCase() +
               " at floor " + currentFloor + ", " + currentPassenger + " passengers";
    }
}
