package org.example.ParkingSpot;

import org.example.pojos.Vehicle;

public class TwoWheelerParkingSpot extends ParkingSpot {
    private final double price = 50.0;

    public TwoWheelerParkingSpot(int id, boolean isEmpty, Vehicle vehicle, double price) {
        super(id, isEmpty, vehicle, price);
    }

    @Override
    public double cost() {
        return price;
    }
}
