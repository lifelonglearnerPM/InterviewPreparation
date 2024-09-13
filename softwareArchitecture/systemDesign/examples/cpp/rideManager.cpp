/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Problem Statement : Ride Management System
 *
 * You are tasked with developing a simple ride management system. 
 * The system involves managing drivers and assigning ride requests to them. 
 * Each driver has a name and a count of how many rides they have been assigned. 
 * The goal is to implement a mechanism to handle adding new drivers, receiving ride requests, 
 * and assigning these rides to drivers based on their current load (i.e., the number of rides they have been assigned).
 *
 *******************************************************************************/

#include <iostream>
#include <vector>
#include <string>
#include <algorithm> // For std::min_element

using namespace std;

class Driver {
private:
    std::string name;
    int rideCount;

public:
    Driver(const std::string& name) : name(name), rideCount(0) {}

    std::string getName() const {
        return name;
    }

    int getRideCount() const {
        return rideCount;
    }

    void incrementRideCount() {
        rideCount++;
    }
};

class RideManager {
private:
    std::vector<Driver> drivers;

public:
    void addDriver(const Driver& driver) {
        drivers.push_back(driver);
    }

    void addRideRequest(const std::string& rideDescription) {
        Driver* assignedDriver = findDriverWithLeastRides();
        if (assignedDriver != nullptr) {
            assignedDriver->incrementRideCount();
            std::cout << "Ride: " << rideDescription << " assigned to Driver: " << assignedDriver->getName() << std::endl;
        } else {
            std::cout << "No available drivers for ride: " << rideDescription << std::endl;
        }
    }

private:
    Driver* findDriverWithLeastRides() {
        if (drivers.empty()) {
            return nullptr;
        }

        return &(*std::min_element(drivers.begin(), drivers.end(), 
            [](const Driver& d1, const Driver& d2) {
                return d1.getRideCount() < d2.getRideCount();
            }
        ));
    }
};

int main() {
    RideManager rideManager;

    // Adding drivers
    rideManager.addDriver(Driver("Alice"));
    rideManager.addDriver(Driver("Bob"));
    rideManager.addDriver(Driver("Charlie"));

    // Adding ride requests and printing assigned drivers
    rideManager.addRideRequest("Ride 1");
    rideManager.addRideRequest("Ride 2");
    rideManager.addRideRequest("Ride 3");

    rideManager.addDriver(Driver("John"));

    rideManager.addRideRequest("Ride 4");

    return 0;
}
