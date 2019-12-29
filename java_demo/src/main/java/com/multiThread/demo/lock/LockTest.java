package com.multiThread.demo.lock;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Brian in 22:15 2018/4/29
 */

class PrintDemo {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(PrintDemo.class);
    private final Lock queueLock = new ReentrantLock();

    public void print(){
        queueLock.lock();
        Long duration = (long)(Math.random()*10000);
        log.info(Thread.currentThread().getName()+" time taken "+(duration/1000)+" seconds");
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            log.info("printed from print "+Thread.currentThread().getName());
            queueLock.unlock();
        }
    }
}

class ThreadDemo extends Thread {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThreadDemo.class);
    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo printDemo){
        super(name);
        this.printDemo = printDemo;
    }

    @Override
    public void run() {
        log.info("printed "+Thread.currentThread().getName());
        printDemo.print();
    }
}
public class LockTest {

    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();
        ThreadDemo t1 = new ThreadDemo("t1", printDemo);
        ThreadDemo t2 = new ThreadDemo("t2", printDemo);
        ThreadDemo t3 = new ThreadDemo("t3", printDemo);
        ThreadDemo t4 = new ThreadDemo("t4", printDemo);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }

}
