package org.example.pojo;

import lombok.Data;
import org.example.enums.ReservationStatus;
import org.example.enums.VehicleType;
import org.example.service.VehicleInventoryManagementService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Data
public class Store {
    private int storeId;
    private VehicleInventoryManagementService vehicleInventoryManagementService;
    private Location location;
    private List<Reservation> reservations = new ArrayList<>();

    public List<Vehicle> getVehicle(VehicleType vehicleType) {
        return vehicleInventoryManagementService.getVehicles()
                .stream()
                .filter(Objects::nonNull)
                .filter(vehicle -> vehicle.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagementService = new VehicleInventoryManagementService(vehicles);
    }

    public boolean completeReservation(Reservation reservation) {
        return true;
    }

    public Reservation createReservation(Vehicle vehicle, User user) {
        Reservation reservation = new Reservation(1, user, vehicle, new Date(System.currentTimeMillis()), null, null, null, null, ReservationStatus.SCHEDULED);
        reservations.add(reservation);
        return reservation;
    }
}
