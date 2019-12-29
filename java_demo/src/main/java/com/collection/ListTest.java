package com.collection;

import java.util.*;

/**
 * Created by Brian in 22:06 2018/3/12
 */
public class ListTest {
    public List coursesToSelect;

    public ListTest(){
        this.coursesToSelect = new ArrayList();
    }

    public void testAdd(){
        Course cr1 = new Course("1", "数据结构");
        coursesToSelect.add(cr1);

        Course cr2 = new Course("2", "JAVA");
        coursesToSelect.add(0, cr2);

        for(ListIterator<Course> iterator = coursesToSelect.listIterator(); iterator.hasNext();){
            System.out.println("=== "+iterator.next().id);
        }

    }

    public static void main(String[] args){
        ListTest lt = new ListTest();
        lt.testAdd();
    }
}
