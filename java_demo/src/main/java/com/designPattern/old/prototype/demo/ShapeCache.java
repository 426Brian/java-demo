package com.designPattern.old.prototype.demo;


import com.designPattern.old.prototype.sub.Shape;
import com.designPattern.old.prototype.sub.child.Circle;
import com.designPattern.old.prototype.sub.child.Rectangle;
import com.designPattern.old.prototype.sub.child.Square;

import java.util.Hashtable;

/**
 * Created by Brian in 23:16 2018/5/1
 */
public class ShapeCache {
    private static Hashtable<String, Shape> shapeTable = new Hashtable<String, Shape>();

    public static Shape getShape(String shapeId){
        Shape shape = shapeTable.get(shapeId);
        System.out.print("shape hashCode "+shape.hashCode()+" ");
        return (Shape) shape.clone();
    }

    public static void loadCache(){
        Circle circle = new Circle();
        circle.setId("1");
        shapeTable.put(circle.getId(), circle);

        Rectangle rectangle = new Rectangle();
        rectangle.setId("2");
        shapeTable.put(rectangle.getId(), rectangle);

        Square square = new Square();
        rectangle.setId("3");
        shapeTable.put(rectangle.getId(), square);
    }
}
