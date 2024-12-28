package com.taboola;

public class VolatileTestObject2 {
    private volatile boolean flag = true;

    private final Object lock = new Object();

    public void changeFlag() {
        flag = !flag;
    }

    public boolean getFlag() {
        return flag;
    }
}
