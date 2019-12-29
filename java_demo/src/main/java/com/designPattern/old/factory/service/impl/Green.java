package com.designPattern.old.factory.service.impl;

import com.designPattern.old.factory.service.Color;

/**
 * Created by Brian in 20:35 2018/5/1
 */
public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("green == ");
    }
}
