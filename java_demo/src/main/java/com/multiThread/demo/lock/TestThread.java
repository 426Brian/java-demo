package com.multiThread.demo.lock;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 20:14 2018/4/29
 */
public class TestThread {
    public static Object lock1 = new Object();
    public static Object lock2 = new Object();

    private static class ThredDemo1 extends Thread {
        private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThredDemo1.class);

        @Override
        public void run() {
            synchronized (lock1) {
                log.info("Thread 1: Holding lock 1");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Thread 1: waiting for lock2");

                synchronized (lock2) {
                    log.info("Thread 1: Holding lock1 & lock2");
                }
            }
        }
    }

    private static class ThredDemo2 extends Thread {
        private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThredDemo2.class);

        @Override
        public void run() {
            // 若是先同步lock2 会同步死锁
            synchronized (lock1) {

                log.info("Thread 2: Holding lock2");

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("Thread 2: waiting for lock1");

                synchronized (lock2) {
                    log.info("Thread 2: Holding lock1 & lock2");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThredDemo1 t1 = new ThredDemo1();
        ThredDemo2 t2 = new ThredDemo2();

        t1.start();
        t2.start();
    }

}
