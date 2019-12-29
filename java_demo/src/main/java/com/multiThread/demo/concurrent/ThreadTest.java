package com.multiThread.demo.concurrent;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Brian in 12:09 2018/4/30
 */
public class ThreadTest {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThreadTest.class);

    static class Counter {
        private AtomicLong c = new AtomicLong(0);

        public void increacement() {
            c.getAndIncrement();
        }

        public long value (){
            return c.get();
        }
    }

    public static void main(String[] args) {
        final Counter counter = new Counter();
        for (int i = 0; i < 100; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    counter.increacement();
                }
            }).start();

        }

        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("final number "+counter.value());
    }
}
