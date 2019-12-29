package com.rmi.advance.service.impl;

import com.rmi.advance.service.HelloService;

import java.io.Serializable;
import java.rmi.RemoteException;

/**
 * RMI 服务实现
 * Created by Brian in 18:36 2018/5/17
 */
public class HelloServiceImpl implements HelloService, Serializable {
    public HelloServiceImpl(){

    }

    @Override
    public String sayHello(String name) throws RemoteException {
        return String.format("Hello %s", name);
    }

}
