package org.example.rateLimitService.impl;

import org.example.rateLimitService.IRateLimiter;

public abstract class AbstractRateLimiterImpl implements IRateLimiter {
    protected int maxRequests;
    protected long windowSizeInMillis;

    public AbstractRateLimiterImpl(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    @Override
    public boolean allowRequest(Object... params) {
        return isRequestAllowed(params);
    }

    @Override
    public void updateConfig(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
    }

    protected abstract boolean isRequestAllowed(Object[] params);
}
