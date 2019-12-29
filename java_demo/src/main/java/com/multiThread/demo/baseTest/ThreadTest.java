package com.multiThread.demo.baseTest;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 20:06 2018/4/28
 */
public class ThreadTest {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThreadTest.class);

    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1");
        r1.start();

        RunnableDemo r2 = new RunnableDemo("Thread-2");
        r2.start();

        try {
            Thread.sleep(1000);
            r1.suspend();
            log.info("Suspending first thread");
            r1.resume();
            log.info("Resuming  first thread");

            r2.suspend();
            log.info("Suspending second thread");
            r2.resume();
            log.info("Resuming  second thread");

        } catch (InterruptedException e) {
            log.info("Main thread interrupted");
        }
        try {
            r1.thread.join();
            r2.thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("Main exiting");
      /*  ThreadDemo t1 = new ThreadDemo("Thread-3");
        t1.start();

        ThreadDemo t2 = new ThreadDemo("Thread-4");
        t2.start();*/
    }
}
