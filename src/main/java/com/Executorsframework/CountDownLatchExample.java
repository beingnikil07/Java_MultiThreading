package com.Executorsframework;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        int numberOfServices=3;
        ExecutorService executorService =Executors.newFixedThreadPool(numberOfServices);

        //creating instance of latch
        CountDownLatch latch=new CountDownLatch(numberOfServices);
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));
        executorService.submit(new DependentService(latch));

        // Wait until all tasks have finished (latch count reaches zero)
        latch.await();

        System.out.println("Main thread ");
        // Shutdown the executor service to release resources
        executorService.shutdown();
    }

}

class  DependentService implements Callable<String> {
    private  final CountDownLatch latch;
  //// Constructor to initialize the latch
    public  DependentService(CountDownLatch latch){
        this.latch=latch;
    }

    @Override
    public String call() throws Exception{
        try {
            System.out.println(Thread.currentThread().getName() + "  service started");
            Thread.sleep(2000);
        }finally {
            // Decrease the latch count by 1 when the service completes
            latch.countDown();
        }
        return "Ok";
    }
}
