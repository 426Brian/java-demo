package com.designPattern.old.bridge;

import com.designPattern.old.bridge.service.impl.GreenCircle;
import com.designPattern.old.bridge.service.impl.RedCircle;
import com.designPattern.old.bridge.sub.Shape;
import com.designPattern.old.bridge.sub.child.Circle;

/**
 * Created by Brian in 20:19 2018/5/11
 */
public class Demo {
    public static void main(String[] args) {
        Shape redCircle = new Circle(100, 100, 10, new RedCircle());
        Shape greenCirlce = new Circle(100, 100, 10, new GreenCircle());

        redCircle.draw();
        greenCirlce.draw();
    }
}
