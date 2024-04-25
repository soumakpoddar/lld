package org.example;

import org.example.ParkingSpot.ParkingSpot;
import org.example.ParkingSpotManager.ParkingSpotManagerFactory;
import org.example.enums.VehicleType;
import org.example.gate.EntranceGate;
import org.example.gate.ExitGate;
import org.example.pojos.Ticket;
import org.example.pojos.Vehicle;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ParkingLotMain {
    public static void main(String[] args) {
        //add parking spots...
        List<ParkingSpot> parkingSpots = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            parkingSpots.add(new ParkingSpot(i, true, null, 10.0));
        }

        // create parking spot manager factory...
        ParkingSpotManagerFactory parkingSpotManagerFactory = new ParkingSpotManagerFactory();

        // create entrance and exit gates...
        EntranceGate entranceGate = new EntranceGate(parkingSpotManagerFactory, parkingSpots);
        ExitGate exitGate = new ExitGate(parkingSpotManagerFactory, parkingSpots);

        // entry...
        Vehicle vehicle = new Vehicle("KA53HR7506", VehicleType.TwoWheeler);
        ParkingSpot parkingSpot = entranceGate.findParkingSpot(vehicle);
        Ticket ticket = entranceGate.getTicket(vehicle, new Timestamp(System.currentTimeMillis()), parkingSpot);

        // exit...
        exitGate.removeVehicle(ticket);
    }
}