package org.example.entity;

public class Pair {
    private double price;
    private int quantity;

    public Pair(double price, int quantity) {
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}
