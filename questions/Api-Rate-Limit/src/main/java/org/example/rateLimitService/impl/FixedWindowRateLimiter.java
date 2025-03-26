package org.example.rateLimitService.impl;

import java.util.HashMap;
import java.util.Map;

public class FixedWindowRateLimiter extends AbstractRateLimiterImpl {
    private Map<String, Integer> requestCount;
    private Map<String, Long> windowStartTimes;

    public FixedWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        super(maxRequests, windowSizeInMillis);
        this.requestCount = new HashMap<>();
        this.windowStartTimes = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(Object... params) {
        long currentTime = System.currentTimeMillis();
        String requestId = (String) params[0];
        requestCount.putIfAbsent(requestId, 0);
        windowStartTimes.putIfAbsent(requestId, currentTime);

        long windowStartTime = windowStartTimes.get(requestId);
        if (currentTime - windowStartTime >= windowSizeInMillis) {
            requestCount.put(requestId, 0);
            windowStartTimes.put(requestId, currentTime);
        }

        int currentRequestCount = requestCount.get(requestId);
        if (currentRequestCount < maxRequests) {
            requestCount.put(requestId, currentRequestCount + 1);
            System.out.println("Request allowed for requestId: " + requestId);
            return true;
        }
        System.out.println("Request denied for requestId: " + requestId);
        return false;
    }
}
