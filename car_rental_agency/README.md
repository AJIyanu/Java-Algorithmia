# Vehicle Rental System

## Introduction

The **Vehicle Rental System** is a Java-based console application that allows users to add and view different types of vehicles. The system is designed primarily for developers and maintainers, providing a clean and modular codebase for managing vehicles. It supports adding various vehicle types—cars, motorcycles, and trucks—while enforcing data validation and offering a simple text-based user interface.

---

## Features

- **Add Vehicles**: Users can add new vehicles by specifying details such as make, model, year, and other type-specific attributes.
- **View Vehicles**: Users can view a list of all vehicles currently stored in the system.
- **Data Validation**: Each vehicle type enforces specific rules (e.g., valid year ranges, acceptable fuel types, or transmission types) to ensure accurate data.
- **Extensible Architecture**: The system is designed with interfaces and separate classes for each vehicle type, making it easy to extend or modify.

---

## Class Documentation

### 1. **Car Class**

_Located in: `car_rental_agency.vehicles.Car`_

- **Purpose**: Represents a car vehicle and implements the `CarVehicle` interface.
- **Attributes**:
  - `make` (String): The manufacturer of the car.
  - `model` (String): The model name.
  - `year` (int): The manufacturing year (validated to be between 1900 and 2025).
  - `numberOfDoors` (int): The number of doors (validated between 2 and 5).
  - `fuelType` (String): The fuel type (accepted values: petrol, diesel, or electric).
- **Methods**:
  - Getters and setters for each attribute with validation checks.
  - `toString()`: Returns a formatted string describing the car (e.g., "Car: Toyota Camry 2020, Doors: 4, Fuel: petrol").

---

### 2. **Motorcycle Class**

_Located in: `car_rental_agency.vehicles.Motorcycle`_

- **Purpose**: Represents a motorcycle and implements the `MotorVehicle` interface.
- **Attributes**:
  - `make` (String): The manufacturer of the motorcycle.
  - `model` (String): The model name.
  - `year` (int): The manufacturing year (validated similarly to the car).
  - `numberOfWheels` (int): The number of wheels (accepted values: 2 or 3).
  - `motorcycleType` (String): The type of motorcycle (accepted values: sport, cruiser, off-road).
- **Methods**:
  - Getters and setters for each attribute with proper validation.
  - `toString()`: Returns a formatted string representing the motorcycle.

---

### 3. **Truck Class**

_Located in: `car_rental_agency.vehicles.Truck`_

- **Purpose**: Represents a truck and implements the `TruckVehicle` interface.
- **Attributes**:
  - `make` (String): The manufacturer.
  - `model` (String): The model name.
  - `year` (int): The manufacturing year (with validation).
  - `cargoCapacity` (double): The cargo capacity in tons (must be a positive value up to 50 tons).
  - `transmissionType` (String): The transmission type (accepted values: manual or automatic).
- **Methods**:
  - Getters and setters that enforce value ranges.
  - `toString()`: Provides a formatted string output of the truck details.

---

### 4. **VehicleRentalSystem Class**

_Located in: `car_rental_agency.VehicleRentalSystem`_

- **Purpose**: Acts as the main entry point and user interface for the system.
- **Static Variables**:
  - `CarInstances`: An `ArrayList` of all added `Car` objects.
  - `MotorcycleInstances`: An `ArrayList` of all added `Motorcycle` objects.
  - `TruckInstances`: An `ArrayList` of all added `Truck` objects.
  - `scanner`: A `Scanner` object for reading console input.
- **Static Methods**:
  - `main(String[] args)`: Runs the main application loop, prompting users for commands.
  - `getCommand(String subcommand)`: Retrieves and validates user commands. When `subcommand` is "top", it accepts commands like `add`, `view`, or `exit`; for `add` or `view`, it further asks for a vehicle type.
  - `addcmdlogic()`: Handles the logic for adding vehicles. It collects vehicle-specific attributes from the user, validates input (e.g., year, number of doors, etc.), creates an instance of the corresponding vehicle class, and stores it in the appropriate list.
  - `viewcommandlogic()`: Displays the list of vehicles for a selected type (Car, Motorcycle, or Truck).

---

## How Static Methods and Variables Are Utilized

- **Global Data Storage**:  
  Static `ArrayList` variables (`CarInstances`, `MotorcycleInstances`, and `TruckInstances`) store all vehicle instances. This approach ensures that vehicle data is accessible from anywhere within the system without needing to instantiate the `VehicleRentalSystem` class repeatedly.

- **Centralized Command Handling**:  
  The `main` method and other static methods (e.g., `getCommand`, `addcmdlogic`, `viewcommandlogic`) provide a centralized control flow for the console application. This design makes it straightforward to modify or extend command behavior.

---

## Running the Program

### Prerequisites

- **Java JDK**: Ensure that the Java Development Kit is installed on your system. Verify installation with:
  ```bash
  java -version
  ```

### Steps to Run

1. **Compile the Code**:  
   Navigate to the project directory and compile the program with:

   ```bash
   javac car_rental_agency/VehicleRentalSystem.java
   ```

   (Ensure that your directory structure aligns with the package declarations.)

2. **Execute the Program**:  
   Run the program by executing:
   ```bash
   java car_rental_agency.VehicleRentalSystem
   ```

---

## Administrator Interface Instructions

- **Main Commands**:
  - `add`: Initiates the process to add a new vehicle.
  - `view`: Displays all vehicles of a specified type.
  - `exit`: Terminates the application.
- **Vehicle Type Selection**:  
  When prompted (after typing `add` or `view`), input one of the following:

  - `car`
  - `motorcycle`
  - `truck`

- **Data Input**:  
  For adding vehicles, the system will prompt for specific details such as make, model, year, and type-specific attributes (e.g., number of doors for a car, number of wheels for a motorcycle, or cargo capacity for a truck). Follow the on-screen instructions to input valid data.

- **Error Handling**:  
  If invalid input is provided (e.g., non-numeric values for year or out-of-range values for doors), the system will prompt for re-entry of that information.

---

## Conclusion

This Vehicle Rental System provides a modular and easy-to-understand codebase, ensuring maintainability and extensibility. Developers can add further functionality—such as a persistent storage mechanism or a graphical interface—by leveraging the well-defined class structure and static management of vehicle instances.

---

## Contribution Guidelines

- **Fork or Clone**: Get a copy of the repository from GitHub.
- **Coding Standards**: Follow existing coding conventions and document new code appropriately.
- **Pull Requests**: Submit pull requests with detailed descriptions of your changes.

---

## Acknowledgments

- Special thanks to all contributors and maintainers who have helped shape this project.

---
