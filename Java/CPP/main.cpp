
#include <iostream>
#include <string>
#include <vector>
#include <memory>
#include <limits>
#include "ParkingLot.h"
using namespace std;

// Abstract base class
class Vehicle {
protected:
    string plate;
    string model;

public:
    Vehicle(string p, string m) : plate(p), model(m) {}

    virtual ~Vehicle() = default;

    string getPlate() const {
        return plate;
    }

    virtual string getType() const = 0;

    virtual int requiredSpaces() const = 0;

    virtual void display() const {
        cout << "Type: " << getType()
             << " | Plate: " << plate
             << " | Model: " << model << endl;
    }
};

// Motorcycle subclass
class Motorcycle : public Vehicle {
public:
    Motorcycle(string p, string m) : Vehicle(p, m) {}

    string getType() const override {
        return "Motorcycle";
    }

    int requiredSpaces() const override {
        return 1;
    }
};

// Car subclass
class Car : public Vehicle {
public:
    Car(string p, string m) : Vehicle(p, m) {}

    string getType() const override {
        return "Car";
    }

    int requiredSpaces() const override {
        return 1;
    }
};

// Bus subclass
class Bus : public Vehicle {
public:
    Bus(string p, string m) : Vehicle(p, m) {}

    string getType() const override {
        return "Bus";
    }

    int requiredSpaces() const override {
        return 5;
    }
};

int main() {
    ParkingLot parkingLot;
const int totalSpaces = parkingLot.getTotalSpaces();
parkingLot.displaySpaces();
    vector<unique_ptr<Vehicle>> vehicles;
    int option = 0;

    do {
        cout << "\n=== Parking Management System ===\n";
        cout << "1. Register vehicle\n";
        cout << "2. List parked vehicles\n";
        cout << "3. Search vehicle by plate\n";
        cout << "4. Remove vehicle\n";
        cout << "5. Show available spaces\n";
        cout << "6. Exit\n";
        cout << "Choose an option: ";

        if (!(cin >> option)) {
            cin.clear();
            cin.ignore(numeric_limits<streamsize>::max(), '\n');
            cout << "Invalid option!\n";
            continue;
        }

        cin.ignore(numeric_limits<streamsize>::max(), '\n');

        if (option == 1) {
            int type;
            string plate, model;

            cout << "1. Motorcycle\n";
            cout << "2. Car\n";
            cout << "3. Bus\n";
            cout << "Choose vehicle type: ";

            if (!(cin >> type)) {
                cin.clear();
                cin.ignore(numeric_limits<streamsize>::max(), '\n');
                cout << "Invalid vehicle type!\n";
                continue;
            }

            cin.ignore(numeric_limits<streamsize>::max(), '\n');

            if (type < 1 || type > 3) {
                cout << "Invalid vehicle type!\n";
                continue;
            }

            cout << "Enter vehicle plate: ";
            getline(cin, plate);

            cout << "Enter vehicle model: ";
            getline(cin, model);

            if (plate.empty() || model.empty()) {
                cout << "Plate and model cannot be empty.\n";
                continue;
            }

            bool duplicate = false;

            for (const auto &vehicle : vehicles) {
                if (vehicle->getPlate() == plate) {
                    duplicate = true;
                    break;
                }
            }

            if (duplicate) {
                cout << "Vehicle already registered!\n";
                continue;
            }

            int occupied = 0;
            for (const auto &vehicle : vehicles) {
                occupied += vehicle->requiredSpaces();
            }

            int required = (type == 3) ? 5 : 1;

            if (occupied + required > totalSpaces) {
                cout << "Not enough parking spaces!\n";
                continue;
            }

bool parked = false;

if (type == 1) {
    parked = parkingLot.parkVehicle(SpaceType::MOTORCYCLE, plate);
} else if (type == 2) {
    parked = parkingLot.parkVehicle(SpaceType::COMPACT, plate);
} else {
    parked = parkingLot.parkBus(plate);
}

if (!parked) {
    cout << "No suitable parking spaces available.\n";
    continue;
}

            if (type == 1) {
                vehicles.push_back(make_unique<Motorcycle>(plate, model));
            } else if (type == 2) {
                vehicles.push_back(make_unique<Car>(plate, model));
            } else {
                vehicles.push_back(make_unique<Bus>(plate, model));
            }

            cout << "Vehicle registered successfully!\n";

        } else if (option == 2) {
            cout << "\n=== Parked Vehicles ===\n";

            if (vehicles.empty()) {
                cout << "No vehicles parked.\n";
            } else {
                for (const auto &vehicle : vehicles) {
                    vehicle->display();
                }
            }

        } else if (option == 3) {
            string searchPlate;
            bool found = false;

            cout << "Enter vehicle plate to search: ";
            getline(cin, searchPlate);

            for (const auto &vehicle : vehicles) {
                if (vehicle->getPlate() == searchPlate) {
                    cout << "Vehicle found!\n";
                    vehicle->display();
                    found = true;
                    break;
                }
            }

            if (!found) {
                cout << "Vehicle not found.\n";
            }

        } else if (option == 4) {
            string removePlate;
            bool removed = false;

            cout << "Enter vehicle plate to remove: ";
            getline(cin, removePlate);

            for (size_t i = 0; i < vehicles.size(); i++) {
                if (vehicles[i]->getPlate() == removePlate) {
                   parkingLot.removeVehicle(removePlate);
                   vehicles.erase(vehicles.begin() + i);
                    cout << "Vehicle removed successfully!\n";
                    removed = true;
                    break;
                }
            }

            if (!removed) {
                cout << "Vehicle not found.\n";
            }

        
} else if (option == 5) {
    int available = parkingLot.getAvailableSpaces();
    int occupied = parkingLot.getTotalSpaces() - available;

    cout << "\n=== Parking Spaces ===\n";
    cout << "Total spaces: " << parkingLot.getTotalSpaces() << endl;
    cout << "Occupied spaces: " << occupied << endl;
    cout << "Available spaces: " << available << endl;


        } else if (option == 6) {
            cout << "Exiting system...\n";

        } else {
            cout << "Invalid option!\n";
        }

    } while (option != 6);

    return 0;
}
