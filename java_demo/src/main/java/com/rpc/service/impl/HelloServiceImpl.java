package com.rpc.service.impl;

import com.rpc.service.HelloService;

/**
 * Created by Brian in 20:45 2018/10/24
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        System.out.println("hello == " + name);
    }

    @Override
    public void write(String name, int i) {
        System.out.println("write == " + name + " i == " + i);
    }
}
