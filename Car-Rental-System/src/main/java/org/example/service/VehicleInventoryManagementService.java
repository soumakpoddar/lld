package org.example.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.pojo.Vehicle;

import java.util.List;

@Data
@AllArgsConstructor
public class VehicleInventoryManagementService {
    private List<Vehicle> vehicles;
}
