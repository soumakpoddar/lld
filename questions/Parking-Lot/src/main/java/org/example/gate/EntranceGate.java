package org.example.gate;

import lombok.AllArgsConstructor;
import org.example.ParkingSpot.ParkingSpot;
import org.example.ParkingSpotManager.ParkingSpotManager;
import org.example.ParkingSpotManager.ParkingSpotManagerFactory;
import org.example.pojos.Ticket;
import org.example.pojos.Vehicle;

import java.sql.Timestamp;
import java.util.List;

@AllArgsConstructor
public class EntranceGate implements Gate {
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private List<ParkingSpot> parkingSpots;

    public Ticket getTicket(Vehicle v, Timestamp entryTime, ParkingSpot parkingSpot) {
        System.out.println("Generating ticket for vehicle : " + v.getVehicleNumber());
        return new Ticket(v, entryTime, parkingSpot);
    }

    public ParkingSpot findParkingSpot(Vehicle vehicle) {
        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManagerByVehicleType(vehicle, parkingSpots);
        ParkingSpot parkingSpot = parkingSpotManager.findParkingSpace(parkingSpots);
        return parkingSpot;
    }
}
