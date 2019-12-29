package com.multiThread.thread;


/**
 * Created by Brian in 2:53 2018/11/20
 */
public class RunnableDemo {
    public static void main(String[] args) {


        Windows win = new Windows();
        Thread th1 = new Thread(win);
        Thread th2 = new Thread(win);
        Thread th3 = new Thread(win);

        th1.setName("th1 --");
        th2.setName("th2 ==");
        th3.setName("th3 >>");

        th1.start();
        th2.start();
        th3.start();
    }

}


class Windows implements Runnable {
    int ticket = 200;
    Object obj = new Object();

    @Override
    public void run() {
        while (true) {
            // 用show() 是同步方法的方式
            show();
            /* 同步代码快的方式
            synchronized (obj) {
                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket--);
                }
            }*/

        }
    }

    public synchronized void show() {
        if (ticket > 0) {
            try {
                Thread.currentThread().sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " " + ticket--);
        }
    }
}