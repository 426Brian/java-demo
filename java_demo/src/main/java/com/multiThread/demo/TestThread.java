package com.multiThread.demo;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 22:18 2018/4/28
 */

class Chat {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(Chat.class);

    boolean flag;

    public synchronized void question(String msg){
        if(flag){
        }
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info(msg);
        flag = true;
        notify();
    }

    public synchronized void answer(String msg){
        if(!flag){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        log.info(msg);
        flag = false;
        notify();
    }

    /**
     * Created by Brian in 22:18 2018/4/28
     */

}

class T1 implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(T1.class);
    Chat chat;
    String[] s1 = {"Hi", "How are you ?", "I am also fine"};


    public T1(Chat chat) {
        this.chat = chat;
        new Thread(this, "question").start();
    }


    @Override
    public void run() {
        for (int i = 0; i < s1.length; i++) {
            chat.question(s1[i]);
        }
    }

}

class T2 implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(T2.class);
    Chat chat;
    String[] s2 = {"Hi", "I am good, hou about you ?", "Great"};


    public T2(Chat chat) {
        this.chat = chat;
        new Thread(this, "answer").start();
    }



    @Override
    public void run() {
        for (int i = 0; i < s2.length; i++) {
            chat.answer(s2[i]);
        }
    }

}


public class TestThread {
    public static void main(String[] args) {
        Chat chat = new Chat();
        new T1(chat);
        new T2(chat);
    }
}