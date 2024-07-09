package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Theatre {
    private int theatreId;
    private City city;
    private List<Screen> screens;
    private List<Show> shows;
}
