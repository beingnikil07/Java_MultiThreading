package com.nikhil;

public class Main {
    public static void main(String[] args){
        System.out.println("Hello, World!");
        //By default,Main method runs under the Main Thread.Main thread is responsible for executing the main method of a program.
        System.out.println(Thread.currentThread().getName());


    }
}