package car_rental_agency.interfaces;

/**
 * Interface representing a truck vehicle.
 * Extends the Vehicle interface with additional properties specific to trucks.
 * 
 */
public interface TruckVehicle extends Vehicle {
    
    /**
     * Gets the cargo capacity of the truck.
     *
     * @return The cargo capacity in tons
     */
    double getCargoCapacity();

    /**
     * Sets the cargo capacity of the truck.
     *
     * @param capacity The cargo capacity in tons
     */
    void setCargoCapacity(double capacity);

    /**
     * Gets the type of transmission used by the truck.
     *
     * @return The transmission type (e.g., "manual", "automatic")
     */
    String getTransmissionType();

    /**
     * Sets the type of transmission for the truck.
     *
     * @param transmission The transmission type (must be "manual" or "automatic")
     * @throws IllegalArgumentException if transmission type is not one of the allowed values
     */
    void setTransmissionType(String transmission);

}
