package car_rental_agency;

import car_rental_agency.vehicles.*;;


public class VehicleRentalSystem {
    public static void main(String[] args) {
        try {
            Car car = new Car();
            car.setMake("Toyota");
            car.setModel("Camry");
            car.setYear(2023);
            car.setNumberOfDoors(4);
            // car.setFuelType("hybrid");

            Motorcycle motorcycle = new Motorcycle();
            motorcycle.setMake("Harley-Davidson");
            motorcycle.setModel("Street Bob");
            motorcycle.setYear(2024);
            motorcycle.setNumberOfWheels(2);
            motorcycle.setMotorcycleType("cruiser");

            Truck truck = new Truck();
            truck.setMake("Volvo");
            truck.setModel("VNL");
            truck.setYear(2022);
            truck.setCargoCapacity(40.5);
            truck.setTransmissionType("automatic");

            System.out.println(car);
            System.out.println(motorcycle);
            System.out.println(truck);

        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}