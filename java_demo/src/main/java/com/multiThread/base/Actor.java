package com.multiThread.base;

/**
 * Created by Brian in 21:16 2018/1/29
 */
public class Actor extends Thread {

    @Override
    public void run() {
        System.out.println(getName()+" 是一个演员");
        int count = 0;

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println(getName()+" 登台演出 "+(++count));
            if(count == 100){
                keepRunning = false;
            }

            if(count % 10 == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(getName()+" 演出结束");
    }

    public static void main(String[] args){
        Thread actor = new Actor();
        actor.setName("Mr.Thread");
        actor.start();

        Thread actress = new Thread(new Actress(), "Ms.Runnable");
        actress.start();
    }
}

class Actress implements Runnable{

    public void run() {
        System.out.println(Thread.currentThread().getName()+" 是一个演员");
        int count = 0;

        boolean keepRunning = true;
        while(keepRunning){
            System.out.println(Thread.currentThread().getName()+" 登台演出 "+(++count));
            if(count == 100){
                keepRunning = false;
            }

            if(count % 10 == 0){
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(Thread.currentThread().getName()+" 演出结束");
    }
}
