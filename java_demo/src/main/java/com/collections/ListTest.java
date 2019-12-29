package com.collections;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Brian in 21:49 2018/4/1
 */
public class ListTest {
    public List listCources;

    public ListTest(List listCources) {
        this.listCources = new ArrayList();
    }

    public void testAdd(){
        Course course = new Course("1", "dataStructure");
        listCources.add(course);
    }
}
