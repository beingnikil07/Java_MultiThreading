/*
       Fair Locks:
       1. Threads acquire the lock in the order they requested it, promoting fairness but potentially reducing throughput
          due to the overhead of maintaining the queue.

        Key Characteristics of a Fair Lock:

        1. Thread Order: Threads are granted the lock in the order they requested it.
        2. Starvation Prevention: Threads waiting for a long time are eventually guaranteed access to the lock.
        3. Performance Trade-off: Fair locks can have lower performance compared to unfair locks because maintaining
            the request queue incurs overhead.

        #Advantages:

        1. Good for Critical Applications: Useful when fairness is critical, such as in financial systems or resource allocation.
        2. Starvation-Free: No thread is indefinitely delayed, ensuring fairness in access.

        #Disadvantages:

        1. Use fair locks when fairness is more important than performance.
 */
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairLockExample {
    // please pass true for fair lock
    private final Lock lock = new ReentrantLock(true);

    public void accessResource() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + " acquired the lock.");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            System.out.println(Thread.currentThread().getName() + " released the lock.");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        FairLockExample example = new FairLockExample();

        Runnable task = new Runnable() {
            @Override
            public void run() {
                example.accessResource();
            }
        };

        Thread thread1 = new Thread(task, "Thread 1");
        Thread thread2 = new Thread(task, "Thread 2");
        Thread thread3 = new Thread(task, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
