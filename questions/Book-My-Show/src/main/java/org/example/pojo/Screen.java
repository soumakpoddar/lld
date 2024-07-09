package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Screen {
    private int screenId;
    List<Seat> seats;
}
