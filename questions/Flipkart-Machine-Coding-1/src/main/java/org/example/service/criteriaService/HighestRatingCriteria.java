package org.example.service.criteriaService;

import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.entity.User;
import org.example.service.pricingService.ICalcPrice;

import java.util.ArrayList;
import java.util.List;

public class HighestRatingCriteria implements ICriteriaStrategy {

    @Override
    public Restaurant getRestaurant(List<Restaurant> restaurants, Order order, ICalcPrice pricingService, User user) {
        List<Restaurant> servingRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getMenu().keySet().containsAll(order.getOrderItems().keySet()) && restaurant.getMaxCapacity() > order.getOrderItems().size()) {
                servingRestaurants.add(restaurant);
            }
        }
        if (!servingRestaurants.isEmpty()) {
            servingRestaurants.sort((r1, r2) -> {
                return Double.compare(r2.getRating(), r1.getRating());
            });
            for (Restaurant restaurant : servingRestaurants) {
                boolean isOrderAccepted = restaurant.acceptOrder(user, order);
                if (isOrderAccepted) {
                    return restaurant;
                }
            }
        }
        return null;
    }
}
