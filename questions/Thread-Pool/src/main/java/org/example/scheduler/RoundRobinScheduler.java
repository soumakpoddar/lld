package org.example.scheduler;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

public class RoundRobinScheduler implements TaskScheduler {
    private final List<BlockingQueue<Runnable>> queue;
    private final AtomicInteger index = new AtomicInteger(0);

    public RoundRobinScheduler(int numOfQueues, int queueSize) {
        this.queue = new ArrayList<>(numOfQueues);
        for(int i=0;i<numOfQueues;i++) {
            queue.add(new LinkedBlockingDeque<>(queueSize));
        }
    }

    @Override
    public void submit(Runnable task) throws InterruptedException {
        int ind = index.getAndIncrement() % queue.size();
        queue.get(ind).add(task);
    }
    
    @Override
    public Runnable take() throws InterruptedException {
        while (true) {
            for(BlockingQueue<Runnable> q : queue) {
                Runnable task = q.poll();
                if(task != null) {
                    return task;
                }
            }
            // If all queues are empty, wait a bit before checking again
            Thread.sleep(10);
        }
    }

    @Override
    public boolean isEmpty() {
        return queue.stream().allMatch(BlockingQueue::isEmpty);
    }
}
