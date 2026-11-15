package Java;

public class ParkingLot {

    static class Space {
        String type;
        boolean occupied = false;
String plate = null;
        Space(String type) {
            this.type = type;
        }
    }

    // Two levels, two rows per level
    private Space[][][] spaces = new Space[2][2][10];

    public ParkingLot() {
        for (int level = 0; level < 2; level++) {
            for (int row = 0; row < 2; row++) {
                for (int i = 0; i < 10; i++) {
                    String type;

                    if (i < 2) {
                        type = "Motorcycle";
                    } else if (i < 5) {
                        type = "Compact";
                    } else {
                        type = "Large";
                    }

                    spaces[level][row][i] = new Space(type);
                }
            }
        }
    }

    public boolean park(String vehicleType, String plate) {
        int required = vehicleType.equals("Bus") ? 5 : 1;

        for (int level = 0; level < 2; level++) {
            for (int row = 0; row < 2; row++) {
                for (int i = 0; i <= 10 - required; i++) {

                    boolean available = true;

                    for (int j = 0; j < required; j++) {
                        Space space = spaces[level][row][i + j];

                        if (space.occupied ||
                            (vehicleType.equals("Bus") &&
                             !space.type.equals("Large")) ||
                            (vehicleType.equals("Car") &&
                             space.type.equals("Motorcycle"))) {
                            available = false;
                            break;
                        }
                    }

                    
if (available) {
    for (int j = 0; j < required; j++) {
        spaces[level][row][i + j].occupied = true;
        spaces[level][row][i + j].plate = plate;
    }

    System.out.println(
        vehicleType + " parked at Level " +
        (level + 1) + ", Row " + (row + 1) +
        ", Space " + (i + 1)
    );
    return true;
}

                }
            }
        }

        System.out.println("No space available for " + vehicleType);
        return false;
    }

public void searchVehicle(String plate) {
    for (int level = 0; level < 2; level++) {
        for (int row = 0; row < 2; row++) {
            for (int i = 0; i < 10; i++) {
                Space space = spaces[level][row][i];

                if (plate.equals(space.plate)) {
                    System.out.println(
                        "Vehicle " + plate +
                        " found at Level " + (level + 1) +
                        ", Row " + (row + 1) +
                        ", Space " + (i + 1)
                    );
                    return;
                }
            }
        }
    }

    System.out.println("Vehicle not found: " + plate);
}
}
