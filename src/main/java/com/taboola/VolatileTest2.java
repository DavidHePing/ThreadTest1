package com.taboola;

public class VolatileTest2 {
    public static void testMethodSync(){
        VolatileTestObject2 example = new VolatileTestObject2();

        example.startTask();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        example.stopTask();
    }
}
