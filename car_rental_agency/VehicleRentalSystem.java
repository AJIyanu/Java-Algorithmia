package car_rental_agency;

import java.util.ArrayList;
import java.util.Scanner;
import car_rental_agency.vehicles.*;



public class VehicleRentalSystem {

    private static ArrayList<Car> CarInstances = new ArrayList<>();
    private static ArrayList<Motorcycle> MotorcycleInstances = new ArrayList<>();
    private static ArrayList<Truck> TruckInstances = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String command;
        do {
            command = getCommand("top");
            if (command != null) {
                if (command.equals("add")) {
                    addcmdlogic();
                } else if (command.equals("view")) {
                    viewcommandlogic();
                }
            } else {
                command = "";
            }
            System.out.println("--------------------\n");
        } while (!command.equals("exit"));
        scanner.close();

    }
    
    /**
     * get user command
     * 
     * @param subcommand ('top', 'add', 'list')
     * @return valid command or null
     */
    public static String getCommand(String subcommand) {
        String command = null;
        while (command == null) {
            if (subcommand.equals("top")) {
                System.out.println("Available commands: add, view, exit");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("add") || input.equals("view") || input.equals("exit")) {
                    command = input;
                } else {
                    System.out.println("Invalid top-level command.");
                }
            } else if (subcommand.equals("add") || subcommand.equals("view")) {
                System.out.println("Available vehicle types: Car, Motorcycle, Truck");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("car") || input.equals("motorcycle") || input.equals("truck")) {
                    command = input;
                } else {
                    System.out.println("Invalid vehicle type.");
                }
            }
        }
        return command;
    }

    public static void addcmdlogic() {
        String command = getCommand("add");
        if (command.equals("car")) {
            System.out.println("Vehicle make");
            String make = scanner.nextLine();
            System.out.println("Vehicle Model");
            String model = scanner.nextLine();
            System.out.println("Vehicle Fuel Type");
            String fuelType = null;
            while (fuelType == null) {
                System.out.println("Vehicle Fuel Type (Petrol, Diesel, Electric):");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("petrol") || input.equals("diesel") || input.equals("electric")) {
                    fuelType = input;
                } else {
                    System.out.println("Invalid fuel type. Please enter Petrol, Diesel, or Electric.");
                }
            }
            int doors = 0;
            int year = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Number of doors (2-5):");
                    doors = Integer.parseInt(scanner.nextLine());
                    if (doors >= 2 && doors <= 5) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid number of doors. Please enter a number between 2 and 5.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Year of manufacture (1900-2025):");
                    year = Integer.parseInt(scanner.nextLine());
                    if (year >= 1900 && year <= 2025) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid year. Please enter a year between 1900 and 2025.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            Car car = new Car();
            car.setFuelType(fuelType);
            car.setMake(make);
            car.setModel(model);
            car.setNumberOfDoors(doors);
            car.setYear(year);
            CarInstances.add(car);
            System.out.println("Car added successfully.");
            System.out.println(car);
        } else if (command.equals("motorcycle")) {
            System.out.println("Vehicle make");
            String make = scanner.nextLine();
            System.out.println("Vehicle Model");
            String model = scanner.nextLine();
            int year = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Year of manufacture (1900-2025):");
                    year = Integer.parseInt(scanner.nextLine());
                    if (year >= 1900 && year <= 2025) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid year. Please enter a year between 1900 and 2025.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            int wheels = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Number of wheels (2 or 3):");
                    wheels = Integer.parseInt(scanner.nextLine());
                    if (wheels == 2 || wheels == 3) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid number of wheels. Please enter 2 or 3.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            String motorcycleType = null;
            while (motorcycleType == null) {
                System.out.println("Motorcycle type (Sport, Cruiser, Off-Road):");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("sport") || input.equals("cruiser") || input.equals("off-road")) {
                    motorcycleType = input;
                } else {
                    System.out.println("Invalid motorcycle type. Please enter Sport, Cruiser, or Off-Road.");
                }
            }

            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setMake(make);
            motorcycle.setModel(model);
            motorcycle.setYear(year);
            motorcycle.setNumberOfWheels(wheels);
            motorcycle.setMotorcycleType(motorcycleType);
            MotorcycleInstances.add(motorcycle);
            System.out.println("Motorcycle added successfully.");
            System.out.println(motorcycle);

        } else if (command.equals("truck")) {
            System.out.println("Vehicle make");
            String make = scanner.nextLine();
            System.out.println("Vehicle Model");
            String model = scanner.nextLine();
            int year = 0;
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.println("Year of manufacture (1900-2025):");
                    year = Integer.parseInt(scanner.nextLine());
                    if (year >= 1900 && year <= 2025) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid year. Please enter a year between 1900 and 2025.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter an integer.");
                }
            }

            double cargoCapacity = 0;
            validInput = false;
            while (!validInput) {
                try {
                    System.out.println("Cargo capacity (in tons):");
                    cargoCapacity = Double.parseDouble(scanner.nextLine());
                    if (cargoCapacity > 0) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid cargo capacity. Please enter a positive value.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a number.");
                }
            }

            String transmissionType = null;
            while (transmissionType == null) {
                System.out.println("Transmission type (Automatic or Manual):");
                String input = scanner.nextLine().trim().toLowerCase();
                if (input.equals("automatic") || input.equals("manual")) {
                    transmissionType = input;
                } else {
                    System.out.println("Invalid transmission type. Please enter Automatic or Manual.");
                }
            }

            Truck truck = new Truck();
            truck.setMake(make);
            truck.setModel(model);
            truck.setYear(year);
            truck.setCargoCapacity(cargoCapacity);
            truck.setTransmissionType(transmissionType);
            TruckInstances.add(truck);
            System.out.println("Truck added successfully.");
            System.out.println(truck);

        }
    }

    public static void viewcommandlogic() {
        String command = getCommand("view");
        if (command.equals("car")) {
            if (CarInstances.isEmpty()) {
                System.out.println("No cars found.");
            } else {
                for (Car car : CarInstances) {
                    System.out.println(car);
                }
            }
        } else if (command.equals("motorcycle")) {
            if (MotorcycleInstances.isEmpty()) {
                System.out.println("No motorcycles found.");
            } else {
                for (Motorcycle motorcycle : MotorcycleInstances) {
                    System.out.println(motorcycle);
                }
            }
        } else if (command.equals("truck")) {
            if (TruckInstances.isEmpty()) {
                System.out.println("No trucks found.");
            } else {
                for (Truck truck : TruckInstances) {
                    System.out.println(truck);
                }
            }
        }
    }
}