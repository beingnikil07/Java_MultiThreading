package com.locks;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Bank {
    public  static int balance=1000;

    //Lock: This is an interface that provides explicit locking mechanisms.
    // The lock object will implement the methods defined in the Lock interface, such as lock(), unlock(), and tryLock().
    // ReentrantLock: This is a concrete implementation of the Lock interface.
    //A reentrant lock allows the same thread to acquire the lock multiple times without causing a deadlock.
    private final Lock lock=new ReentrantLock();


    // lock.tryLock(1000,TimeUnit.method): It is used to attempt to acquire a lock without waiting indefinitely.
    // It returns true if the lock was successfully acquired, and false if the lock is already held by another thread.
    //Itne time mai hai resource free to lelo warna block kro thread ko



    public  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdraw "+amount);
        try{
            if(lock.tryLock(1000, TimeUnit.MILLISECONDS)) {
                if (balance >= amount) {
                    try {
                        System.out.println(Thread.currentThread().getName() + " proceeding with withdrawal");
                        Thread.sleep(3000);  //simulate time taken to process the withdrawal
                        balance -= amount;
                        System.out.println(Thread.currentThread().getName() + " completed withdrawal. Remaining balance:" + balance);
                    } catch (Exception e) {

                    } finally {
                        lock.unlock();
                    }
                } else {
                    System.out.println(Thread.currentThread().getName() + " Insufficient balance");
                }
            }else {
                System.out.println(Thread.currentThread().getName()+" could not acquire  the lock ,will try later");
        }
        }catch (Exception e){

        }
    }





















    /*
        synchronized keyword lga krr hum ensure krr rhe h kii at a time one thread he access kre shared data(critical section)
        but suppose t1 thread krr rhi hai access ,aur ye method 10second wait krr rha hai to itni dusri thread nhi jaayegi
        access karne jabki resources free hai ,Example in below code 5second tkk sleep h ,to itne mai hum thread t2 to access
        karwa sakte h resource to ye possible hoga Locks ke through .Lock abhi bhi hai but ye automatic lock(Intrinsic) hai
        jo hota h java ke har object mai ,abhi synchonized use kiya to isme yehi automatic lock hota h,
        To More advanced controls over resources we will use external locks (Explicit lock)



    public  synchronized  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdrow "+amount);
        if(balance>=amount){
            System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){

            }
            balance -=amount;
            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance:"+balance);
        }
        else {
            System.out.println(Thread.currentThread().getName()+" Insufficient balance");
        }
    }

     */
}
