package org.example.ParkingStrategy;

import org.example.ParkingSpot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots);
}
