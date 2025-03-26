package org.example.rateLimitService.config;

import org.example.rateLimitService.IRateLimiter;

import java.util.ArrayList;
import java.util.List;

public class RateLimiterConfig {
    private int maxRequests;
    private long windowSizeInMillis;
    private List<IRateLimiter> observers;

    public RateLimiterConfig(int maxRequests, long windowSizeInMillis) {
        this.maxRequests = maxRequests;
        this.windowSizeInMillis = windowSizeInMillis;
        this.observers = new ArrayList<>();
    }

    public void addObserver(IRateLimiter observer) {
        observers.add(observer);
    }

    public void removeObserver(IRateLimiter observer) {
        observers.remove(observer);
    }

    private void notifyObservers() {
        for (IRateLimiter observer : observers) {
            observer.updateConfig(maxRequests, windowSizeInMillis);
        }
    }

    public void setMaxRequests(int maxRequests) {
        this.maxRequests = maxRequests;
        notifyObservers();
    }

    public void setWindowSizeInMillis(long windowSizeInMillis) {
        this.windowSizeInMillis = windowSizeInMillis;
        notifyObservers();
    }

    public int getMaxRequests() {
        return maxRequests;
    }

    public long getWindowSizeInMillis() {
        return windowSizeInMillis;
    }
}
