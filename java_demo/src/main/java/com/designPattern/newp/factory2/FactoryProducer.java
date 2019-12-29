package com.designPattern.newp.factory2;

/**
 * Created by Brian in 2:17 2018/11/24
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String choice){
        if("shape".equals(choice)){
            return new ShapeFactory();
        }else  if("color".equals(choice)){
            return new ShapeFactory();
        }else{
            return null;
        }
    }
}
