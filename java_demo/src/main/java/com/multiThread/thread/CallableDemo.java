package com.multiThread.thread;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by Brian in 16:40 2018/11/24
 */
public class CallableDemo implements Callable<String> {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(CallableDemo.class);

    private int ticket = 10;

    @Override
    public String call() throws Exception {

       while(true){
           if (ticket > 0){
               Thread.currentThread().sleep(100);
               log.info(Thread.currentThread().getName()+": "+ticket--);
           }else {
               break;
           }
       }
        return "b";
    }

    public static void main(String[] args) {

        CallableDemo callableDemo = new CallableDemo();
//        CallableDemo callableDemo2 = new CallableDemo();
        FutureTask<String> task = new FutureTask<>(callableDemo);
        FutureTask<String> task2 = new FutureTask<>(callableDemo);

        Thread th1 = new Thread(task, "th1--");
        Thread th2 =new Thread(task2, "th2--");
        th1.start();
        th2.start();


        try {
            th1.join();
            th2.join();

            log.info(task.get());
            log.info(task2.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }

}
