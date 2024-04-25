package org.example.ParkingSpot;

import org.example.pojos.Vehicle;

public class FourWheelerParkingSpot extends ParkingSpot {
    private final double price = 100.0;

    public FourWheelerParkingSpot(int id, boolean isEmpty, Vehicle vehicle, double price) {
        super(id, isEmpty, vehicle, price);
    }

    @Override
    public double cost() {
        return price;
    }
}
