package com.designPattern.old.factory.demo;

import com.designPattern.old.factory.service.Color;
import com.designPattern.old.factory.service.Shape;

/**
 * Created by Brian in 21:25 2018/5/1
 */
public abstract class AbstractFactory {
    abstract Color getColor(String color);
    abstract Shape getShape(String shapeType);
}
