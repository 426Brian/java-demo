package com.rpc.client;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * Created by Brian in 21:06 2018/10/24
 */
public class Client {

    public static <T> T getRemoteProxy(Class serviceInterface, InetSocketAddress address) {
        ClassLoader loader = serviceInterface.getClassLoader();
        Class<?>[] interfaces = {serviceInterface};

        /*InvocationHandler h = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                Socket socket = new Socket();
                socket.connect(address);
                ObjectOutputStream objOutput = null;
                ObjectInputStream objInput = null;
                try {
                    objOutput = new ObjectOutputStream(socket.getOutputStream());
                    // 接口名
                    objOutput.writeUTF(serviceInterface.getName());
                    // 方法
                    objOutput.writeUTF(method.getName());
                    objOutput.writeObject(method.getParameterTypes());
                    objOutput.writeObject(args);

                    // 等待服务端处理
                    // 接口服务器响应
                    objInput = new ObjectInputStream(socket.getInputStream());

                    return objInput.readObject();
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                } finally {
                    if (objOutput != null) {
                        objOutput.close();
                    }
                    if (objInput != null) {
                        objInput.close();
                    }
                    if(socket !=null){
                        socket.close();
                    }
                }

            }
        };

        return (T) Proxy.newProxyInstance(loader, interfaces, h);*/


//        lamda 编程，写法简单
        return (T) Proxy.newProxyInstance(loader, interfaces, (proxy, method, args) -> {
            Socket socket = new Socket();
            socket.connect(address);
            ObjectOutputStream objOutput = null;
            ObjectInputStream objInput = null;
            try {
                objOutput = new ObjectOutputStream(socket.getOutputStream());
                // 接口名
                objOutput.writeUTF(serviceInterface.getName());
                // 方法
                objOutput.writeUTF(method.getName());
                objOutput.writeObject(method.getParameterTypes());
                objOutput.writeObject(args);

                // 等待服务端处理
                // 接口服务器响应
                objInput = new ObjectInputStream(socket.getInputStream());

                return objInput.readObject();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            } finally {
                if (objOutput != null) {
                    objOutput.close();
                }
                if (objInput != null) {
                    objInput.close();
                }
                if (socket != null) {
                    socket.close();
                }
            }

        });
    }
}
