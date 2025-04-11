package org.example.service;

import org.example.dao.RestaurantDao;
import org.example.entity.Pair;
import org.example.entity.Restaurant;

import java.util.Map;

public class RestaurantService {
    public Restaurant onBoardRestaurant(String name, int maxCapacity, double rating, Map<String, Pair> menu) {
        Restaurant restaurant = new Restaurant(name, maxCapacity, rating, menu);
        RestaurantDao.restaurantMap.put(name, restaurant);
        RestaurantDao.restaurantList.add(restaurant);
        return restaurant;
    }
}
