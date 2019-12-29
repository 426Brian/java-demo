package com.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Brian in 22:03 2018/3/12
 */
public class Student {
    public String id;

    public String name;

    public Set courses;

    public Student(String id, String name){
        this.id = id;
        this.name = name;
        this.courses = new HashSet();
    }
}
