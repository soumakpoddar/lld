package org.example;

public class TurnOffAc implements ICommand {
    private AirConditioner airConditioner;

    public TurnOffAc(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void execute() {
        airConditioner.turnOff();
    }

    @Override
    public void undo() {
        airConditioner.turnOn();
    }
}
