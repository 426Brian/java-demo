package com.annotation;

/**
 * JDK 注解
 * 1. @Override: 限定重写父类方法, 该注释只能用于方法
 * 2. @Deprecated: 用于表示某个程序元素(类, 方法等)已过时
 * 3. @SuppressWarnings: 抑制编译器警告
 *
 * 如何自定义一个注解
 * 元注解 说明注解的注解
 * Created by Brian in 20:17 2018/11/19
 */
public class JdkAnnotation {
    
}

class Person{
    String name;
    int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void walk(){
        System.out.println("走路");
    }

    @Deprecated
    public void eat(){
        System.out.println("吃饭");
    }
}

class Student extends Person{

    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void eat() {
        System.out.println("学生吃饭");
    }
}
