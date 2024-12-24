package com.Executorsframework;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Test {

    public static void main(String[] args)  throws  InterruptedException{
        ExecutorService executorService= Executors.newFixedThreadPool(2);
        Callable<Integer> callable1=()->{
            System.out.println("Task 1");
            return  1;
        };
        Callable<Integer> callable2=()->{
            System.out.println("Task 2");
            return 2;
        };
        Callable<Integer> callable3=()->{
            System.out.println("Task 3");
            return 3;
        };

        List<Callable<Integer>> list= Arrays.asList(callable1,callable2,callable3);
        // The invokeAll() method in the Java ExecutorService interface is used to execute a collection of Callable tasks concurrently and wait for all of them to complete.
        // It returns a list of Future objects that represent the results of the tasks.
        List<Future<Integer>>  futures=executorService.invokeAll(list);

        executorService.shutdown();

      }
}
