package org.example.service.pricingService;

import org.example.entity.Pair;

import java.util.Map;

public interface ICalcPrice {
    double calculateOrderPrice(double currentPrice);
}
