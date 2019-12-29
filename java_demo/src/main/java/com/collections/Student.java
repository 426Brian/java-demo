package com.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brian in 21:48 2018/4/1
 */
public class Student {
    private String id;
    private String name;
    private Set courses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;

        this.courses = new HashSet();
    }
}
