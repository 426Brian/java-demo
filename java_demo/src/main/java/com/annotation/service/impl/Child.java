package com.annotation.service.impl;

import com.annotation.brianAnnotation.Description;
import com.annotation.service.Person;



/**
 * Created by Brian in 17:20 2018/3/9
 */
@Description(desc = "I am class annotation", author = "Brian")
public class Child implements Person {
    @Override
    @Description(desc = "I am method annotation", author = "Brian")
    public String name() {
        return null;
    }

    @Override
    public int age() {
        return 0;
    }

    @Override
    public void sing() {

    }


}
