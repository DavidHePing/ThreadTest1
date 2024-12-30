package com.taboola;

public class VolatileTestObject2 {
    private volatile boolean isRunning = true;

    public void startTask() {
        new Thread(() -> {
            while (isRunning) {
                System.out.println("Task is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            System.out.println("Task stopped.");
        }).start();
    }

    public void stopTask() {
        isRunning = false;
    }
}
