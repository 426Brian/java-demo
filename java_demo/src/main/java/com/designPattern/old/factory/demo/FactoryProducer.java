package com.designPattern.old.factory.demo;

/**
 * Created by Brian in 21:29 2018/5/1
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if("shape".equalsIgnoreCase(choice)){
            return new ShapeFactory();
        }else if("color".equalsIgnoreCase(choice)){
            return new ColorFactory();
        }else {
            return null;
        }
    }
}
