package com.strings;

/**
 * Created by Brian in 20:22 2018/3/6
 */
public class Count extends Thread{
    private int num;
    public void count() {
        for(int i = 1; i <= 10; i++) {
            num += i;
        }
        System.out.println(Thread.currentThread().getName() + "-" + num);
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            Count count = new Count();
            public void run() {
                count.count();
            }
        };

        for(int i = 0; i < 10; i++) {
            new Thread(runnable).start();
        }
    }


}
