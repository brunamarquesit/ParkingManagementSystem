
package Java;

import java.util.HashMap;

public class VehicleHashTable {

    private HashMap<String, String> vehicles = new HashMap<>();

    public void addVehicle(String plate, String location) {
        vehicles.put(plate, location);
    }

    public void searchVehicle(String plate) {
        if (vehicles.containsKey(plate)) {
            System.out.println(
                "Hash Table: " + plate +
                " found at " + vehicles.get(plate)
            );
        } else {
            System.out.println(
                "Hash Table: Vehicle not found: " + plate
            );
        }
    }
}
