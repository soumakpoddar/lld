package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.ReservationStatus;

import java.util.Date;

@Data
@AllArgsConstructor
public class Reservation {
    private int reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date bookedFrom;
    private Date bookedTill;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationStatus reservationStatus;
}
