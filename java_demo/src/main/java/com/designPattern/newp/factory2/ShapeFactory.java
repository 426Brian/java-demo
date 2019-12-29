package com.designPattern.newp.factory2;



/**
 * Created by Brian in 2:14 2018/11/24
 */
public class ShapeFactory extends AbstractFactory {
    public Shape getShape(String shapeType) {
        if ("circle".equals(shapeType)){
            return new Circle();
        }else if ("square".equals(shapeType)){
            return new Square();
        }else if ("rectangle".equals(shapeType)){
            return new Circle();
        }else{
            return null;
        }

    }

    @Override
    public Color getColor(String color) {
        return null;
    }
}
