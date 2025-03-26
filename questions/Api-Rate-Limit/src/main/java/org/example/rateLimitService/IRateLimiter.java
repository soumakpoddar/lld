package org.example.rateLimitService;

// using strategy design pattern to implement different algorithms for rate limiting
public interface IRateLimiter {
    boolean allowRequest(Object... params);
    void updateConfig(int maxRequests, long windowSizeInMillis);
}
