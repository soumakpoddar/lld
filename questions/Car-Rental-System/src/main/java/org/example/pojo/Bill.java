package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Bill {
    private Reservation reservation;
    private boolean isPaid;
    private double amount;
}
