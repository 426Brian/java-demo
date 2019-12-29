package com.annotation.service;

/**
 * Created by Brian in 17:17 2018/3/9
 */
public interface Person {
    String name();

    int age();

    @Deprecated
    void sing();
}
