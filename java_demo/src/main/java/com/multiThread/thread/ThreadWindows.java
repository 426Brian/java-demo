package com.multiThread.thread;

/**
 * Created by Brian in 1:35 2018/11/21
 */
public class ThreadWindows {
    public static void main(String[] args) {
        Windows2 win = new Windows2();
        Windows2 win2 = new Windows2();
        Windows2 win3 = new Windows2();

        win.setName("th1 --");
        win2.setName("th2 ==");
        win3.setName("th3 -->");

        win.start();
        win2.start();
        win3.start();
    }

}

    class Windows2 extends Thread {
        static int ticket = 100;
        static volatile Object obj = new Object();
    @Override
    public void run() {

        while (true) {
            synchronized (obj) {

                if (ticket > 0) {
                    try {
                        Thread.currentThread().sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " " + ticket--);
                }
            }

        }
    }


}