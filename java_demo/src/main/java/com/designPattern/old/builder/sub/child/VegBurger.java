package com.designPattern.old.builder.sub.child;

import com.designPattern.old.builder.sub.Burger;

/**
 * Created by Brian in 19:17 2018/5/2
 */
public class VegBurger extends Burger {
    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 25.6f;
    }
}
