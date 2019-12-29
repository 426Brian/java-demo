package com.designPattern.newp.factory;

/**
 * Created by Brian in 2:00 2018/11/24
 */
public class ShapeFactory {
    public Shape getShape(String shapeType) {
        if ("circle".equals(shapeType)){
            return new Circle();
        }else if ("square".equals(shapeType)){
            return new Square();
        }else if ("rectangle".equals(shapeType)){
            return new Rectangle();
        }else{
            return null;
        }

    }
}
