import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorExample {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //gives you the total milliseconds from 1Jan 1970
        // Thread[] thread=new Thread[9];

        ExecutorService executor= Executors.newFixedThreadPool(9);
        for (int i=1;i<10;i++){
            int finalI = i;
            executor.submit(()->{
                        long result=fact(finalI);
                        System.out.println(result);
                    });
        }
        executor.shutdown();

        System.out.println("Total Time:"+(System.currentTimeMillis()-startTime));
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
