package org.example.scheduler;

public interface TaskScheduler {
    void submit(Runnable task) throws InterruptedException;
    Runnable take() throws InterruptedException;
    boolean isEmpty();
}