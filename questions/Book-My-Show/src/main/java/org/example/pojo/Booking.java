package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Booking {
    private int bookingId;
    private Show show;
    private List<Seat> seats;
    private Payment payment;
}
