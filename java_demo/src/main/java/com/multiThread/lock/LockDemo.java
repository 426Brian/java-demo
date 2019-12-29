package com.multiThread.lock;

/**
 * Created by Brian in 21:56 2018/11/26
 */
public class LockDemo implements Runnable{
    private static A a = new A();
    private static B b = new B();

    public static void main(String[] args) {
        LockDemo demo = new LockDemo();
    }

    public LockDemo(){
        new Thread(this).start();
        b.say(a);
    }

    @Override
    public void run() {
        a.say(b);
    }
}

class A {
    public synchronized void say(B b){
        System.out.println("A: 把你的本给我, 我给你笔");
        System.out.println("a.say()= "+System.currentTimeMillis());
        b.get();
    }

    public synchronized void get(){
        System.out.println("A: 我得到了本, 付出了笔, 还是什么都做不了");
    }
}

class B{
    public synchronized void say(A a){
        System.out.println("B: 把你的笔给我, 我给你本");
        System.out.println("b.say()= "+System.currentTimeMillis());
        a.get();
    }

    public synchronized void get(){
        System.out.println("B: 我得到了笔, 付出了本, 还是什么都做不了");
    }
}