package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Show {
    private int showId;
    private Movie movie;
    private Screen screen;
    private int showTime;
    private List<Integer> bookedSeats;
}
