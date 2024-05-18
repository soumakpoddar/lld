package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Location {
    private int locationId;
    private String address;
    private String city;
    private String state;
    private int pincode;
}
