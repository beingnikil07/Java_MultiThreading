package com.nikhil;

class MyThread extends Thread{

    @Override
    public  void run(){
        System.out.println("RUNNING");
        try{
            Thread.sleep(2000);
        }catch (InterruptedException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws  InterruptedException{
        MyThread t1=new MyThread();  //NEW STATE
        System.out.println(t1.getState());

        t1.start();    //Runnable state:waiting to be executed
        System.out.println(t1.getState());

        Thread.sleep(1000);   //Used to pause/sleep the main thead(Main method) so that our run method can executed or other thread can executed ,Actually ye sbb main thread mai he to run krr rhe hai ye sabhi thread
        System.out.println(t1.getState());

        //join() method waits for thread to die , it will execute after the thread die.
        t1.join();
        System.out.println(t1.getState());

    }
}
