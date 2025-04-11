package org.example.service.criteriaService;

import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.entity.User;
import org.example.service.pricingService.ICalcPrice;

import java.util.ArrayList;
import java.util.List;

public class LowestCostCriteria implements ICriteriaStrategy {

    @Override
    public Restaurant getRestaurant(List<Restaurant> restaurants, Order order, ICalcPrice pricingService, User user) {
        List<Restaurant> servingRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            if (restaurant.getMenu().keySet().containsAll(order.getOrderItems().keySet())) {
                servingRestaurants.add(restaurant);
            }
        }
        if (!servingRestaurants.isEmpty()) {
            servingRestaurants.sort((r1, r2) -> {
                double cost1 = 0;
                double cost2 = 0;

                for (String item : order.getOrderItems().keySet()) {
                    cost1 += pricingService.calculateOrderPrice(r1.getMenu().get(item).getPrice() * order.getOrderItems().get(item));
                    cost2 += pricingService.calculateOrderPrice(r2.getMenu().get(item).getPrice() * order.getOrderItems().get(item));
                }

                return Double.compare(cost1, cost2);
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
