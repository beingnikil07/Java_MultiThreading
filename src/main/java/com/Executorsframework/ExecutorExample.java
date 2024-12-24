import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
//    public static void main(String[] args) {
//        long startTime=System.currentTimeMillis();   //gives you the total milliseconds from 1Jan 1970
//        // Thread[] thread=new Thread[9];
//
//        // A thread pool with a maximum of 9 threads is created using Executors.newFixedThreadPool(9).
//        // This means up to 9 tasks can run concurrently.
//        // Executors in Java are utility classes that provide factory methods to create and manage thread pools or execute asynchronous tasks
//        ExecutorService executor= Executors.newFixedThreadPool(9);
//        for (int i=1;i<10;i++){
//            int finalI = i;
//           // executor.submit(...) submits a task (a Runnable implemented as a lambda) to the thread pool for execution.
//            executor.submit(()->{
//                        long result=fact(finalI);
//                        System.out.println(result);
//                    });
//        }
//        // executor.shutdown();
//        try{
//            executor.awaitTermination(1, TimeUnit.SECONDS);
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
//        System.out.println("Total Time:"+(System.currentTimeMillis()-startTime));
//    }


        public static void main(String[] args) {
            ExecutorService executor= Executors.newFixedThreadPool(9);
            for (int i=1;i<10;i++){
                int finalI = i;
                Future<?> future=executor.submit(()->{
                    long result=fact(finalI);
                    System.out.println(result);
                });
            }
            executor.shutdown();
        }

     private static long fact(int n){
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }
}
