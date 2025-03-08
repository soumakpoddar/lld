package org.example.entity;

public class Balance {
    private double amount;
    private String currency;

    public Balance(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }
}
