package com.reflect;

/**
 * Created by Brian in 3:39 2018/11/21
 */
public class BaseType {
    public static void main(String[] args) {
        // int 类类型
        Class c = int.class;
        Class c_str = String.class;

        Class c_v = void.class;
        System.out.println(c_v.getName());
    }
}
