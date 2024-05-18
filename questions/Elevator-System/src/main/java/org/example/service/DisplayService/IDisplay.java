package org.example.service.DisplayService;

import org.example.enums.Direction;

public interface IDisplay {
    public void setDisplay(int floor, Direction direction);
    public void showDisplay();
}
