package com.multiThread.thread;


/**
 * Created by Brian in 21:35 2018/11/20
 */
public class Test {
    public static void main(String[] args) {
        Account account = new Account();
        Customer customer = new Customer(account);
        Customer customer2 = new Customer(account);

        customer.setName("customer1 --");
        customer2.setName("customer2 ==");

        customer.start();
        customer2.start();
    }
}

class Account {
    double balance;

    public synchronized void deposit(double atm) {
        notify();
        balance += atm;
        System.out.println(Thread.currentThread().getName()+": "+balance);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Customer extends Thread{
    Account account;

    public Customer(Account account){
        this.account = account;
    }


    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            account.deposit(1000d);
        }
    }
}