


/*
        Unfair Locks:
        1. Threads jis order mai request krr te hai jruri nhi wohi order mile unko.Unko order nhi milta jis order
        mai wo request karte hai shared resource ke liye

        2. When you create a ReentrantLock without specifying fairness, it defaults to an unfair lock.

    Performance Advantage: Unfair locks can perform better in high-contention situations because they
    reduce the overhead of maintaining a queue of waiting threads.

    Starvation Risk: Threads that are ready to acquire the lock immediately after release may keep "jumping ahead,"
    causing other threads to wait indefinitely.

 */

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnfairLockExample {
   //In Java, the default behavior of ReentrantLock is unfair, meaning it does not guarantee that
   // threads acquire the lock in the order they requested it.
    private final Lock lock = new ReentrantLock();

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            // Simulate work
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            lock.unlock();
            System.out.println(Thread.currentThread().getName() + " released the lock.");
        }
    }

    public static void main(String[] args) {
        UnfairLockExample example = new UnfairLockExample();

        Runnable task=new Runnable() {
            @Override
            public void run() {
                while (true){
                    example.accessResource();
                }
            }
        };

        Thread t1 = new Thread(task, "Thread-1");
        Thread t2 = new Thread(task, "Thread-2");

        // Start threads
        t1.start();
        t2.start();
    }
}
