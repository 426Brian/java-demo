package com.zookeeper.provider;

import com.rmi.advance.service.HelloService;
import com.rmi.advance.service.impl.HelloServiceImpl;

import java.util.Arrays;

/**
 * Created by Brian in 22:04 2018/5/17
 */
public class Server {
    public static void main(String[] args) throws Exception{
       System.out.println("args == "+Arrays.asList(args));

        if(args.length != 2){
            System.err.println("please using command: java Server <rmi_host> <rmi_port>");
            System.exit(-1);
        }

        String host = args[0];
        int port = Integer.parseInt(args[1]);
        ServiceProvider provider = new ServiceProvider();
        HelloService helloService = new HelloServiceImpl();

        provider.publish(helloService, host, port);

        Thread.sleep(Long.MAX_VALUE);
    }
}
