package com.taboola;

public class VolatileTest2 {
    public static void testMethodSync(){
        VolatileTestObject2 example = new VolatileTestObject2();

        // Create threads as before
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.changeFlag();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.changeFlag();
            }
        });

        t1.start();
        t2.start();

        // Wait for threads to finish
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("VolatileTest2 , Flag Value: " + example.getFlag());
    }
}
