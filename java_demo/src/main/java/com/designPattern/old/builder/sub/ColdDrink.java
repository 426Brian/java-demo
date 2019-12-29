package com.designPattern.old.builder.sub;

import com.designPattern.old.builder.service.Item;
import com.designPattern.old.builder.service.Packing;
import com.designPattern.old.builder.service.impl.Bottle;

/**
 * Created by Brian in 19:16 2018/5/2
 */
public abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }
}
