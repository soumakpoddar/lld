package org.example;

import org.example.scheduler.*;


public class Main {

    public static void main(String[] args) throws InterruptedException {
        TaskScheduler roundRobinScheduler = new RoundRobinScheduler(3, 30);
        TaskScheduler fifoScheduler = new FifoScheduler(30);
        ThreadPool roundRobinPool = new ThreadPool(3, roundRobinScheduler);
        ThreadPool fifoPool = new ThreadPool(3, fifoScheduler);

        // Submit short tasks
        for (int i = 0; i < 30; i++) {
            final int id = i;
            fifoPool.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " executing task " + id);
                    Thread.sleep(2000);
                } catch (Exception ignored) {}
            });
        }

       fifoPool.shutdown();
    }
}
