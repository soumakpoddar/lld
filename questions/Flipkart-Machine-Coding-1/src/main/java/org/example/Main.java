package org.example;

import org.example.entity.Order;
import org.example.entity.Pair;
import org.example.entity.Restaurant;
import org.example.entity.User;
import org.example.service.OrderingService;
import org.example.service.RestaurantService;

import java.util.HashMap;
import java.util.Map;

// Question -> https://leetcode.com/discuss/post/6614846/flipkart-machine-coding-round-by-anonymo-pt3b/
public class Main {
    public static void main(String[] args) throws InterruptedException {
        RestaurantService restaurantService = new RestaurantService();
        OrderingService orderingService = new OrderingService();

        // 1. Onboard Restaurants...
        Restaurant r1 = restaurantService.onBoardRestaurant(
                "R1",
                5,
                4.5,
                new HashMap<>(Map.of(
                        "Veg Biryani", new Pair(100, 100),
                        "Chicken Biryani", new Pair(150, 100)
                ))
        );
        Restaurant r2 = restaurantService.onBoardRestaurant(
                "R2",
                5,
                4.0,
                new HashMap<>(Map.of(
                        "Chicken Biryani", new Pair(175, 100),
                        "Idli", new Pair(10, 100),
                        "Dosa", new Pair(50, 100),
                        "Veg Biryani", new Pair(80, 100)
                ))
        );
        Restaurant r3 = restaurantService.onBoardRestaurant(
                "R3",
                1,
                4.9,
                new HashMap<>(Map.of(
                        "Gobi Manchurian", new Pair(150, 100),
                        "Idli", new Pair(15, 100),
                        "Chicken Biryani", new Pair(175, 100),
                        "Dosa", new Pair(30, 100)
                ))
        );

        new Thread(r1::startProcessing).start();
        new Thread(r2::startProcessing).start();
        new Thread(r3::startProcessing).start();

        // 2. Update restaurant menu
        r1.addOrUpdateMenuItem(
                "Chicken65",
                250,
                100
        );
        r2.addOrUpdateMenuItem(
                "Chicken Biryani",
                150,
                100
        );

        // 3. Place Order...
        User usr1 = new User("Ashwin");
        orderingService.placeOrder(
                usr1,
                new Order(new HashMap<>(Map.of(
                        "Idli", 3,
                        "Dosa", 1
                ))),
                "Lowest cost"
        );
        User usr2 = new User("Harish");
        orderingService.placeOrder(
                usr2,
                new Order(new HashMap<>(Map.of(
                        "Idli", 3,
                        "Dosa", 1
                ))),
                "Lowest cost"
        );
        User usr3 = new User("Shruthi");
        orderingService.placeOrder(
                usr1,
                new Order(new HashMap<>(Map.of(
                        "Veg Biryani", 3
                ))),
                "Highest rating"
        );
        Thread.sleep(3000);
        orderingService.placeOrder(
                usr2,
                new Order(new HashMap<>(Map.of(
                        "Idli", 3,
                        "Dosa", 1
                ))),
                "Lowest cost"
        );
        User usr4 = new User("xyz");
        orderingService.placeOrder(
                usr4,
                new Order(new HashMap<>(Map.of(
                        "1Paneer Tikka", 1,
                        "Idli", 1
                ))),
                "Lowest cost"
        );
    }
}