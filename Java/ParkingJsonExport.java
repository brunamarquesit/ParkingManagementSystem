
package Java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ParkingJsonExport {

    static class VehicleRecord {
        String type;
        String plate;
        String location;

        VehicleRecord(String type, String plate, String location) {
            this.type = type;
            this.plate = plate;
            this.location = location;
        }
    }

    public static void main(String[] args) {
        VehicleRecord vehicle = new VehicleRecord(
            "Car",
            "CAR456",
            "Level 1, Row A, Space 1"
        );

        Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

        String json = gson.toJson(vehicle);

        System.out.println("Parking JSON Export:");
        System.out.println(json);
        System.out.println("Gson library test completed.");
    }
}
