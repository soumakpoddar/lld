package org.example.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.VehicleType;

@AllArgsConstructor
@Data
public class Vehicle {
    private String vehicleNumber;
    private VehicleType vehicleType;
}
