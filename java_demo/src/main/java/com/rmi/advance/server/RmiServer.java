package com.rmi.advance.server;

import com.rmi.advance.service.impl.HelloServiceImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * Created by Brian in 18:42 2018/5/17
 */
public class RmiServer {
    public static void main(String[] args) throws Exception{
        int port = 1099;
        String url = "rmi://localhost:1099/com.rmi.advance.service.impl.HelloServiceImpl";

        Registry registry = LocateRegistry.createRegistry(port);

        Naming.rebind(url, new HelloServiceImpl());
    }
}
