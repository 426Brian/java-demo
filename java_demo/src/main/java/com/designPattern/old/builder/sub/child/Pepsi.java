package com.designPattern.old.builder.sub.child;

import com.designPattern.old.builder.sub.ColdDrink;

/**
 * Created by Brian in 19:17 2018/5/2
 */
public class Pepsi extends ColdDrink {
    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 8.8f;
    }
}
