package org.example.entity;

import org.example.enums.OrderStatus;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Restaurant {
    private String name;
    private Map<String, Pair> menu;
    private AtomicInteger maxCapacity;
    private double rating;
    private Map<User, List<Order>> orders;
    private Queue<Order> orderQueue;

    public Restaurant(String name, int maxCapacity, double rating, Map<String, Pair> menu) {
        this.name = name;
        this.menu = menu;
        this.maxCapacity = new AtomicInteger(maxCapacity);
        this.rating = rating;
        this.orders = new ConcurrentHashMap<>();
        orderQueue = new ConcurrentLinkedDeque<>();
    }

    public int getMaxCapacity() {
        return maxCapacity.get();
    }

    public Map<String, Pair> getMenu() {
        return menu;
    }

    public void addOrUpdateMenuItem(String itemName, double price, int quantity) {
        menu.put(itemName, new Pair(price, quantity));
        System.out.println("Menu updated: " + itemName + " - Price: " + price + ", Quantity: " + quantity + " for " + name);
    }

    public double getRating() {
        return rating;
    }

    private void takeOrder() {
        maxCapacity.decrementAndGet();
    }

    private void completeOrder() {
        maxCapacity.incrementAndGet();
    }

    public String getName() {
        return name;
    }

    public boolean acceptOrder(User user, Order order) {
        if (maxCapacity.get() > 0) {
            takeOrder();
            order.setOrderStatus(OrderStatus.ACCEPTED);
            List<Order> userOrders = orders.getOrDefault(user, new ArrayList<>());
            userOrders.add(order);
            orders.put(user, userOrders);
            orderQueue.add(order);
            return true;
        }
        return false;
    }

    public void startProcessing() {
        while (true) {
            while (!orderQueue.isEmpty()) {
                Order order = orderQueue.poll();
                System.out.println("Processing order for " + name);
                order.setOrderStatus(OrderStatus.IN_PROGRESS);
                try {
                    Thread.sleep(2000); // Simulate processing time
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                System.out.println("Order processed for " + name);
                order.setOrderStatus(OrderStatus.READY_FOR_PICKUP);
                completeOrder();
            }
        }
    }
}
