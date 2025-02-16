package car_rental_agency.interfaces;

/**
 * Interface for car-specific functionality.
 * Extends the base Vehicle interface with methods specific to cars.
 */
public interface CarVehicle extends Vehicle {
    /**
     * Gets the number of doors on the car.
     * 
     * @return The number of doors
     */
    int getNumberOfDoors();

    /**
     * Sets the number of doors on the car.
     * 
     * @param doors Number of doors (typically 2-5)
     * @throws IllegalArgumentException if doors is less than 2 or greater than 5
     */
    void setNumberOfDoors(int doors);

    /**
     * Gets the fuel type used by the car.
     * 
     * @return The fuel type (petrol, diesel, or electric)
     */
    String getFuelType();

    /**
     * Sets the fuel type for the car.
     * 
     * @param fuelType The type of fuel (must be "petrol", "diesel", or "electric")
     * @throws IllegalArgumentException if fuel type is not one of the allowed values
     */
    void setFuelType(String fuelType);
}