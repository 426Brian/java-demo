package com.dataStructure.linkList.bi_direction.service;

/**
 * 对象比较策略
 * Created by Brian in 17:24 2018/6/1
 */
public interface IStrategy {
    boolean equal(Object obj1, Object obj2);

    /**
     * obj1 > obj2 返回 1, obj1 < obj2 返回 -1
     * obj1 == obj2 返回 0
     * @param obj1
     * @param obj2
     * @return
     */
    int compare(Object obj1, Object obj2);
}
