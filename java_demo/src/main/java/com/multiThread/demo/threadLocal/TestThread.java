package com.multiThread.demo.threadLocal;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 21:35 2018/4/29
 */
class RunnableDemo implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(RunnableDemo.class);

    int counter;
    ThreadLocal<Integer> threadLocalCounter = new ThreadLocal<>();

    @Override
    public void run() {
        counter++;
        if (threadLocalCounter.get() != null) {
            threadLocalCounter.set(threadLocalCounter.get().intValue() + 1);
        } else {
            threadLocalCounter.set(0);
        }

        log.info(Thread.currentThread().getName()+" "+"Counter " + counter);
        log.info(Thread.currentThread().getName()+" "+"threadLocalCounter " + threadLocalCounter.get());
    }
}

public class TestThread {
    public static void main(String[] args) throws InterruptedException{
        RunnableDemo comInstance = new RunnableDemo();

        Thread t1 = new Thread(comInstance, "t1");
        Thread t2 = new Thread(comInstance, "t2");
        Thread t3 = new Thread(comInstance, "t3");
        Thread t4 = new Thread(comInstance, "t4");

        t1.start();
        t2.start();
        t3.start();
        t4.start();

        t1.join();
        t2.join();
        t3.join();
        t4.join();
    }
}
