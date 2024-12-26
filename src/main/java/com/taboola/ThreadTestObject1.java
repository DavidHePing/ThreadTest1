package com.taboola;

public class ThreadTestObject1 {
    private int counter = 0;

    private final Object lock = new Object();

    public void increment() {
        synchronized (lock) {
            counter++;
        }
    }

    public int getCounter() {
        synchronized (lock) {
            return counter;
        }
    }

    public void incrementNoSync() {
        counter++;
    }

    public int getCounterNoSync() {
        return counter;
    }
}
