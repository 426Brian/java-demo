package com.rmi.advance.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * RMI 服务接口
 * Created by Brian in 18:34 2018/5/17
 */
public interface HelloService extends Remote {
    String sayHello(String name) throws RemoteException;
}
