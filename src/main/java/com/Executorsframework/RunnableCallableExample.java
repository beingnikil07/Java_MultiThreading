package com.Executorsframework;

import java.util.concurrent.*;

public class RunnableCallableExample
{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor= Executors.newSingleThreadExecutor();
        Callable<?> callable=()-> "Hello Nikhil";
        Future<?> future=executor.submit(callable);
        System.out.println(future.get());
        executor.shutdown();
    }
}
