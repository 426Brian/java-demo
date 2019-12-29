package com.rpc;

import com.rpc.serverCenter.service.ServerService;
import com.rpc.serverCenter.service.impl.ServerServiceImpl;
import com.rpc.service.HelloService;
import com.rpc.service.impl.HelloServiceImpl;

/**
 * Created by Brian in 17:11 2018/10/25
 */
public class DemoServer {
    public static void main(String[] args) {
        ServerService serverService = new ServerServiceImpl(9999);
        serverService.register(HelloService.class, HelloServiceImpl.class);
        try {
            // 启动

//            serverService.start();

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 用线程的方式启动
        new Thread(() -> {
            try {
                serverService.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
