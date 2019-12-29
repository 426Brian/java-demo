package com.designPattern.newp.factory2;

/**
 * Created by Brian in 2:00 2018/11/24
 */
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);
}
