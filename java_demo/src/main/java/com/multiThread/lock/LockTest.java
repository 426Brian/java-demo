package com.multiThread.lock;


/**
 * Created by Brian in 21:46 2018/11/20
 */
public class LockTest {
    static StringBuffer sb1 = new StringBuffer();
    static StringBuffer sb2 = new StringBuffer();

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                synchronized (sb1){
                    sb1.append("A");
                    synchronized (sb2){
                        sb2.append("B");
                        System.out.println("sb1 == "+sb1);
                        System.out.println("sb2 == "+sb2);
                    }

                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                synchronized (sb2){
                    sb2.append("C");
                    synchronized (sb1){
                        sb1.append("D");
                        System.out.println("sb1 == "+sb1);
                        System.out.println("sb2 == "+sb2);
                    }
                }
            }
        }.start();


    }
}
