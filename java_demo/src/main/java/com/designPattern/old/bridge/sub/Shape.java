package com.designPattern.old.bridge.sub;

import com.designPattern.old.bridge.service.DrawAPI;

/**
 * Created by Brian in 20:14 2018/5/11
 */
public abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI){
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}
