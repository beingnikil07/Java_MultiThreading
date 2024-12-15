package com.nikhil;

public class Test {
    public static void main(String[] args) throws  InterruptedException{
        //creating the object of Counter
        //Here ,Same object counter dono thread share krr rhe hai,Aur ye dono thread simultaneously change krr rhe hai counter ko
        // Jisse hoga kya humko result unexpected milega ,Result shi mil bhi gya to surity nhi hai ,kabhi kuch milega kabhi kuch
        Counter counter=new Counter();
        MyThread t1=new MyThread(counter);
        MyThread t2=new MyThread(counter);

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        }catch (Exception e){

        }
        System.out.println(counter.getCount());
    }
}
