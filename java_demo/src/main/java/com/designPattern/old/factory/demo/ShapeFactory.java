package com.designPattern.old.factory.demo;

import com.designPattern.old.factory.service.Color;
import com.designPattern.old.factory.service.Shape;
import com.designPattern.old.factory.service.impl.Circle;
import com.designPattern.old.factory.service.impl.Rectangle;
import com.designPattern.old.factory.service.impl.Square;

/**
 * Created by Brian in 20:24 2018/5/1
 */
public class ShapeFactory extends AbstractFactory{
    @Override
    Color getColor(String color) {
        return null;
    }

    public Shape getShape(String shapeType) {

        if ("RECTANGLE".equalsIgnoreCase(shapeType)) {
            return new Rectangle();
        } else if ("Blue".equalsIgnoreCase(shapeType)) {
            return new Square();
        } else if ("Red".equalsIgnoreCase(shapeType)) {
            return new Circle();
        } else {
            return null;
        }
    }


}
