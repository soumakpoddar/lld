package org.example.ParkingSpot;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.pojos.Vehicle;

@AllArgsConstructor
@Data
public class ParkingSpot {
    private int id;
    private boolean isEmpty;
    private Vehicle vehicle;
    private double price;

    public void parkVehicle(Vehicle v) {
        this.vehicle = v;
        this.isEmpty = false;
    }

    public void removeVehicle() {
        this.vehicle = null;
        this.isEmpty = true;
    }

    public double cost() {
        return price;
    }
}
