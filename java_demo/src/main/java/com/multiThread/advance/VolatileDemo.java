package com.multiThread.advance;

/**
 * Created by Brian in 15:54 2018/4/25
 */
public class VolatileDemo {
    private int number;

    public int getNumber() {
        return this.number;
    }

    public synchronized void increase() {
        this.number++;

    }

    public static void main(String[] args) {
        VolatileDemo voldemo = new VolatileDemo();
        for (int i = 0; i < 500; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    voldemo.increase();
                }
            }).start();

        }

        System.out.println("number == " + voldemo.getNumber());
    }
}
