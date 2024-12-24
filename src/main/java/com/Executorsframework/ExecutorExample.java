import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorExample {
        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ExecutorService executor= Executors.newSingleThreadExecutor();
            /*
            The Future<?> interface in Java represents the result of an asynchronous computation.
            It provides a mechanism to retrieve the result of a task submitted to an ExecutorService once it has been completed.
             */

            Future<?> future=executor.submit(()->20);
            System.out.println(future.get());
            executor.shutdown();

        }
}
