package org.example;

public class AirConditioner {
    private boolean isOn;
    private double temperature;

    public AirConditioner() {
        this.isOn = false;
    }

    public void turnOn() {
        this.isOn = true;
        System.out.println("Air conditioner is on");
    }

    public void turnOff() {
        this.isOn = false;
        System.out.println("Air conditioner is off");
    }

    private void setTemperature(double temperature) {
        this.temperature = temperature;
        System.out.println("Temperature set to " + this.temperature + "°C");
    }
}
