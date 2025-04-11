package org.example.service.pricingService;

import org.example.entity.Pair;

import java.util.Map;

public class CalculateOrderPriceWithGST implements ICalcPrice {

    @Override
    public double calculateOrderPrice(double currentPrice) {
        double gst = 0.18 * currentPrice;
        return currentPrice + gst;
    }
}
