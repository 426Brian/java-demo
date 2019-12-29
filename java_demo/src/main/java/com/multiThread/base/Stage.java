package com.multiThread.base;

/**
 * Created by Brian in 21:16 2018/1/29
 */
public class Stage extends Thread {

    public void run(){
        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        // 使用Runnable 接口创建线程
        Thread armyofSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfSuiDynasty, "农民起义军");

        // 启动线程，让军队开始作战
        armyofSuiDynasty.start();
        armyOfRevolt.start();

        // 舞台线程休眠
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("双方激战正酣, 半路杀出程咬金");

        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想就是结束战斗, 使百姓安居乐业");

        // 军队停止作战
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();

        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("程咬金结束了战斗，实现了理想");
    }

    public static void main(String[] args){
        new Stage().start();
    }
}
