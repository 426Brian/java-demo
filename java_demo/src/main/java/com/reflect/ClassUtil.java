package com.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by Brian in 14:32 2018/4/2
 */
public class ClassUtil {
    public static void main(String[] args) {
        constructorMessage(String.class);
    }

    public static void printClassMessage(Object obj) {
        Class c = obj.getClass();
        System.out.println("类名称： "+c);

    }

    private static void methodMessage(Class c) {
        // 所有方法
        Method[] ms = c.getMethods();

        // 自己声明的方法
        c.getDeclaredMethods();

        for (int i = 0; i < ms.length; i++) {
            System.out.println();
            // 方法返回值
            System.out.print("方法返回值："+ms[i].getReturnType()+" 方法名： "+ms[i].getName()+"\t");


            // 获取参数类型
            Class[] paramTypes = ms[i].getParameterTypes();
            for (Class classT: paramTypes) {
                System.out.print(" 参数类型："+classT.getName()+"\t");
            }
        }
    }

    private static void fieldMessage(Class c) {
        Field[] fields = c.getFields();
        for (Field field: fields) {
            Class fieldType = field.getType();
            System.out.println(" 变量类型："+fieldType.getName()+" 变量名："+field.getName()+"\t");
        }
    }

    private static void constructorMessage(Class c){
        Constructor[] cs = c.getConstructors();
        for (Constructor constructor: cs) {
            System.out.println();

            Class[] paramtypes = constructor.getParameterTypes();
            System.out.print(constructor.getName());
            if(paramtypes.length > 0){
                System.out.print(" (");
                for (int i = 0; i < paramtypes.length; i++) {
                    System.out.print(paramtypes[i].getName()+ (i==paramtypes.length - 1 ? ")" : ","));
                }
            }else{
                System.out.print(" null");
            }


        }
    }
}
