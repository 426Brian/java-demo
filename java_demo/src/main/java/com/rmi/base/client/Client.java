package com.rmi.base.client;

import com.rmi.base.service.Hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * rmi 客户端(服务消费端)
 * Created by Brian in 13:10 2018/4/30
 */
public class Client {

    public static void main(String[] args) {
        int port = 1099;
        try {
            Registry registry = LocateRegistry.getRegistry(port);
            Hello stub = (Hello) registry.lookup("Hello");

            stub.printMsg();
        } catch (Exception e) {
            System.out.println("Client exception");
            e.printStackTrace();
        }
    }
}
