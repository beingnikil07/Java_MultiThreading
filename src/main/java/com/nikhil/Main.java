package com.nikhil;

public class Main {
    public static void main(String[] args){

        //Our created thread
        World obj=new World();
        Thread t1=new Thread(obj);
        t1.start();

        //Main thrad
        for (; ;){
            System.out.println("Hello");
        }

    }
}