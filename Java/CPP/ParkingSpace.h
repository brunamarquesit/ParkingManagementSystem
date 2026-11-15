
#ifndef PARKING_SPACE_H
#define PARKING_SPACE_H

#include <string>
using namespace std;

enum class SpaceType {
    MOTORCYCLE,
    COMPACT,
    LARGE
};

class ParkingSpace {
private:
    int level;
    char row;
    int number;
    SpaceType type;
    bool occupied;
    string vehiclePlate;
public:
    ParkingSpace(int l, char r, int n, SpaceType t)
        : level(l), row(r), number(n),
          type(t), occupied(false) {}

    int getLevel() const {
        return level;
    }

    char getRow() const {
        return row;
    }

    int getNumber() const {
        return number;
    }

    SpaceType getType() const {
        return type;
    }

    bool isOccupied() const {
        return occupied;
    }

    
void occupy(const string &plate) {
    occupied = true;
    vehiclePlate = plate;
}

void release() {
    occupied = false;
    vehiclePlate.clear();
}

string getVehiclePlate() const {
    return vehiclePlate;
}


    string getTypeName() const {
        switch (type) {
            case SpaceType::MOTORCYCLE:
                return "Motorcycle";
            case SpaceType::COMPACT:
                return "Compact";
            case SpaceType::LARGE:
                return "Large";
        }
        return "Unknown";
    }
};

#endif
