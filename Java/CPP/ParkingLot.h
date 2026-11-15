
#ifndef PARKING_LOT_H
#define PARKING_LOT_H

#include <iostream>
#include <vector>
#include "ParkingSpace.h"

class ParkingLot {
private:
    std::vector<ParkingSpace> spaces;

public:
    ParkingLot() {
        // Create two parking levels
        for (int level = 1; level <= 2; level++) {

            // Row A: five large spaces
            for (int number = 1; number <= 5; number++) {
                spaces.emplace_back(
                    level, 'A', number, SpaceType::LARGE
                );
            }

            // Row B: two motorcycle spaces
            for (int number = 1; number <= 2; number++) {
                spaces.emplace_back(
                    level, 'B', number, SpaceType::MOTORCYCLE
                );
            }

            // Row B: three compact spaces
            for (int number = 3; number <= 5; number++) {
                spaces.emplace_back(
                    level, 'B', number, SpaceType::COMPACT
                );
            }
        }
    }

    void displaySpaces() const {
        std::cout << "\n=== Parking Lot Layout ===\n";

        for (const auto &space : spaces) {
            std::cout
                << "Level " << space.getLevel()
                << " | Row " << space.getRow()
                << " | Space " << space.getNumber()
                << " | Type: " << space.getTypeName()
                << " | Status: "
                << (space.isOccupied() ? "Occupied" : "Available")
                << '\n';
        }
    }

    
    // Park a bus in five consecutive large spaces
    bool parkBus(const std::string &plate) {
        const int requiredSpaces = 5;

        for (size_t i = 0; i + requiredSpaces <= spaces.size(); i++) {
            bool suitable = true;

            int level = spaces[i].getLevel();
            char row = spaces[i].getRow();
            int startNumber = spaces[i].getNumber();

            for (int j = 0; j < requiredSpaces; j++) {
                const auto &space = spaces[i + j];

                if (space.isOccupied() ||
                    space.getType() != SpaceType::LARGE ||
                    space.getLevel() != level ||
                    space.getRow() != row ||
                    space.getNumber() != startNumber + j) {
                    suitable = false;
                    break;
                }
            }

            if (suitable) {
                for (int j = 0; j < requiredSpaces; j++) {
                    spaces[i + j].occupy(plate);
                }

                std::cout << "Bus parked successfully!\n";
                std::cout << "Level: " << level
                          << " | Row: " << row
                          << " | Spaces: " << startNumber
                          << "-" << startNumber + 4 << '\n';

                return true;
            }
        }

        std::cout << "No five consecutive large spaces available.\n";
        return false;
    }
 
    // Find and occupy a suitable parking space
    bool parkVehicle(SpaceType vehicleType, const std::string &plate) {
        for (auto &space : spaces) {
            if (space.isOccupied()) {
                continue;
            }

            bool suitable = false;

            if (vehicleType == SpaceType::MOTORCYCLE) {
                suitable = true;
            } else if (vehicleType == SpaceType::COMPACT) {
                suitable =
                    space.getType() == SpaceType::COMPACT ||
                    space.getType() == SpaceType::LARGE;
            }

            if (suitable) {
                space.occupy(plate);

                std::cout << "Vehicle parked at Level "
                          << space.getLevel()
                          << ", Row " << space.getRow()
                          << ", Space " << space.getNumber()
                          << '\n';

                return true;
            }
        }

        return false;
    }

    // Release all parking spaces occupied by a vehicle
    bool removeVehicle(const std::string &plate) {
        bool found = false;

        for (auto &space : spaces) {
            if (space.isOccupied() &&
                space.getVehiclePlate() == plate) {

                space.release();
                found = true;
            }
        }

        if (found) {
            std::cout << "Vehicle " << plate
                      << " removed successfully.\n";
        } else {
            std::cout << "Vehicle not found in parking spaces.\n";
        }

        return found;
    }
int getTotalSpaces() const {
        return static_cast<int>(spaces.size());
    }

    int getAvailableSpaces() const {
        int available = 0;

        for (const auto &space : spaces) {
            if (!space.isOccupied()) {
                available++;
            }
        }

        return available;
    }
};

#endif
