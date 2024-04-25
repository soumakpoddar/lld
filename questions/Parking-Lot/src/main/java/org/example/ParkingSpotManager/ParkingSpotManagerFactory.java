package org.example.ParkingSpotManager;

import org.example.ParkingSpot.ParkingSpot;
import org.example.enums.VehicleType;
import org.example.pojos.Vehicle;

import java.util.List;

public class ParkingSpotManagerFactory {
    public ParkingSpotManager getParkingSpotManagerByVehicleType(Vehicle v, List<ParkingSpot> parkingSpots) {
        if (v.getVehicleType().equals(VehicleType.TwoWheeler)) {
            return new TwoWheelerParkingSpotManager(parkingSpots);
        } else if (v.getVehicleType().equals(VehicleType.FourWheeler)) {
            return new FourWheelerParkingSpotManager(parkingSpots);
        } else {
            return null;
        }
    }
}
