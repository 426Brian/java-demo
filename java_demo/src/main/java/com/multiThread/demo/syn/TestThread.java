package com.multiThread.demo.syn;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 14:58 2018/4/29
 */

class PrintDemo {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(PrintDemo.class);

    public void printCount() {
        for (int i = 5; i > 0; i--) {
            log.info("Counter " + i);
        }
    }
}

class ThreadDemo extends Thread {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThreadDemo.class);

    private Thread thread;
    private String threadName;
    PrintDemo printDemo;

    ThreadDemo(String name, PrintDemo printDemo) {
        this.threadName = name;
        this.printDemo = printDemo;
    }

    public void run() {
        synchronized (printDemo) {
            log.info(threadName+" ");
            printDemo.printCount();
        }

        log.info("Thread " + threadName + " exiting");
    }

    public void start (){
        log.info("Starting "+threadName);

        if(thread == null){
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

}
public class TestThread {
    public static void main(String[] args) {
        PrintDemo printDemo = new PrintDemo();

        ThreadDemo t1 = new ThreadDemo("Thread-1", printDemo);
        ThreadDemo t2 = new ThreadDemo("Thread-2", printDemo);

        t1.start();
        t2.start();


        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
