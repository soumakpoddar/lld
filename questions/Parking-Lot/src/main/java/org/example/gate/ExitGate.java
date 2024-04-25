package org.example.gate;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.ParkingSpot.ParkingSpot;
import org.example.ParkingSpotManager.ParkingSpotManager;
import org.example.ParkingSpotManager.ParkingSpotManagerFactory;
import org.example.pojos.Ticket;

import java.util.List;

@Data
@AllArgsConstructor
public class ExitGate implements Gate {
    private ParkingSpotManagerFactory parkingSpotManagerFactory;
    private List<ParkingSpot> parkingSpots;

    public void removeVehicle(Ticket t) {
        System.out.println("Total time : " + (System.currentTimeMillis() - t.getEntryTime().getTime()) / 1000 + " seconds");
        double totalAmountToPay = t.getParkingSpot().cost() * (System.currentTimeMillis() - t.getEntryTime().getTime());
        System.out.println("Total amount to pay : " + totalAmountToPay);

        ParkingSpotManager parkingSpotManager = parkingSpotManagerFactory.getParkingSpotManagerByVehicleType(t.getV(), parkingSpots);
        parkingSpotManager.removeVehicle(t.getV());
    }
}
