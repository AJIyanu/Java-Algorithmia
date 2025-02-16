package car_rental_agency.vehicles;

import car_rental_agency.interfaces.TruckVehicle;

public class Truck implements TruckVehicle {
    private String make;
    private String model;
    private int year;
    private double cargoCapacity;
    private String transmissionType;

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
    public double getCargoCapacity() {
        return cargoCapacity;
    }
    
    @Override
    public void setCargoCapacity(double capacity) {
        if (capacity <= 0 || capacity > 50) {
            throw new IllegalArgumentException("Invalid cargo capacity: " + capacity);
        }
        this.cargoCapacity = capacity;
    }
    
    @Override
    public String getTransmissionType() {
        return transmissionType;
    }
    
    @Override
    public void setTransmissionType(String transmission) {
        if (!transmission.equalsIgnoreCase("manual") && 
            !transmission.equalsIgnoreCase("automatic")) {
            throw new IllegalArgumentException("Invalid transmission type: " + transmission);
        }
        this.transmissionType = transmission;
    }

    @Override
    public String toString() {
        return String.format("Truck: %s %s %d, Cargo Capacity: %.1f tons, Transmission: %s",
            make, model, year, cargoCapacity, transmissionType);
    }
}

