package com.dataStructure.lineList.service.impl;

import com.dataStructure.com.service.IList;
import com.dataStructure.lineList.service.IStrategy;

/**
 * Created by Brian in 17:33 2018/6/1
 */
public class MyArrayList implements IList {

    private final int LEN = 8;  // 数组默认大小
    private IStrategy strategy; // 数据元素比较策略
    private int size; // 线性表中元素的个数
    private Object[] elements; // 数据元素数组

    // default constructor
    public MyArrayList() {
        this(new DefaultStrategy());
    }

    // constructor with parameter IStrategy
    public MyArrayList(IStrategy iStrategy) {
        this.strategy = iStrategy;
        size = LEN;
        elements = new Object[LEN];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        for (int i = 0; i < size; i++) {
            if (this.strategy.equal(obj, elements[i])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object obj) {
        for (int i = 0; i < size; i++) {
            if (strategy.equal(obj, elements[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void insert(int i, Object obj) throws IndexOutOfBoundsException {
        // 检查下标越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("指定的插入序号越界");
        }

        // 检查线性表数组的容量
        if (size >= elements.length) {
            // 扩展表空间
            expandSpace();
        }

        // 将插入位置后的数据元素一次向后移动一个单位
        for (int j = size; j > i; j--) {
            elements[j] = elements[j - 1];
        }

        // 插入数据
        elements[i] = obj;
        size++;
    }

    // 扩展顺序表空间
    private void expandSpace() {
        Object[] a = new Object[elements.length * 2];
        for (int i = 0; i < elements.length; i++) {
            a[i] = elements[i];
        }
        elements = a;
    }

    @Override
    public boolean insertBefore(Object obj, Object e) {
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        insert(i, e);
        return true;
    }

    @Override
    public boolean insertAfter(Object obj, Object e) {
        int i = indexOf(obj);
        if (i < 0) {
            return false;
        }
        insert(i + 1, e);
        return true;
    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {

        // 检查是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("指定的插入序号越界");
        }
        Object obj = elements[i];
        // 被删除的数据元素后的数据前移一个单位
        for (int j = i; j < size - 1; j++) {
            elements[j] = elements[j + 1];
        }
        // 最后一个元素
        elements[--size] = null;

        return obj;
    }

    @Override
    public Object replace(int i, Object e) {
        // 检查是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("指定的插入序号越界");
        }
        Object obj = elements[i];
        elements[i] = e;
        // 返回被替换的元素
        return obj;
    }


    @Override
    public Object get(int i) {
        // 检查是否越界
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException("指定的插入序号越界");
        }
        return elements[i];
    }
}
