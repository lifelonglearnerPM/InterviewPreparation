/******************************************************************************
 * @author : lifelonglearnerPM
 * @link : https://github.com/lifelonglearnerPM
 *
 * Java Programming Basics :
 *
 * enumerations
 * Java Object Oriented Programming
 * class
 * Object
 * 
 *******************************************************************************/

abstract class Vehicle
{
    public enum VehicleType {CAR, TRUCK, MOTORCYCLE, BICYCLE}
    // Attributes (data) describing a Vehicle
    public VehicleType type;
    public String name;
    public String model;
    public String vehicleRegNum;
    public String makeYear;
    
    // default constructor
    public Vehicle() // public Vehicle()
    {
        this.name = "Unknown";
        this.model = "Unknown";
        this.makeYear = "Unknown";
        this.vehicleRegNum = "Unknown";
        this.makeYear = "Unknown";
    }
    
    // parameterized constructor
    public Vehicle (VehicleType inType, String inName, 
                    String inModel, String inVehicleRegNum, 
                    String inMakeYear)
    {
        type = inType;
        name = inName;
        model = inModel;
        vehicleRegNum = inVehicleRegNum;
        makeYear = inMakeYear;
    }
    
    //copy constructor
    public Vehicle(Vehicle inOther) 
    {
        type = inOther.type;
        name = inOther.name;
        model = inOther.model;
        vehicleRegNum = inOther.vehicleRegNum;
        makeYear = inOther.makeYear;
    }
}