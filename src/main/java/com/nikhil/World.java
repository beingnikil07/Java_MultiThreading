package com.nikhil;

public class World implements Runnable{
    /*
    To create a new thread we have to extends the Thread class or Runnable Interface
    To create a new thread we have to override the run() method of Thread class
     */
    @Override
    public void run(){
        for(; ;){
            System.out.println("World");
        }
    }
}
