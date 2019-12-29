package com.multiThread.demo.baseTest;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 19:58 2018/4/28
 */
class RunnableDemo implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(RunnableDemo.class);

    private String threadName;
    Thread thread;
    private boolean suspended;

    public RunnableDemo(String threadName) {
        this.threadName = threadName;
        log.info("Creating " + threadName);
    }

    public void start() {
        log.info("Start " + threadName);
        if (thread == null) {
            thread = new Thread(this, threadName);
            thread.start();
        }
    }

    @Override
    public void run() {
        log.info("Running " + threadName);
        for (int i = 10; i > 0; i--) {
            log.info("Running " + threadName + ", " + i);
            try {
                Thread.sleep(300);
                synchronized (this) {
                    while (suspended) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
                log.info(threadName + " interrupted");
            }
        }

        log.info(threadName + " exiting");
    }

    void suspend() {
        suspended = true;
    }

    synchronized void resume() {
        suspended = false;
        notify();
    }
}
