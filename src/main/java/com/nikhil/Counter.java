package com.nikhil;

public class Counter {

    private int count=0;

    //synchronized keyword :Jbb ek thread chala rha ho iss method ko dusra nii chalayega,Jbb ek he object share krr
    //rhe ho multiple threads ,ya ek object he two or more than two thread changes krr rhe ho ,To aaise mai hum iska use
    //karte hai ,TO provide the synchronization kii at a time ek he use kre


    //critical section of the program:

    /*
          Qn:What is race condition in java multithreading
          whenever two threads want to access the same shared resource or critical section,This leads to race condition or
          we can say that ,This situation is called race condition .
          To avoid race condition you should properly synchronized the shared resource so that at a time only one thread can
          access the critical section or shared resource.
     */
    public synchronized void increment(){
            count++;
    }

    public int getCount(){
        return  count;
    }

}
