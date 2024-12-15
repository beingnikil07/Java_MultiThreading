package com.nikhil;

public class MyThread  extends Thread{

    @Override
    public void run() {
            try {
                //pause for 5second
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }

    public static void main(String[] args) throws InterruptedException {
        MyThread t1=new MyThread();
        t1.start();
        //waits for the termination of thread
        t1.join();
        //After 5 seconds below stmt will execute
        System.out.println("Hello Nikhil Kumar Rana");
    }
}
