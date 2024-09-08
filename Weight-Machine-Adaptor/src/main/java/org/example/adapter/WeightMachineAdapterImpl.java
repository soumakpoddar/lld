package org.example.adapter;

import org.example.adaptee.WeightMachine;

public class WeightMachineAdapterImpl implements WeightMachineAdapter {
    private final WeightMachine weightMachine;

    public WeightMachineAdapterImpl(WeightMachine weightMachine) {
        this.weightMachine = weightMachine;
    }


    @Override
    public double getWeightInKilograms() {
        return weightMachine.getWeightInPounds() * 0.453592;
    }
}
