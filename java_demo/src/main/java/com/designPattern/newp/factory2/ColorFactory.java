package com.designPattern.newp.factory2;



/**
 * Created by Brian in 2:14 2018/11/24
 */
public class ColorFactory extends AbstractFactory {
    public Color getColor(String color) {
        if(color.equalsIgnoreCase("red")){
            return new Red();
        } else if(color.equalsIgnoreCase("green")){
            return new Green();
        } else if(color.equalsIgnoreCase("blue")){
            return new Blue();
        }else {
            return null;
        }

    }

    @Override
    public Shape getShape(String shape) {
        return null;
    }
}
