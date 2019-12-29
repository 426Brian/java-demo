package com.designPattern.old.prototype.demo;

import com.designPattern.old.prototype.sub.Shape;

/**
 * Created by Brian in 23:43 2018/5/1
 */
public class PrototypePatternDemo {
    public static void main(String[] args) {
        ShapeCache.loadCache();
        Shape cloneShape1 = ShapeCache.getShape("1");
        System.out.println("shapeCopy "+cloneShape1.hashCode()+" type is: "+cloneShape1.getType());

        Shape cloneShape2 = ShapeCache.getShape("2");
        System.out.println("shapeCopy "+cloneShape2.hashCode()+" type is: "+cloneShape2.getType());

        Shape cloneShape3 = ShapeCache.getShape("3");
        System.out.println("shapeCopy "+cloneShape3.hashCode()+" type is: "+cloneShape3.getType());
    }
}
