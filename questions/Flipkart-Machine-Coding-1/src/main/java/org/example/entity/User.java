package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private List<Order> orders;

    public User(String userName) {
        this.userName = userName;
        this.orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        this.orders.add(order);
    }
}
