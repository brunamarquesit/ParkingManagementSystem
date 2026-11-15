
package Java;

public class Main {

    static abstract class Vehicle {
        String plate;

        Vehicle(String plate) {
            this.plate = plate;
        }

        abstract String getType();
    }

    static class Motorcycle extends Vehicle {
        Motorcycle(String plate) {
            super(plate);
        }

        String getType() {
            return "Motorcycle";
        }
    }

    static class Car extends Vehicle {
        Car(String plate) {
            super(plate);
        }

        String getType() {
            return "Car";
        }
    }

    static class Bus extends Vehicle {
        Bus(String plate) {
            super(plate);
        }

        String getType() {
            return "Bus";
        }
    }

    public static void main(String[] args) {
        Vehicle motorcycle = new Motorcycle("MOTO123");
        Vehicle car = new Car("CAR456");
        Vehicle bus = new Bus("BUS789");

        System.out.println("Parking Management System");
        System.out.println("-------------------------");

        Vehicle[] vehicles = {motorcycle, car, bus};

        for (Vehicle vehicle : vehicles) {
            System.out.println(
                vehicle.getType() + " - Plate: " + vehicle.plate
            );
        }
    ParkingLot parkingLot = new ParkingLot();


System.out.println("\nParking Allocation:");
parkingLot.park("Motorcycle", "MOTO123");
parkingLot.park("Car", "CAR456");
parkingLot.park("Bus", "BUS789");

System.out.println("\nVehicle Search:");
parkingLot.searchVehicle("CAR456");
parkingLot.searchVehicle("BUS789");
parkingLot.searchVehicle("XYZ999");

System.out.println("\nHash Table Test:");

VehicleHashTable hashTable = new VehicleHashTable();

hashTable.addVehicle("CAR456", "Level 1, Row 1, Space 3");
hashTable.addVehicle("BUS789", "Level 1, Row 1, Space 6");

hashTable.searchVehicle("CAR456");
hashTable.searchVehicle("BUS789");
hashTable.searchVehicle("XYZ999");

System.out.println("\nDoubly Linked List Test:");

VehicleDataStructures.DoublyLinkedList list =
    new VehicleDataStructures.DoublyLinkedList();

list.add("MOTO123");
list.add("CAR456");
list.add("BUS789");

list.display();

System.out.println("\nBinary Tree Test:");

VehicleDataStructures.BinaryTree tree =
    new VehicleDataStructures.BinaryTree();

tree.insert("MOTO123");
tree.insert("CAR456");
tree.insert("BUS789");

System.out.println("CAR456 found: " + tree.search("CAR456"));
System.out.println("XYZ999 found: " + tree.search("XYZ999"));

System.out.println("\nLinear Search Test:");

java.util.List<String> plates = java.util.Arrays.asList(
    "MOTO123", "CAR456", "BUS789"
);

int position = VehicleAlgorithms.linearSearch(
    plates, "CAR456"
);

System.out.println("CAR456 position: " + position);

System.out.println("\nMerge Sort Test:");

java.util.List<String> types = java.util.Arrays.asList(
    "Motorcycle", "Car", "Bus"
);

java.util.Comparator<String> vehicleTypeComparator =
    java.util.Comparator.comparingInt(type -> {
        switch (type) {
            case "Motorcycle": return 1;
            case "Car": return 2;
            case "Bus": return 3;
            default: return 4;
        }
    });

java.util.List<String> sorted =
    VehicleAlgorithms.mergeSort(
        types,
        vehicleTypeComparator
    );

System.out.println("Sorted vehicles: " + sorted);

}

}
