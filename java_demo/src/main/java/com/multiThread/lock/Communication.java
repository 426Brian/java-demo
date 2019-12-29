package com.multiThread.lock;


/**
 * 线程通信
 * 使用两个线程打印 1—100. 要求线程1. 2 交替打印
 * Created by Brian in 22:12 2018/11/20
 */
public class Communication {
    public static void main(String[] args) {
        Demo demo = new Demo();
        PrintNum printNum = new PrintNum(demo);


        Thread thread1 = new Thread(printNum);
        Thread thread2 = new Thread(printNum);

        thread1.setName("th1 --");
        thread2.setName("th2 ==");

        thread1.start();
        thread2.start();

    }
}

class Demo{
    int num = 1;
    public synchronized void test(){

        for (int i = num; num <= 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + num++);
        }
    }
}

class PrintNum implements Runnable {
    Demo demo;
    public PrintNum(Demo demo){
        this.demo = demo;
    }

    Object obj =new Object();
    @Override
    public void run() {
        demo.test();

    }
}