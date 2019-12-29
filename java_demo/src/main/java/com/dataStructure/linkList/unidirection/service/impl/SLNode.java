package com.dataStructure.linkList.unidirection.service.impl;

import com.dataStructure.linkList.unidirection.service.INode;

/**
 * Created by Brian in 19:56 2018/6/1
 */
public class SLNode implements INode {
    private Object element;
    private SLNode next;

    public Object getElement() {
        return element;
    }

    public void setElement(Object element) {
        this.element = element;
    }

    public SLNode getNext() {
        return next;
    }

    public void setNext(SLNode next) {
        this.next = next;
    }

    public SLNode() {
        this(null, null);
    }

    public SLNode(Object element, SLNode next) {
        this.element = element;
        this.next = next;
    }

    @Override
    public Object getData() {
        return this.element;
    }

    @Override
    public void setData(Object object) {
        this.element = object;
    }
}
