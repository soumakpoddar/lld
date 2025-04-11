package org.example.entity;

import org.example.enums.OrderStatus;
import org.example.service.pricingService.ICalcPrice;

import java.util.Map;

public class Order {
    private Restaurant restaurant;
    private Map<String, Integer> orderItems;
    private double totalPrice;
    private OrderStatus orderStatus;

    public Order(Map<String, Integer> orderItems) {
        this.restaurant = null;
        this.orderItems = orderItems;
        this.totalPrice = 0;
        this.orderStatus = OrderStatus.PENDING;
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
