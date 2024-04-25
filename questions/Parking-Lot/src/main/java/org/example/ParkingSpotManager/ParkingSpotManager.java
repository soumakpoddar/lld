package org.example.ParkingSpotManager;

import lombok.Data;
import org.example.ParkingSpot.ParkingSpot;
import org.example.pojos.Vehicle;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Data
public abstract class ParkingSpotManager {
    private List<ParkingSpot> parkingSpots;

    public ParkingSpotManager(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public abstract ParkingSpot findParkingSpace(List<ParkingSpot> parkingSpots);

    public void addParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.add(parkingSpot);
    }

    public void removeParkingSpot(ParkingSpot parkingSpot) {
        parkingSpots.remove(parkingSpot);
    }

    public void parkVehicle(Vehicle v, ParkingSpot ps) {
        Optional<ParkingSpot> parkingSpotOptional = parkingSpots.stream()
                .filter(Objects::nonNull)
                .filter(parkingSpot -> parkingSpot.equals(ps))
                .findFirst();

        if (parkingSpotOptional.isPresent()) {
            ParkingSpot parkingSpot = parkingSpotOptional.get();
            parkingSpot.parkVehicle(v);
        } else {
            System.out.println("Parking spot not found");
        }
    }

    public void removeVehicle(Vehicle v) {
        Optional<ParkingSpot> parkingSpotOptional = parkingSpots.stream()
                .filter(Objects::nonNull)
                .filter(parkingSpot -> parkingSpot.getVehicle().equals(v))
                .findFirst();

        if (parkingSpotOptional.isPresent()) {
            ParkingSpot parkingSpot = parkingSpotOptional.get();
            parkingSpot.removeVehicle();
        } else {
            System.out.println("Vehicle not found");
        }
    }
}
