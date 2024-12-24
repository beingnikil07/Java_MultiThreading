package com.Executorsframework;

public class Main {


     //Sabse pehle Time print hoga total,Because you are not waiting for any thread ,To thread to chalegi parallel mai
    // but control chala jaayega aage wait nii karega,if you want that first thread completely executed then after the time
    // will show ,please wait for thread termination using thread.join() method.
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //gives you the total milliseconds from 1Jan 1970
        //Array of threads
        Thread[] thread=new Thread[9];
        for (int i=1;i<10;i++){
            int finalI = i;
            //Becz we know i=1,but we know array starts from index 0
              thread[i-1]=new Thread(
                    ()->{
                        long result=fact(finalI);
                        System.out.println(result);
                    }
            );
        thread[i-1].start();
        }

        //wait for the termination of all threads
        for(Thread t1:thread){
            try {
                t1.join();
            }catch(InterruptedException e){
                throw new RuntimeException(e);
            }
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
