package com.company;

public class Main {

    public static void main(String[] args) {
	Bank account = new Bank();
	account.cash=100;
	Client c1=new Client(account,60);
	Client c2= new Client(account,-70);
	c1.start();
	c2.start();
    }
}
