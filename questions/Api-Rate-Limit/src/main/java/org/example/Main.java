package org.example;

import org.example.rateLimitService.IRateLimiter;
import org.example.rateLimitService.RateLimiterFactory;
import org.example.rateLimitService.config.RateLimiterConfig;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiterConfig rateLimiterConfig = new RateLimiterConfig(1, 3000);
        IRateLimiter fixedWindowRateLimiter = RateLimiterFactory.createRateLimiter("fixedwindow", rateLimiterConfig);
        IRateLimiter slidingWindowRateLimiter = RateLimiterFactory.createRateLimiter("slidingwindow", rateLimiterConfig);
        for (int i=0;i<10;i++) {
            System.out.println("Request " + i + " fixedWindowRateLimiter: " + fixedWindowRateLimiter.allowRequest(String.valueOf(i % 2)));
            Thread.sleep(300);
            if (i == 6) {
                rateLimiterConfig.setMaxRequests(5);
            }
        }
    }
}