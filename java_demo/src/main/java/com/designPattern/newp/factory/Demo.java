package com.designPattern.newp.factory;

/**
 * Created by Brian in 2:03 2018/11/24
 */
public class Demo {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        Shape circle = factory.getShape("circle");
        circle.draw();
    }
}
