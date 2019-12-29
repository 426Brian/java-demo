package com.designPattern.old.prototype.sub.child;

import com.designPattern.old.prototype.sub.Shape;

/**
 * Created by Brian in 23:11 2018/5/1
 */
public class Rectangle extends Shape {
    public Rectangle() {
        type = "Green";
    }


    @Override
    protected void draw() {
        System.out.println("Green fill ==");
    }
}
