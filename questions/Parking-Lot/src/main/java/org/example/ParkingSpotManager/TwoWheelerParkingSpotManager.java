package org.example.ParkingSpotManager;

import org.example.ParkingSpot.ParkingSpot;
import org.example.ParkingStrategy.NearToElevatorParkingStrategy;
import org.example.ParkingStrategy.ParkingStrategy;

import java.util.List;

public class TwoWheelerParkingSpotManager extends ParkingSpotManager {

    public TwoWheelerParkingSpotManager(List<ParkingSpot> parkingSpots) {
        super(parkingSpots);
    }

    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots) {
        ParkingStrategy parkingStrategy = new NearToElevatorParkingStrategy();
        return parkingStrategy.findParkingSpace(parkingSpots);
    }
}
