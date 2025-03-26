package org.example.rateLimitService.impl;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class SlidingWindowRateLimiter extends AbstractRateLimiterImpl {
    private Map<String, Queue<Long>> requestTimestamps;

    public SlidingWindowRateLimiter(int maxRequests, long windowSizeInMillis) {
        super(maxRequests, windowSizeInMillis);
        requestTimestamps = new HashMap<>();
    }

    @Override
    public boolean isRequestAllowed(Object... params) {
        long currentTime = System.currentTimeMillis();
        String requestId = (String) params[0];
        requestTimestamps.putIfAbsent(requestId, new ArrayDeque<>());
        Queue<Long> tsQu = requestTimestamps.get(requestId);
        while (!tsQu.isEmpty() && currentTime - tsQu.peek() >= windowSizeInMillis) {
            tsQu.poll();
        }
        if (tsQu.size() < maxRequests) {
            tsQu.add(currentTime);
            System.out.println("Request allowed for requestId: " + requestId);
            return true;
        }
        System.out.println("Request denied for requestId: " + requestId);
        return false;
    }
}
