package com.rmi.base.server;

import com.rmi.base.service.Hello;
import com.rmi.base.service.impl.HelloImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * 提供rmi 服务端
 * Created by Brian in 13:05 2018/4/30
 */
public class Server extends HelloImpl {
    public Server() {
    }

    public static void main(String[] args) {
        HelloImpl helloImpl = new HelloImpl();

        int port = 1099;

        try {
            Hello stub = (Hello) UnicastRemoteObject.exportObject(helloImpl, 0);
            Registry registry = LocateRegistry.getRegistry(port);

            registry.bind("Hello", stub);
            System.out.println("Server ready");

        } catch (Exception e) {
            System.out.println("Server exception");
            e.printStackTrace();
        }

        // 可以在Server 中直接运行Client, 为了直观，建议分开运行
//        Client.main(null);

    }
}
