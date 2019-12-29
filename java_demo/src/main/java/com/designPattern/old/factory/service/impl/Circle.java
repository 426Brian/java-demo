package com.designPattern.old.factory.service.impl;

import com.designPattern.old.factory.service.Shape;

/**
 * Created by Brian in 20:22 2018/5/1
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Red fill == ");
    }
}
