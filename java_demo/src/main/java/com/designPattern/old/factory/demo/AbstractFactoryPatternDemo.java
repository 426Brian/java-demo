package com.designPattern.old.factory.demo;

import com.designPattern.old.factory.service.Color;
import com.designPattern.old.factory.service.Shape;

/**
 * Created by Brian in 21:32 2018/5/1
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        Shape cicle = shapeFactory.getShape("circle");
        cicle.draw();

        Shape rectangle = shapeFactory.getShape("rectangle");
        rectangle.draw();

        Shape square = shapeFactory.getShape("square");
        square.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        Color red = colorFactory.getColor("red");
        red.fill();

        Color green = colorFactory.getColor("green");
        green.fill();

        Color blue = colorFactory.getColor("blue");
        blue.fill();

    }
}
