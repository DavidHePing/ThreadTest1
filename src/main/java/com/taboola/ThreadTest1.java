package com.taboola;

public class ThreadTest1 {


    public static void testMethodSync(){
        ThreadTestObject1 example = new ThreadTestObject1();

        // Create threads as before
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                example.increment();
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

        System.out.println("ThreadTest1 with sync, Final Counter Value: " + example.getCounter());
    }

    public static void testMethodNoSync(){
        ThreadTestObject1 example = new ThreadTestObject1();

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

        System.out.println("ThreadTest1 without sync, Final Counter Value: " + example.getCounterNoSync());
    }
}
