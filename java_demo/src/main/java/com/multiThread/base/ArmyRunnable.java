package com.multiThread.base;

/**
 * Created by Brian in 21:15 2018/1/29
 */
public class ArmyRunnable implements Runnable{
    // volatile 保证了线程可以读取其他线程写入的值
    // 可见性 happens-before 原则
    volatile boolean keepRunning = true;

    public void run() {
        while(keepRunning){
            // 发动5 连击
            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName()+" 进攻次数 == "+i);
                // 让出CPU 时间
                Thread.yield();
            }

            System.out.println(Thread.currentThread().getName()+" 结束战斗");
        }
    }
}
