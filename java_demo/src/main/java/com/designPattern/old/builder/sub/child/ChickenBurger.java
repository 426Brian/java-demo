package com.designPattern.old.builder.sub.child;

import com.designPattern.old.builder.sub.Burger;

/**
 * Created by Brian in 19:17 2018/5/2
 */
public class ChickenBurger extends Burger {
    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 32.8f;
    }
}
