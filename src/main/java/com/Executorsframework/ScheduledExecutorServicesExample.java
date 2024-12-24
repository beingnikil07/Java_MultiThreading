package com.Executorsframework;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class ScheduledExecutorServicesExample {
    public static void main(String[] args) {
        // simple thread pool
        ScheduledExecutorService schedular= Executors.newScheduledThreadPool(1);

        ScheduledExecutorService executor=Executors.newCachedThreadPool();
















    /*
        Method 1:schedule()
        schedular.schedule(
                () -> System.out.println("Task executed after 5 seconds delay "),
                5,
                TimeUnit.SECONDS
        );
    */

//
//        //Method 2:scheduleAtFixedRate()
//        schedular.scheduleAtFixedRate(
//                ()-> System.out.println("Task executed after every 5 seconds !"),
//                5,
//                5,
//                TimeUnit.SECONDS
//        );
//        schedular.schedule(()->{
//            System.out.println("Initiating shutdown...");
//            schedular.shutdown();
//
//        },20,TimeUnit.SECONDS);

    }
}
