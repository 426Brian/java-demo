package com.designPattern.old.builder.sub.child;

import com.designPattern.old.builder.sub.ColdDrink;

/**
 * Created by Brian in 19:17 2018/5/2
 */
public class Coke extends ColdDrink {
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 6.8f;
    }
}
