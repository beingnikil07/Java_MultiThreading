package com.Executorsframework;

import java.util.concurrent.*;

public class RunnableCallableExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(2);
        Future<Integer> submit=executor.submit(()->2+2);
        Integer i=submit.get();
        System.out.println("Sum is :"+i);
        executor.shutdown();
        System.out.println(executor.isShutdown());
        System.out.println(executor.isTerminated());
    }
}
