package com.nikhil;

public class MyThread  extends Thread{


    @Override
    public void run() {
        try{
            Thread.sleep(100);
            System.out.println("Thread is running ");
        } catch(InterruptedException e) {
            System.out.println("Thread Interrupted:"+e);
        }
    }
    public static void main(String[] args)  throws InterruptedException{
        MyThread t1=new MyThread();
        t1.start();
        //interrupt() method ka matlab hai aap jo bhi krr rhe ho like sleep ,wait start ,sabko interrupt kardo band kardo sabko
        t1.interrupt();

    }
}
