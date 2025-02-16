package car_rental_agency.interfaces;

/**
 * Base interface for all vehicle types in the rental system.
 * Defines common properties that every vehicle must implement.
 * 
 * @author Your Name
 * @version 1.0
 */
public interface Vehicle {
    /**
     * Gets the manufacturer of the vehicle.
     * 
     * @return The vehicle's make as a String
     */
    String getMake();

    /**
     * Sets the manufacturer of the vehicle.
     * 
     * @param make The manufacturer name
     * @throws IllegalArgumentException if make is null or empty
     */
    void setMake(String make);

    /**
     * Gets the model name of the vehicle.
     * 
     * @return The vehicle's model as a String
     */
    String getModel();

    /**
     * Sets the model name of the vehicle.
     * 
     * @param model The model name
     * @throws IllegalArgumentException if model is null or empty
     */
    void setModel(String model);

    /**
     * Gets the manufacturing year of the vehicle.
     * 
     * @return The vehicle's year of manufacture
     */
    int getYear();

    /**
     * Sets the manufacturing year of the vehicle.
     * 
     * @param year The year of manufacture
     * @throws IllegalArgumentException if year is less than 1900 or greater than current year
     */
    void setYear(int year);
}
