package org.example.dao;

import org.example.entity.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantDao {
    public static Map<String, Restaurant> restaurantMap = new HashMap<>();
    public static List<Restaurant> restaurantList = new ArrayList<>();
}
