package com.designPattern.old.bridge.service.impl;

import com.designPattern.old.bridge.service.DrawAPI;

/**
 * Created by Brian in 20:11 2018/5/11
 */
public class RedCircle implements DrawAPI {
    @Override
    public void drawCircle(int radius, int x, int y) {
        System.out.println("drawing circle color is red, radius: " + radius + ", x: " + x + ", y: " + y);
    }
}
