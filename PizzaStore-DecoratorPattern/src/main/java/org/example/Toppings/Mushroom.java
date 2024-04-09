package org.example.Toppings;

import org.example.Pizza.BasePizza;

public class Mushroom extends ToppingsDecorator {
    BasePizza basePizza;

    public Mushroom(BasePizza basePizza) {
        this.basePizza = basePizza;
    }

    @Override
    public int cost() {
        return basePizza.cost() + 15;
    }
}
