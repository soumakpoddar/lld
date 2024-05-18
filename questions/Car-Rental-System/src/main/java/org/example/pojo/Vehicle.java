package org.example.pojo;

import lombok.Data;
import org.example.enums.Status;
import org.example.enums.VehicleType;

import java.util.Date;

@Data
public class Vehicle {
    private int id;
    private int vehicleNo;
    private VehicleType vehicleType;
    private String companyName;
    private String modelName;
    private int kmDriven;
    private Date manufacturingDate;
    private int dailyRentalCost;
    private int hourlyRentalCost;
    private int noOfSeats;
    private Status status;
}
