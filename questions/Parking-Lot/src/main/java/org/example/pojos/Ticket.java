package org.example.pojos;

import lombok.Data;
import org.example.ParkingSpot.ParkingSpot;

import java.sql.Timestamp;

@Data
public class Ticket {
    private Timestamp entryTime;
    private Vehicle v;
    private ParkingSpot parkingSpot;

    public Ticket(Vehicle v, Timestamp entryTime, ParkingSpot parkingSpot) {
        this.v = v;
        this.entryTime = entryTime;
    }
}
