package com.multiThread.thread;

/**
 * Created by Brian in 22:19 2018/11/21
 */
public class PrintNum implements Runnable {
    int num = 1;

    @Override
    public void run() {
        while (true) {
            synchronized (this){
                notify();
                if (num <=100){
                    System.out.println(Thread.currentThread().getName()+" --> "+num);
                    num++;
                }else{
                    break;
                }

                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        PrintNum printNum = new PrintNum();

        new Thread(printNum, "th1 --").start();
        new Thread(printNum, "th2 ==").start();
    }
}
