package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.pojo.Location;
import org.example.pojo.Store;
import org.example.pojo.User;

import java.util.List;
import java.util.Objects;

@Data
@AllArgsConstructor
public class VehicleRentalService {
    private List<User> users;
    private List<Store> stores;

    public Store getStore(Location location) {
        return stores
                .stream()
                .filter(Objects::nonNull)
                .filter(store -> store.getLocation().getLocationId() == location.getLocationId())
                .findFirst()
                .get();
    }
}
