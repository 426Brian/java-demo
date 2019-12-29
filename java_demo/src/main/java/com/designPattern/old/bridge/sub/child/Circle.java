package com.designPattern.old.bridge.sub.child;

import com.designPattern.old.bridge.service.DrawAPI;
import com.designPattern.old.bridge.sub.Shape;

/**
 * Created by Brian in 20:15 2018/5/11
 */
public class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawAPI drawAPI) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}
