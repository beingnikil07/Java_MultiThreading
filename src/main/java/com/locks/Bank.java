package com.locks;

public class Bank {
    public  static int balance=1000;

    /*
        synchronized keyword lga krr hum ensure krr rhe h kii at a time one thread he access kre shared data(critical section)
        but suppose t1 thread krr rhi hai access ,aur ye method 10second wait krr rha hai to itni dusri thread nhi jaayegi
        access karne jabki resources free hai ,Example in below code 5second tkk sleep h ,to itne mai hum thread t2 to access
        karwa sakte h resource to ye possible hoga Locks ke through .Lock abhi bhi hai but ye automatic lock(Intrinsic) hai
        jo hota h java ke har object mai ,abhi synchonized use kiya to isme yehi automatic lock hota h,
        To More advanced controls over resources we will use external locks (Explicit lock)


     */

    public  synchronized  void withdraw(int amount){
        System.out.println(Thread.currentThread().getName()+" attempting to withdrow "+amount);
        if(balance>=amount){

            System.out.println(Thread.currentThread().getName()+" proceeding with withdrawal");
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){

            }
            balance -=amount;
            System.out.println(Thread.currentThread().getName()+" completed withdrawal. Remaining balance:"+balance);
        }
        else {
            System.out.println(Thread.currentThread().getName()+" Insufficient balance");
        }
    }

}
