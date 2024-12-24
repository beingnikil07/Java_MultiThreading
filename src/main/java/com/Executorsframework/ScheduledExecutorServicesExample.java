package com.Executorsframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutorServicesExample {
    public static void main(String[] args) {
        ScheduledExecutorService schedular= Executors.newScheduledThreadPool(1);
        schedular.schedule(
                () -> System.out.println("Task executed after 5 seconds delay "),
                5,
                TimeUnit.SECONDS
        );

    }
}
