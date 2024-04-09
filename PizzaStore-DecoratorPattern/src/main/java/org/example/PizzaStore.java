package org.example;

import org.example.Pizza.BasePizza;
import org.example.Pizza.FarmHouse;
import org.example.Pizza.VeggieDelight;
import org.example.Toppings.ExtraCheese;
import org.example.Toppings.Mushroom;

public class PizzaStore {
    public static void main(String[] args) {
        BasePizza farmHousePlusExtraCheese = new ExtraCheese(new FarmHouse());
        System.out.println("Cost of FarmHouse + Extra Cheese : " + farmHousePlusExtraCheese.cost());

        BasePizza veggieDelightPlusExtraCheesePlusMushroom = new Mushroom(new ExtraCheese(new VeggieDelight()));
        System.out.println("Cost of VeggieDelight + Extra Cheese + Mushroom : " + veggieDelightPlusExtraCheesePlusMushroom.cost());
    }
}