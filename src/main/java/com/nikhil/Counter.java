package com.nikhil;

public class Counter {

    private int count=0;

    //synchronized keyword :Jbb ek thread chala rha ho iss method ko dusra nii chalayega,Jbb ek he object share krr
    //rhe ho multiple threads ,ya ek object he two or more than two thread changes krr rhe ho ,To aaise mai hum iska use
    //karte hai ,TO provide the synchronization kii at a time ek he use kre
    public  synchronized  void increment(){
        count++;
    }
    public int getCount(){
        return  count;
    }

}