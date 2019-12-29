package com.multiThread.thread;

import com.designPattern.old.filter.Person;

/**
 * Created by Brian in 21:39 2018/11/24
 */
public class Demo2 implements Runnable{

    @Override
    public void run() {
        Person person = new Person();
        System.out.println(Thread.currentThread().getName()+" person hashcode: "+person.hashCode());
    }

    public static void main(String[] args) {
        Demo2 demo2 = new Demo2();
        new Thread(demo2, "th1").start();
        new Thread(demo2, "th2").start();
        new Thread(demo2, "th3").start();
        new Thread(demo2, "th4").start();
    }
}
