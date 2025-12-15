package org.example;

import java.util.concurrent.atomic.AtomicBoolean;

import org.example.scheduler.TaskScheduler;

public class ThreadPool {
    private final TaskScheduler taskScheduler;
    private final WorkerThread[] workers;
    private final AtomicBoolean isShutDown;


    public ThreadPool(int poolSize, TaskScheduler taskScheduler) {
        this.taskScheduler = taskScheduler;
        this.workers = new WorkerThread[poolSize];
        this.isShutDown = new AtomicBoolean(false);
        for(int i=0;i<poolSize;i++) {
            workers[i] = new WorkerThread("Worker - " + i);
            workers[i].start();
        }
    }

    public void submit(Runnable task) throws InterruptedException {
        if (isShutDown.get()) {
            throw new IllegalStateException("Thread pool is shut down. Cannot Accept new tasks");
        }
        taskScheduler.submit(task);
    }

    public void shutdown() {
        isShutDown.set(true);
        for(WorkerThread worker : workers) {
            worker.interrupt();
        }
    }

    private class WorkerThread extends Thread {
        WorkerThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!isShutDown.get() || !taskScheduler.isEmpty()) {
                try {
                    Runnable task = taskScheduler.take();
                    if (task != null) {
                        task.run();
                    }
                } catch (InterruptedException e) {
                    // Check if we should continue processing remaining tasks
                    if (isShutDown.get() && taskScheduler.isEmpty()) {
                        break;
                    }
                }
            }
        }
    }
}
