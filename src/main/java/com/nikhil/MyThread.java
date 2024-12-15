package com.nikhil;

public class MyThread  extends Thread{
    //constructor to set the manual name of a thread
    public MyThread(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            String a = "";
            for (int j = 0; j < 100000; j++) {
                a = a + "a";
            }
            System.out.println(Thread.currentThread().getName() + " -Priority: " + Thread.currentThread().getPriority() + "  -count:" + i);
            try {
                Thread.sleep(10);
            } catch (Exception e) {

            }
        }
    }
    public static void main(String[] args)  throws InterruptedException{
        MyThread l=new MyThread("Low Priority thread");   //setting the name of the thread by passing the name to the constructor MyThread()
        MyThread m=new MyThread("medium priority thread");
        MyThread h=new MyThread("High priority thread");
        l.setPriority(Thread.MIN_PRIORITY);
        m.setPriority(Thread.NORM_PRIORITY);
        h.setPriority(Thread.MAX_PRIORITY);

        l.start();
        m.start();
        h.start();

    }
}
