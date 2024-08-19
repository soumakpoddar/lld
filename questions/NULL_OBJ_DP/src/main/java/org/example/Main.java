package org.example;

public class Main {
    public static void main(String[] args) {
        Vehicle v = VehicleFactory.getVehicle("bike");
        printVehicleDetails(v);
    }

    private static void printVehicleDetails(Vehicle v) {
        System.out.println("Tank Capacity: " + v.getTankCapacity());
        System.out.println("Seating Capacity: " + v.getSeatingCapacity());
    }
}