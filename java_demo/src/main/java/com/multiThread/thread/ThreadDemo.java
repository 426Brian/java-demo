package com.multiThread.thread;

/**
 * Thread 常用方法
 * 1. start() 启动线程并执行相应的run() 方法
 * 2. run() 子线程要执行的功能
 * 3. currentThread() 静态的, 调取当前的线程
 * 4. getName() 获取线程名字
 * 5. setName() 设置线程名字
 * 6. yield() 调用此方法的线程释放当前CPU 执行权
 * 7. join() 在A 线程中调用B 线程的join() 方法, 表示执行到此方法, A 线程停止执行, 直到B 线程执行完毕
 * 8. isAlive() 判断调用此方法的线程是否存活
 * 9. sleep(long l) 显示的让当前线程睡眠
 * 10. 线程通讯：wait() notify() notifyAll() 这三个方法定义在Object 中
 * 1. wait() 令当前线程挂起并放弃CPU、同步资源, 使别的线程可访问并修改共享资源, 而
 * 当前线程
 * <p>
 * Created by Brian in 2:22 2018/11/20
 */
public class ThreadDemo {
    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        subThread.setName("th --");
        subThread.start();
        test();
    }

    public static void test() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }


}

class SubThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}