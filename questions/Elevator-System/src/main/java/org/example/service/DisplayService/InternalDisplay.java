package org.example.service.DisplayService;

import org.example.enums.Direction;

public class InternalDisplay implements IDisplay {
    private int floorNo;
    private Direction direction;

    @Override
    public void setDisplay(int floor, Direction direction) {
        this.floorNo = floor;
        this.direction = direction;
    }

    @Override
    public void showDisplay() {
        System.out.println(floorNo);
        System.out.println(direction);
    }
}
