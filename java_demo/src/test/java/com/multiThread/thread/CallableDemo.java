package com.multiThread.thread;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;
import org.junit.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by Brian in 16:40 2018/11/24
 */
public class CallableDemo implements Callable<String> {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(com.exclude.multiThread.thread.CallableDemo.class);

    private int ticket = 10;

    @Override
    public String call() throws Exception {

       while(true){
           if (ticket > 0){
               log.info(Thread.currentThread().getName()+": "+ticket--);
           }else {
               break;
           }
       }
        return "b";
    }

    @Test
    public void test1(){
        log.info("start");
        com.exclude.multiThread.thread.CallableDemo callableDemo = new com.exclude.multiThread.thread.CallableDemo();
        FutureTask<String> task = new FutureTask<>(callableDemo);
        FutureTask<String> task2 = new FutureTask<>(callableDemo);

        new Thread(task, "th1--").start();
        new Thread(task2, "th2--").start();

    }
}
