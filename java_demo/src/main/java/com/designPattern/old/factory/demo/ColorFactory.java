package com.designPattern.old.factory.demo;

import com.designPattern.old.factory.service.Color;
import com.designPattern.old.factory.service.Shape;
import com.designPattern.old.factory.service.impl.Blue;
import com.designPattern.old.factory.service.impl.Green;
import com.designPattern.old.factory.service.impl.Red;

/**
 * Created by Brian in 20:24 2018/5/1
 */
public class ColorFactory extends AbstractFactory{
    @Override
    Shape getShape(String shape) {
        return null;
    }

    public Color getColor(String color) {

        if ("RED".equalsIgnoreCase(color)) {
            return new Red();
        } else if ("GREEN".equalsIgnoreCase(color)) {
            return new Green();
        } else if ("BLUE".equalsIgnoreCase(color)) {
            return new Blue();
        } else {
            return null;
        }
    }


}
