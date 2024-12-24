package com.Executorsframework;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class RunnableCallableExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newSingleThreadExecutor();

        /*
        The Runnable interface in Java is a functional interface provided by the java.lang package.
        It is used to define a task that can be executed by a thread. The interface has a single abstract method:

         */

        Runnable runnable=()-> "Hello";
//        Future<?> future=executor.submit(()-> "Hello");   //This line works
        Future<?> future=executor.submit(runnable); //not works ,show error
        System.out.println(future.get());
        executor.shutdown();
    }



}
