package com.multiThread.demo.lock;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by Brian in 22:33 2018/4/29
 */
public class ReadWriteLockTest {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ReadWriteLockTest.class);
    private static final ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);

    private static String msg = "a";

    public static void main(String[] args) throws InterruptedException{
        Thread t1 = new Thread(new WriterA(), "WriterA");

        Thread t2 = new Thread(new WriterB(), "WriterB");

        Thread t3 = new Thread(new Reader(), "Reader");

        t1.start();
        t2.start();
        t3.start();


    }

    static class Reader implements Runnable {
        @Override
        public void run() {
            if(lock.isWriteLocked()){
                log.info("Write lock present");
            }

            lock.readLock().lock();

            Long duration = (long)(Math.random()*10000);
            log.info(Thread.currentThread().getName()+" time taken "+(duration/1000)+" seconds");

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                log.info(Thread.currentThread().getName()+" "+msg);
                lock.readLock().unlock();
            }
        }
    }

    static class WriterA implements Runnable {
        @Override
        public void run() {
            lock.writeLock().lock();

            Long duration = (long)(Math.random()*10000);
            log.info(Thread.currentThread().getName()+" time taken "+(duration/1000)+" seconds");

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                msg = msg.concat("a");
                lock.writeLock().unlock();
            }
        }
    }

    static class WriterB implements Runnable {
        @Override
        public void run() {
            lock.writeLock().lock();

            Long duration = (long)(Math.random()*10000);
            log.info(Thread.currentThread().getName()+" time taken "+(duration/1000)+" seconds");

            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                msg = msg.concat("b");
                lock.writeLock().unlock();
            }
        }
    }
}
