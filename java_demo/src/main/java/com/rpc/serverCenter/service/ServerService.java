package com.rpc.serverCenter.service;

/**
 * Created by Brian in 20:48 2018/10/24
 */
public interface  ServerService{
    void start() throws Exception;
    void stop();
    void register(Class serviceInterface, Class impl);
}
