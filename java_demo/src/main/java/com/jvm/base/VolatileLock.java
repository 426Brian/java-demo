package com.jvm.base;

/**
 * Created by Brian in 4:00 2018/11/24
 */
public class VolatileLock {
    //    public static boolean flag = false;
    public static volatile boolean flag = false;

    public static void main(String[] args) {
        Th1 th_1 = new Th1();
        Th2 th_2 = new Th2();
        Thread th1 = new Thread(th_1);
        Thread th2 = new Thread(th_2);

        th1.start();
        th2.start();

        try {
            th1.join();
            th2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main stop");
    }

    static class Th1 implements Runnable {
        @Override
        public void run() {
            System.out.println("th1 start -->");
            try {
                Thread.currentThread().sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            flag = true;
        }
    }


    static class Th2 implements Runnable {
        @Override
        public void run() {
            System.out.println("th2 start ==>");
            while (!flag) {

            }
            System.out.println("th2 stop");
        }
    }
}
