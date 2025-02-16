package car_rental_agency.vehicles;

import car_rental_agency.interfaces.MotorVehicle;

public class Motorcycle implements MotorVehicle {
    private String make;
    private String model;
    private int year;
    private int numberOfWheels;
    private String motorcycleType;

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
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    
    @Override
    public void setNumberOfWheels(int wheels) {
        if (wheels < 2 || wheels > 3) {
            throw new IllegalArgumentException("Invalid number of wheels: " + wheels);
        }
        this.numberOfWheels = wheels;
    }
    
    @Override
    public String getMotorcycleType() {
        return motorcycleType;
    }
    
    @Override
    public void setMotorcycleType(String type) {
        if (!type.equalsIgnoreCase("sport") && 
            !type.equalsIgnoreCase("cruiser") && 
            !type.equalsIgnoreCase("off-road")) {
            throw new IllegalArgumentException("Invalid motorcycle type: " + type);
        }
        this.motorcycleType = type;
    }

    @Override
    public String toString() {
        return String.format("Motorcycle: %s %s %d, Wheels: %d, Type: %s",
            make, model, year, numberOfWheels, motorcycleType);
    }
}
