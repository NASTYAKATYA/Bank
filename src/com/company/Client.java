package com.company;

public class Client extends Thread{
    public double delta;
    Bank a=new Bank();
   public static Object o= new Object();
    Client (Bank acc, double del){
        this.delta=del;
        this.a=acc;
    }

    @Override
    public void run() {
        synchronized (o){
            while(true){
                if(a.cash+delta>0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                a.cash+=delta;
                System.out.println(a.cash+(delta>0?"+":"-"));
            }
                else{
                    System.out.println("enough cash");}
                o.notify();
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
