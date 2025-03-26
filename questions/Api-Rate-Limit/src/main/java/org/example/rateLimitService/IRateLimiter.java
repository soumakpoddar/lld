package org.example.rateLimitService;

public interface IRateLimiter {
    boolean allowRequest(Object... params);
    void updateConfig(int maxRequests, long windowSizeInMillis);
}
