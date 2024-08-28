package org.example.pojo;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class Card {
    private int cardNumber;
    private int pin;
    private int cvv;
    private String name;
    private Timestamp expiryDate;
    private double balance;

    public boolean checkPin(int pin) {
        return this.pin == pin;
    }
}
