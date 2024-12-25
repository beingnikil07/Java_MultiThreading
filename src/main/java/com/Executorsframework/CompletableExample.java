package com.Executorsframework;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // CompletableFuture.supplyAsync(Supplier): Executes a task asynchronously and returns a result.
        CompletableFuture<String> completableFuture=CompletableFuture.supplyAsync(()->{
            try {
                Thread.sleep(5000);
                System.out.println("Worker");
            }catch (Exception e){

            }
            return  "ok";
        });

        String s=completableFuture.get();
        System.out.println(s);
        System.out.println("Main");
    }
}
