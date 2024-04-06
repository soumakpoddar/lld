package org.example;

public class Vehicle {
    public Integer getNumberOfWheels() {
        return 2;
    }

    // remove the below method to fix the Liskov's principle violation as this method is not generic...
    // keep only generic methods in the parent class...
//    public Boolean hasEngine() {
//        return true;
//    }
}
