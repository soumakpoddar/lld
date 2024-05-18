package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.enums.Direction;
import org.example.enums.Status;
import org.example.service.ButtonService.InternalButton;
import org.example.service.DisplayService.InternalDisplay;

@Data
@AllArgsConstructor
public class Elevator {
    private int id;
    private InternalDisplay display;
    private int currentFloor;
    private Direction direction;
    private Status elevatorStatus;
    private InternalButton internalButton;
    private Door door;

    public boolean move(int destinationFloor) throws IllegalAccessException {
        if (currentFloor == destinationFloor) {
            throw new IllegalAccessException("Invalid Floor");
        }

        if (currentFloor < destinationFloor) {
            direction = Direction.UP;
            for (int i = currentFloor; i <= destinationFloor; i++) {
                currentFloor = i;
                display.setDisplay(currentFloor, direction);
                display.showDisplay();
            }
        } else {
            direction = Direction.DOWN;
            for (int i = currentFloor; i >= destinationFloor; i--) {
                currentFloor = i;
                display.setDisplay(currentFloor, direction);
                display.showDisplay();
            }
        }
        return true;
    }
}
