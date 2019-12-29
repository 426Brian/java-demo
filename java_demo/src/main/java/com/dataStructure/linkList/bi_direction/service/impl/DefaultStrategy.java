package com.dataStructure.linkList.bi_direction.service.impl;

import com.dataStructure.linkList.bi_direction.service.IStrategy;

/**
 * Created by Brian in 17:31 2018/6/1
 */
public class DefaultStrategy implements IStrategy {
    @Override
    public boolean equal(Object obj1, Object obj2) {
        return obj1.equals(obj2);
    }

    @Override
    public int compare(Object obj1, Object obj2) {
        return obj1.toString().compareTo(obj2.toString());
    }
}
