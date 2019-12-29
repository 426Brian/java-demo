package com.designPattern.old.single;

/**
 * Created by Brian in 21:38 2018/5/1
 */
public class SingleObject {
    private static SingleObject instance = new SingleObject();

    // 私有化构造方法
    private SingleObject(){
    }

    public static SingleObject getInstance(){
        return instance;
    }

    public void showMessage(){
        System.out.println("instance hashCode == " +instance.hashCode());
    }
}
