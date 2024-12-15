package com.nikhil;

public class MyThread  extends Thread{

    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
       for(int i=0;i<5;i++){
           System.out.println(Thread.currentThread().getName() +" is running");

           //It gives the hint to JVM ,you can give chance to another thread to execute,mean koi jaldi na hai tum kisi or ko bhi chace de sakte ho
           Thread.yield();
       }
    }
    public static void main(String[] args)  throws InterruptedException{
        MyThread t1=new MyThread("t1");
        MyThread t2=new MyThread("t2");
        t1.start();
        t2.start();

    }
}
