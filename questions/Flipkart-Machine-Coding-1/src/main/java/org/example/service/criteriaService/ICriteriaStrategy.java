package org.example.service.criteriaService;

import org.example.entity.Order;
import org.example.entity.Restaurant;
import org.example.entity.User;
import org.example.service.pricingService.ICalcPrice;

import java.util.List;

public interface ICriteriaStrategy {
    Restaurant getRestaurant(List<Restaurant> restaurants, Order order, ICalcPrice pricingService, User user);
}
