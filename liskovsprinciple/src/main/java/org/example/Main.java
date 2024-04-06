package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Bike());
        vehicleList.add(new Car());
        vehicleList.add(new Bicycle()); // breaks liskov's principle as throws NPE below...

//        for (Vehicle vehicle : vehicleList) {
//            System.out.println(vehicle.hasEngine().toString());
//        }

        for (Vehicle vehicle : vehicleList) {
            System.out.println(vehicle.getNumberOfWheels().toString());
        }
    }
}