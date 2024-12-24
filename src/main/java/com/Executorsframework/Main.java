package com.Executorsframework;

public class Main {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //gives you the total milliseconds from 1Jan 1970

        for (int i=1;i<=10;i++){
            System.out.println(fact(i));
        }

        System.out.println("Total Time:"+(System.currentTimeMillis()-startTime));
    }

    //We are assuming that calculating the factorial is a big task and takes a lot of time ,That's why we are increasing
    // the executing time by sleeping the thread
    private static long fact(int n){
       try {
           Thread.sleep(1000);
       }catch (InterruptedException e){
            throw new RuntimeException(e);
       }
        int fact=1;
        for(int i=1;i<=n;i++){
            fact=fact*i;
        }
        return fact;
    }

}
