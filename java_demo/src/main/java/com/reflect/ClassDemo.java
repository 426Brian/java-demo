package com.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Brian in 14:15 2018/4/2
 */
public class ClassDemo {
    public static void main(String[] args) {
        Foo foo1 = new Foo();

        /**
         * Foo 这个类也是一个实例对象, Class 类的实例对象
         * 三种表达方式：
         *   1. 任何一个类都有一个隐含的静态成员变量class
         *   2. 已知该类的对象通过getclass() 方法
         *   3. Class.forName(String className)
         */

        Class c1 = Foo.class;
        Class c2 = foo1.getClass();
        Class c3 = null;
        try {
            c3 = Class.forName("com.reflect.ClassDemo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Method method = c1.getMethod("print2", new Class[]{int.class, int.class});
//            method.invoke(new Foo(), 1, 2);
            method.invoke(foo1, 1, 2);

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class Foo {
    public void print(int a, int b) {
        System.out.print(a + b);
    }

    public void print(String a, String b) {
        System.out.println(a.toUpperCase() + ", " + b.toLowerCase());
    }

    public static void print2(int a, int b) {
        System.out.print(a + b);
    }
}