package com.base;

/**
 * Created by Brian in 18:28 2018/11/24
 */
public class Demo {
    public static void main(String[] args) {
        MyThread th = new MyThread("th0");
        MyThread th1 = new MyThread("th1");
        MyThread th2 = new MyThread("th2");
        MyThread th3 = new MyThread("th3");
        MyThread th4 = new MyThread("th4");

        th.start();
        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}

class MyThread extends Thread{
    private String name;

    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                Thread.currentThread().sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
