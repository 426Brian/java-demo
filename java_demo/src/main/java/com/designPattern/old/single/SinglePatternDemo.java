package com.designPattern.old.single;

/**
 * Created by Brian in 21:40 2018/5/1
 */
public class SinglePatternDemo {
    public static void main(String[] args) {
        SingleObject singleObj = SingleObject.getInstance();
        singleObj.showMessage();

        SingleObject singleObject2 = SingleObject.getInstance();
        singleObject2.showMessage();
    }
}
