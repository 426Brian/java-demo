package com.designPattern.old.builder.service.impl;

import com.designPattern.old.builder.service.Packing;

/**
 * Created by Brian in 19:15 2018/5/2
 */
public class Wraper implements Packing {
    @Override
    public String pack() {
        return "Wraper";
    }
}
