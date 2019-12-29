package com.multiThread.base;

/**
 * Created by Brian in 22:35 2018/1/29
 */
public class KeyPersonThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" 开始战斗");
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName()+" 左突右杀, 攻击随军");
        }

        System.out.println(Thread.currentThread().getName()+" 结束了战斗");
    }
}
