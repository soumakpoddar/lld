package org.example.rateLimitService;

import org.example.rateLimitService.config.RateLimiterConfig;
import org.example.rateLimitService.impl.FixedWindowRateLimiter;
import org.example.rateLimitService.impl.SlidingWindowRateLimiter;

public class RateLimiterFactory {
    public static IRateLimiter createRateLimiter(String type, RateLimiterConfig rateLimiterConfig) {
        IRateLimiter rateLimiter;
        switch (type.toLowerCase()) {
            case "fixedwindow" -> rateLimiter = new FixedWindowRateLimiter(rateLimiterConfig.getMaxRequests(), rateLimiterConfig.getWindowSizeInMillis());
            case "slidingwindow" -> rateLimiter = new SlidingWindowRateLimiter(rateLimiterConfig.getMaxRequests(), rateLimiterConfig.getWindowSizeInMillis());
            default -> throw new IllegalArgumentException("Invalid rate limiter type");
        };
        rateLimiterConfig.addObserver(rateLimiter);
        return rateLimiter;
    }
}
