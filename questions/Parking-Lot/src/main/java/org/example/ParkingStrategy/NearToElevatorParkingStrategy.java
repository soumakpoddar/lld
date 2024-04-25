package org.example.ParkingStrategy;

import org.example.ParkingSpot.ParkingSpot;

import java.util.List;

public class NearToElevatorParkingStrategy implements ParkingStrategy {
    @Override
    public ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots) {
        System.out.println("Finding parking spot near to elevator");
        return parkingSpots.stream().filter(parkingSpot -> parkingSpot.isEmpty()).findFirst().get();
    }
}
