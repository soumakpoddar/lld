package org.example.scheduler;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class FifoScheduler implements TaskScheduler {
    private final BlockingQueue<Runnable> queue;

    public FifoScheduler(int queueSize) {
        this.queue = new LinkedBlockingDeque<>(queueSize);
    }

    @Override
    public void submit(Runnable task) throws InterruptedException {
        queue.add(task);
    }

    @Override
    public Runnable take() throws InterruptedException {
        return queue.take();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}
