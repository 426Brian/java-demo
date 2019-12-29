package com.rmi.advance.client;

import com.rmi.advance.service.HelloService;

import java.rmi.Naming;

/**
 * Created by Brian in 18:44 2018/5/17
 */
public class RmiClient {
    public static void main(String[] args) throws Exception{
        String url = "rmi://localhost:1099/com.rmi.advance.service.impl.HelloServiceImpl";
        HelloService helloService = (HelloService) Naming.lookup(url);
        String result = helloService.sayHello("Jack");
        System.out.println("result from RmiClient === "+result);
    }
}
