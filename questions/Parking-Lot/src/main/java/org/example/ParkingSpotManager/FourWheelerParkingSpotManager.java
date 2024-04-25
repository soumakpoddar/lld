package org.example.ParkingSpotManager;

import org.example.ParkingSpot.ParkingSpot;
import org.example.ParkingStrategy.NearToEntranceParkingStrategy;
import org.example.ParkingStrategy.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager {
    public FourWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots) {
        ParkingStrategy parkingStrategy = new NearToEntranceParkingStrategy();
        return parkingStrategy.findParkingSpace(parkingSpots);
    }
}
