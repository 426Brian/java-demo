package com.multiThread.lock;

import com.multiThread.base.Count;

import java.util.concurrent.CountDownLatch;

/**
 * Created by Brian in 22:16 2018/11/23
 */
public class Test {
    public static void main(String[] args) {
        int threadNum = 10;
        CountDownLatch countDownLatch = new CountDownLatch(threadNum);

        for (int i = 0; i < threadNum; i++) {
            new Thread("th"+i){
                @Override
                public void run() {
                    try {
                        countDownLatch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Count.add();
                }
            }.start();

            countDownLatch.countDown();
        }

    }
}
