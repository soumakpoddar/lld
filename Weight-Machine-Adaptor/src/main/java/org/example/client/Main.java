package org.example.client;

import org.example.adaptee.WeightMachineBaby;
import org.example.adapter.WeightMachineAdapter;
import org.example.adapter.WeightMachineAdapterImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdapter weightMachineAdapter = new WeightMachineAdapterImpl(new WeightMachineBaby());
        System.out.println(weightMachineAdapter.getWeightInKilograms());
    }
}