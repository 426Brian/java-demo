package com.dataStructure.linkList.bi_direction.service;

/**
 * Created by Brian in 17:24 2018/6/1
 */
public interface IList {
    // 返回线性表的大小
    int getSize();

    // 是否为空
    boolean isEmpty();

    // 是否包含数据元素 e
    boolean contains(Object obj);

    int indexOf(Object obj);

    void insert(int i, Object obj);

    boolean insertBefore(Object obj, Object e);

    boolean insertAfter(Object obj, Object e);

    Object remove(int i);

    Object replace(int i, Object e);

    Object get(int i);
}
