package com.dataStructure.com.service;

/**
 * Created by Brian in 17:24 2018/6/1
 */
public interface IList {
    // 返回线性表的大小，即数据元素的个数
    int getSize();

    // 判断是否为空
    boolean isEmpty();

    // 是否包含数据元素 e
    boolean contains(Object obj);

    // 元素在线性表中的序号
    int indexOf(Object obj);

    // 将obj 插入线性表 i 号位置
    void insert(int i, Object obj) throws IndexOutOfBoundsException;

    // 将元素e 插入到obj 之前
    boolean insertBefore(Object obj, Object e) throws IndexOutOfBoundsException;

    // 将元素e 插入到obj 之后
    boolean insertAfter(Object obj, Object e) throws IndexOutOfBoundsException;

    // 删除线性表中序号为 i 的元素表返回该元素
    Object remove(int i) throws IndexOutOfBoundsException;

    // 替换线性表中序号为 i 的元素，返回被替换元素
    Object replace(int i, Object e) throws IndexOutOfBoundsException;

    // 返回线性表中序号为i 的元素
    Object get(int i) throws IndexOutOfBoundsException;
}
