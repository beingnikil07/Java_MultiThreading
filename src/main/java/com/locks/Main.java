package com.locks;

public class Main {
    public static void main(String[] args) {
        Bank sbi=new Bank();

        //Runnable is an interface you can't create the object of it,You can implement it ,we are implementing it using inner class
        Runnable task=new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(100);
            }
        };

         // Thread Class: This is used to create and manage threads in Java.
        //  Constructor Parameters:
        //  First Parameter (task): A Runnable object (task) that contains the code to be executed.
        //  Second Parameter ("Thread 1" and "Thread 2"): The name of the thread, useful for debugging or logging.

        Thread t1=new Thread(task,"Thread 1");
        Thread t2=new Thread(task,"Thread 2");
        t1.start();
        t2.start();
    }
}
