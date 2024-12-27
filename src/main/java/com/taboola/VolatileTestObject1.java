package com.taboola;

public class VolatileTestObject1 {
    private volatile int counter = 0;

    private final Object lock = new Object();

    public void incrementNoSync() {
        counter++;
    }

    public int getCounterNoSync() {
        return counter;
    }
}
