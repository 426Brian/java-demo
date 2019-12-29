package com.designPattern.newp.factory2;

/**
 * Created by Brian in 2:03 2018/11/24
 */
public class Demo {
    public static void main(String[] args) {
       AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
       Shape shape = shapeFactory.getShape("circle");
    }
}
