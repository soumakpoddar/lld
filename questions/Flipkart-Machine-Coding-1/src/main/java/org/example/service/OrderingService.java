package org.example.service;

import org.example.dao.RestaurantDao;
import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.entity.User;
import org.example.enums.OrderStatus;
import org.example.service.criteriaService.ICriteriaStrategy;
import org.example.service.criteriaService.SelectionCriteriaFactory;
import org.example.service.pricingService.CalculateOrderPriceWithGST;

public class OrderingService {
    public void placeOrder(User user, Order order, String selectionCriteria) {
        try {
            ICriteriaStrategy orderSelectionCriteria = SelectionCriteriaFactory.getSelectionCriteria(selectionCriteria);
            Restaurant restaurant = orderSelectionCriteria.getRestaurant(
                    RestaurantDao.restaurantList,
                    order,
                    new CalculateOrderPriceWithGST(),
                    user
            );
            if (restaurant == null) {
                System.out.println("No restaurant found that can accept the order.");
                order.setOrderStatus(OrderStatus.REJECTED);
                user.addOrder(order);
            } else {
                System.out.println("Order placed successfully with restaurant: " + restaurant.getName());
                user.addOrder(order);
            }
        } catch (Exception e) {
            System.out.println("Error while creating order: " + e.getMessage());
        }
    }
}
