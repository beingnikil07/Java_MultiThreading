package com.nikhil;

public class MyThread  extends Thread{

    @Override
    public void run() {
        for (int i=1;i<=5;i++){
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        MyThread t1=new MyThread();
        t1.start();
    }
}
