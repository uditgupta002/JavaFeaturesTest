package com.javaversions.v23;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class VirtualThreads {

    public static void main(String[] args) throws InterruptedException {
        boolean status;
        try (ExecutorService virtualThreadService = Executors.newVirtualThreadPerTaskExecutor()) {
            for (int i = 0; i < 1_000_000; i++) {
                int finalI = i;
                virtualThreadService.submit(() -> {
                    // Get a random number
                    if(finalI %100000 == 0)
                        System.out.println("Thread number : " + finalI + " finished");

                });
                if (i % 100000 == 0)
                    System.out.printf("Submitted %d threads%n", i);
            }
            System.out.println("Threads Submitted");
            virtualThreadService.shutdown();
            status = virtualThreadService.awaitTermination(50, TimeUnit.SECONDS);
        }
        System.out.println("Program Complete with status: " + status);
    }
}
