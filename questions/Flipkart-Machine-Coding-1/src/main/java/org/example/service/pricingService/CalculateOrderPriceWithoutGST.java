package org.example.service.pricingService;

import org.example.entity.Pair;

import java.util.Map;

public class CalculateOrderPriceWithoutGST implements ICalcPrice {

    @Override
    public double calculateOrderPrice(double currentPrice) {
        return currentPrice;
    }
}
