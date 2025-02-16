package car_rental_agency.vehicles;

import car_rental_agency.interfaces.CarVehicle;

/**
 * Car class represents a car vehicle.
 * It implements the CarVehicle interface.
 * 
 */
public class Car implements  CarVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfDoors;
    private String fuelType;

    @Override
    public String getMake() {
        return make;
    }
    
    @Override
    public void setMake(String make) {
        this.make = make;
    }
    
    @Override
    public String getModel() {
        return model;
    }
    
    @Override
    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public int getYear() {
        return year;
    }
    
    @Override
    public void setYear(int year) {
        if (year < 1900 || year > 2025) {
            throw new IllegalArgumentException("Invalid year: " + year);
        }
        this.year = year;
    }
    
    @Override
    public int getNumberOfDoors() {
        return numberOfDoors;
    }
    
    @Override
    public void setNumberOfDoors(int doors) {
        if (doors < 2 || doors > 5) {
            throw new IllegalArgumentException("Invalid number of doors: " + doors);
        }
        this.numberOfDoors = doors;
    }
    
    @Override
    public String getFuelType() {
        return fuelType;
    }
    
    @Override
    public void setFuelType(String fuelType) {
        if (!fuelType.equalsIgnoreCase("petrol") && 
            !fuelType.equalsIgnoreCase("diesel") && 
            !fuelType.equalsIgnoreCase("electric")) {
            throw new IllegalArgumentException("Invalid fuel type: " + fuelType);
        }
        this.fuelType = fuelType;
    }

    @Override
    public String toString() {
        return String.format("Car: %s %s %d, Doors: %d, Fuel: %s",
            make, model, year, numberOfDoors, fuelType);
    }
}
