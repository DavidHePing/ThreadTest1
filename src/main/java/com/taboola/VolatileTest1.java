package com.taboola;

public class VolatileTest1 {
    public static void testMethodSync(){
        VolatileTestObject1 example = new VolatileTestObject1();

        // Create threads as before
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.incrementNoSync();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.incrementNoSync();
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

        System.out.println("VolatileTest1 without sync, Final Counter Value: " + example.getCounterNoSync());
    }
}
