package car_rental_agency.interfaces;

/**
 * Interface representing a motor vehicle.
 * Extends the Vehicle interface to include specific attributes for motor vehicles.
 */
public interface MotorVehicle extends Vehicle {
    /**
     * Gets the number of wheels on the motor vehicle.
     *
     * @return The number of wheels
     */
    int getNumberOfWheels();

    /**
     * Sets the number of wheels on the motor vehicle.
     *
     * @param wheels The number of wheels (typically 2 or 3)
     * @throws IllegalArgumentException if wheels is not 2 or 3
     */
    void setNumberOfWheels(int wheels);

    /**
     * Gets the type of motorcycle.
     *
     * @return The motorcycle type (e.g., "sports", "cruiser", "off-road")
     */
    String getMotorcycleType();

    /**
     * Sets the type of motorcycle.
     *
     * @param type The motorcycle type (must be "sports", "cruiser", or "off-road")
     * @throws IllegalArgumentException if type is not one of the allowed values
     */
    void setMotorcycleType(String type);
}
