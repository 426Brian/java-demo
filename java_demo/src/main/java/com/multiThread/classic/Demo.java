package com.multiThread.classic;

/**
 * Created by Brian in 20:58 2018/11/24
 */
public class Demo {
    public static void main(String[] args) {
        Info info = new Info();
        new Thread(new Producer(info)).start();
        new Thread(new Customer(info)).start();
    }
}

class Info{
    private String title;
    private String content;
    private boolean flag;

    // flag = false 生产不可以取走
    // flag = true 可以取走不能生产
    public synchronized void set(String title, String content){
        if(flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        this.title = title;
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.content = content;

        flag = true;
        super.notifyAll();
    }

    public synchronized void get(){

        if(!flag){
            try {
                super.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(title+" ---> "+content);
        flag = false;
        notify();

    }
}

class Producer implements Runnable{
    private Info info;

    public Producer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            if(i%2 == 0){
                info.set("学生","学生A");
            }else{
               info.set("动物","小狗");
            }
        }
    }
}

class Customer implements Runnable{
    private Info info;

    public Customer(Info info) {
        this.info = info;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
           info.get();
        }
    }
}