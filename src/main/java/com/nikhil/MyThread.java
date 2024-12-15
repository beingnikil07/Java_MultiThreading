package com.nikhil;

public class MyThread  extends Thread{
    public MyThread(String name){
        super(name);
    }
    @Override
    public void run() {
        while (true){
            System.out.println("Hello Nikhil");
       }
    }
    public static void main(String[] args){
    //user defined thread
    MyThread t1=new MyThread("t1");
    t1.setDaemon(true);
    t1.start();
    System.out.println("Main done");
    }
}
