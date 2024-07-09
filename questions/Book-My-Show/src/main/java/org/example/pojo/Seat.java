package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.SeatCategory;

@Data
@AllArgsConstructor
public class Seat {
    private int seatId;
    private int row;
    private SeatCategory seatCategory;
    private int price;
}
