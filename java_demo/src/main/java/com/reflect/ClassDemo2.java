package com.reflect;

/**
 * Created by Brian in 14:15 2018/4/2
 */
public class ClassDemo2 {
    public static void main(String[] args) {
        test();
        new ClassDemo2().test();
    }

    public static void test(){
        System.out.println("static method test");
    }
}
