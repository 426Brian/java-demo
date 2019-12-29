package com.multiThread.advance;

/**
 * Created by Brian in 20:14 2018/4/24
 */
public class SynchronizeDemo {
    private boolean ready;
    private int result;
    private int number = 1;

    // 写操作
    public void write(){
        ready = true;
        number = 2;
    }

    // 读操作
    public void read(){
        if(ready){
            result = 3*number;
        }
        System.out.println("result == "+result);
    }

    // 内部线程类
    private class ReadWriteThread extends Thread {
        private boolean flag;

        public ReadWriteThread(boolean flag){
            this.flag = flag;
        }

        public void run(){
            if(flag){
                write();
            }else{
                read();
            }
        }

    }

    public static void main(String[] args) {
        SynchronizeDemo synDemo = new SynchronizeDemo();

        synDemo.new ReadWriteThread(true).start();
        synDemo.new ReadWriteThread(false).start();
    }

}
