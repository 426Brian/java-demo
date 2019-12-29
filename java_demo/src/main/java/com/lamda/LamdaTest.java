package com.lamda;

/**
 * Created by Brian in 17:03 2018/5/26
 */
public class LamdaTest {
    public static void main(String[] args) {
        new Runnable(){
            @Override
            public void run() {
                System.out.println("== 匿名内部类实现Runnable 接口");
            }
        }.run();

        int i = 1;
        Runnable r = () -> {
            System.out.println("=== 用lamda实现Runnable 接口");
            System.out.println("i == " + i);
        };

        r.run();

        System.out.println();
        test();
    }

    public static void test(){
        new Action(){
            @Override
            public void execute(String content) {
                System.out.println(content);
            }
        }.execute("jdk1.8 之前匿名内部类实现方式");

        Action action = (String content) ->{
            System.out.println(content);
        };
        action.execute("jdk1.8 lamda 方式实现");
    }

    static interface Action{
        void execute(String content);
    }
}
