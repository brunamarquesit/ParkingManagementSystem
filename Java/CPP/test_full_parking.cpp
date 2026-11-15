
#include <iostream>
#include <string>
#include "ParkingLot.h"

using namespace std;

int main() {
    ParkingLot parkingLot;

    cout << "=== TC07: Full Parking Test ===\n";

    int registered = 0;

    // Fill the parking lot with motorcycles.
    for (int i = 1; i <= 20; i++) {
        string plate = "TEST" + to_string(i);

        if (parkingLot.parkVehicle(SpaceType::MOTORCYCLE, plate)) {
            registered++;
        }
    }

    cout << "\nRegistered vehicles: " << registered << "\n";
    cout << "Total spaces: " << parkingLot.getTotalSpaces() << "\n";
    cout << "Available spaces: " << parkingLot.getAvailableSpaces() << "\n";

    // Try to register one more vehicle.
    bool extraVehicle = parkingLot.parkVehicle(
        SpaceType::MOTORCYCLE, "EXTRA001"
    );

    if (!extraVehicle && parkingLot.getAvailableSpaces() == 0) {
        cout << "TC07 PASSED: Full parking lot rejected extra vehicle.\n";
    } else {
        cout << "TC07 FAILED: Unexpected parking behaviour.\n";
    }

    return 0;
}
