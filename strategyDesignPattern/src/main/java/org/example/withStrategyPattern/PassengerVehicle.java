package org.example.withStrategyPattern;

import org.example.withStrategyPattern.strategy.NormalDriveStrategy;

public class PassengerVehicle extends Vehicle {
    public PassengerVehicle() {
        super(new NormalDriveStrategy());
    }
}
