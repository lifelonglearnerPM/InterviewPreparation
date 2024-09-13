#include <iostream>
#include <vector>
#include <string>

using namespace std;

class Driver {
    private:
    std :: string name;
    int rideCount;
    
    public:
    Driver(const std :: string& name) : name(name), rideCount(0) {}
    
    std :: string getName() const {
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
    std :: vector<Driver> drivers;
    
    public:
    void addDriver(const Driver& driver) {
        drivers.push_back(driver);
    }
    
    void addRideRequest(const std :: string& rideDescription) {
        Driver* assignedDriver = findDriverWithLeastRides();
        if (assignedDriver != nullptr) {
            assignedDriver->incrementRideCount();
            std :: cout << "Ride:" << rideDescription << " assigned to Driver:" << assignedDriver->getName() << std :: endl;
        } else {
            std :: cout << "No available drivers for ride: " << rideDescription << std :: endl;
        }
    }


    Driver* findDriverWithLeastRides () {
        if (drivers.empty()) {
            return nullptr;
        }

        Driver* leastBusyDriver = &drivers[0];
        for (Driver& driver : drivers) {
            if (driver.getRideCount() < leastBusyDriver->getRideCount()) {
                leastBusyDriver = &driver;
            }
        }
        return leastBusyDriver;
    }

};

int main()
{
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