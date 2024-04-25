package org.example.ParkingStrategy;

import org.example.ParkingSpot.ParkingSpot;

import java.util.List;

public class NearToEntranceParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots) {
        System.out.println("Finding parking spot near to entrance");
        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.isEmpty()).findFirst().get();
    }
}
