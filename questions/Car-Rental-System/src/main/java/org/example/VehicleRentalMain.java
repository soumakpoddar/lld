package org.example;

import org.example.enums.VehicleType;
import org.example.pojo.*;
import org.example.service.VehicleRentalService;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalMain {
    public static void main(String[] args) {
        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalService vehicleRentalService = new VehicleRentalService(users, stores);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location( 1, "Whitefield", "Bangalore", "Karnataka", 560067);
        Store store = vehicleRentalService.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicle(VehicleType.CAR);


        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(storeVehicles.get(0), users.get(0));

        //4. generate the bill
        Bill bill = new Bill(reservation, false, 1000.0);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation);
    }

    public static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        Vehicle vehicle1 = new Car();
        vehicle1.setId(1);
        vehicle1.setVehicleType(VehicleType.CAR);
        Vehicle vehicle2 = new Bike();
        vehicle1.setId(2);
        vehicle1.setVehicleType(VehicleType.BIKE);
        vehicles.add(vehicle1);
        vehicles.add(vehicle2);
        return vehicles;
    }

    public static List<User> addUsers() {
        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores = new ArrayList<>();
        Store store1 = new Store();
        store1.setStoreId(1);
        store1.setVehicles(vehicles);
        stores.add(store1);
        return stores;
    }
}