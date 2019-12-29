package com.rmi.base.service.impl;

import com.rmi.base.service.Hello;

/**
 * Created by Brian in 13:03 2018/4/30
 */
public class HelloImpl implements Hello {

    @Override
    public void printMsg() {
        System.out.println("this is an example RMI program");
    }
}
