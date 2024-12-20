/*
        Q:Why we called it as Reentrant lock ?
 */
package com.locks;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class ReentrantExample {
    private final Lock lock=new ReentrantLock();
    /*
    Reentrant lock hum jbb use karte hai to ek count maintain kiya jaata hai ,Jo rakhta hai detail lock kitni baar
    lagaya gya ya acquire kiya gya  .Jbb tkk count lock ka zero na ho jaata koi aur thread access nii krr sakta

     */

    public  void outerMethod(){
        lock.lock();   // count of lock=1
        try{
            System.out.println("Outer Method");
            innerMethod();
        }finally{
            lock.unlock();    //count =1-1=0
        }
    }

    public void innerMethod(){
        lock.lock();         //count of lock=2
        try {
            System.out.println("Inner Method");
        }finally {
                lock.unlock();     // count =2-1=1
        }
    }

    public static void main(String[] args) {
        ReentrantExample obj=new ReentrantExample();
        obj.outerMethod();
    }

}
