package org.example;

public class VehicleFactory {
    public static Vehicle getVehicle(String type) {
        if (type.equals("car")) {
            return new Car();
        } else {
            return new NullVehicle();
        }
    }
}
