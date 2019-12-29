package com.dataStructure.linkList.unidirection.service.impl;

import com.dataStructure.com.service.IList;
import com.dataStructure.lineList.service.IStrategy;

/**
 * Created by Brian in 19:59 2018/6/1
 */
public class ListSLinked implements IList {

    private IStrategy strategy; // 数据元素比较策略
    private SLNode head; // 单链表首节点引用
    private int size;  // 线性表中元素个数

    public ListSLinked() {
    }

    public ListSLinked(IStrategy strategy) {
        this.strategy = strategy;
        this.head = new SLNode();
        this.size = 0;
    }

    // 辅助方法： 获取数据元素 e 所在节点的前驱节点
    private SLNode getPreNode(Object e) {
        SLNode p = head;
        while (p.getNext() != null) {
            if (strategy.equal(p.getNext().getData(), e)) {
                return p;
            } else {
                p = p.getNext();
            }
        }

        return null;
    }

    // 辅助方法： 获取序号为 0 <= i < size 的元素所在节点的前驱节点
    private SLNode getPreNode(int i) {
        SLNode p = head;
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
    }

    // 辅助方法： 获取序号为 0 <= i < size 的元素所在节点
    private SLNode getNode(int i) {
        SLNode p = head.getNext();
        for (; i > 0; i--) {
            p = p.getNext();
        }
        return p;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object obj) {
        SLNode  p = head.getNext();
        while(p != null){
            if(strategy.equal(p.getData(), obj)){
                return true;
            }else{
                p = p.getNext();
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object obj) {
        SLNode p = head.getNext();
        int index = 0;
        while (p !=null){
            if(strategy.equal(p.getData(), obj)){
                return index;
            }else{
                index++;
                p = p.getNext();
            }
        }
        return -1;
    }

    @Override
    public void insert(int i, Object obj) {
        if(i < 0 || i >= size){
            throw new IndexOutOfBoundsException("指定的插入序号越界");
        }
        SLNode p = getPreNode(i);
        SLNode q = new SLNode(obj, p.getNext());
    }

    // 将数据元素 e 插入元素 obj 之前
    @Override
    public boolean insertBefore(Object obj, Object e) {
        SLNode p = getPreNode(obj);
        if(p != null){
            SLNode q = new SLNode(e, p.getNext());
            p.setNext(q);
            size++;
            return true;
        }
        return false;
    }

    @Override
    public boolean insertAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object replace(int i, Object e) throws IndexOutOfBoundsException {
        return null;
    }

    @Override
    public Object get(int i) throws IndexOutOfBoundsException {
        return null;
    }
}
