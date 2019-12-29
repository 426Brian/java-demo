package com.study;

/**
 * Created by Brian in 16:45 2018/4/1
 */
public class InnerTest {
    public class Inner {

        // 内部类的方法
        public void show() {
            System.out.println("welcome to imooc!");
        }
    }

    public static void main(String[] args) {

        // 创建外部类对象
        InnerTest hello = new InnerTest();
        // 创建内部类对象
        Inner i = hello.new Inner();
        // 调用内部类对象的方法
        i.show();
    }
}
