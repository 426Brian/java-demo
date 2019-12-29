package com.rmi.advance;


import com.rmi.advance.client.RmiClient;
import com.rmi.advance.server.RmiServer;

/**
 * Created by Brian in 20:18 2018/5/17
 */
public class RmiDemo {
    public static void main(String[] args) throws Exception{
        RmiServer.main(null);
        RmiClient.main(null);
    }
}
