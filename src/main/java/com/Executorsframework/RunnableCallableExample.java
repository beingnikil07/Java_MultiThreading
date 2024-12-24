package com.Executorsframework;

import java.util.concurrent.*;

public class RunnableCallableExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newFixedThreadPool(2);
        Future<Integer> future=executor.submit(()->{
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                System.out.println("Exception Occurred:"+e);
            }
            return 42;
        });

        future.cancel(true);
        System.out.println(future.isCancelled());
        System.out.println(future.isDone());
        executor.isShutdown();
    }
}
