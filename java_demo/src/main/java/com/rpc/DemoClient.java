package com.rpc;


import com.rpc.client.Client;
import com.rpc.service.HelloService;

import java.net.InetSocketAddress;

/**
 * Created by Brian in 17:18 2018/10/25
 */
public class DemoClient {
    public static void main(String[] args) {
        InetSocketAddress address = new InetSocketAddress("192.168.56.1", 9999);
        HelloService service = null;
        try {
            service = Client.getRemoteProxy(Class.forName("com.rpc.service.HelloService"), address);
            service.sayHello("Jack");
            service.write("Brian", 25);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
