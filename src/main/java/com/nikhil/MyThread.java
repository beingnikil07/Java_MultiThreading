package com.nikhil;

public class MyThread  extends Thread{

    //constructor to set the manual name of a thread
    public MyThread(String name){
        super(name);
    }

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
        MyThread t1=new MyThread("nik");   //setting the name of the thread by passing the name to the constructor MyThread()
        t1.start();
        System.out.println(t1.getName());
    }
}
