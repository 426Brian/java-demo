package com.rmi.base;


import com.rmi.base.client.Client;
import com.rmi.base.server.Server;

/**
 * RMI 简单测试，确保server/client 中端口未被占用
 * Created by Brian in 20:07 2018/5/17
 */
public class RmiDemo {
    public static void main(String[] args) throws Exception{
        StartRmiregistry.main(null);
        // 主线程等待3秒确保注册表开启处于alive 状态
        Thread.sleep(3000);
        Server.main(null);
        Client.main(null);

    }
}
