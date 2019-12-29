package com.rpc.serverCenter.service.impl;

import com.rpc.serverCenter.service.ServerService;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Brian in 20:50 2018/10/24
 */
public class ServerServiceImpl implements ServerService {

    private static HashMap<Class, Class> serviceRegisterMap = new HashMap();
    private static int port;
    private static boolean isRunning;
    // 连接池 用于多线程                                             运行时环境根据处理器的核心数动态建立池信息
    private ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public ServerServiceImpl(int port) {
        this.port = port;
    }

    @Override
    public void start() throws Exception {

        ServerSocket serverSocket = null;
        isRunning = true;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress(port));
            System.out.println("start server ...");
            while (true) {

//            等待客户端连接
                Socket socket = null;
                socket = serverSocket.accept();
                final Socket socketF = socket;

                // lamda 简化编程，可以不写内部类
                executor.execute(() -> {
                    ObjectInputStream objInput = null;
                    ObjectOutputStream objOutput = null;
                    try {

                        objInput = new ObjectInputStream(socketF.getInputStream());

                        // 因为序列化流对发送数据的顺序严格要求，因此需要参照发送顺序取
                        String serviceName = objInput.readUTF();
                        String methodName = objInput.readUTF();
                        Class[] paraTypes = (Class[]) objInput.readObject();
                        Object[] args = (Object[]) objInput.readObject();
                        // 根据客户请求, 到map 中找到与之对应的接口

                        Class serviceClass = serviceRegisterMap.get(Class.forName(serviceName));
                        Method method = serviceClass.getMethod(methodName, paraTypes);
                        Object result = method.invoke(serviceClass.newInstance(), args);

                        // 向客户端发送执行结果
                        objOutput = new ObjectOutputStream(socketF.getOutputStream());
                        objOutput.writeObject(result);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {

                        try {
                            if (objInput != null) {
                                objInput.close();
                            }
                            if (objOutput != null) {
                                objOutput.close();
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                });

                // 下面这段与 TaskService 类是不用 lamda 编程的方式
//                executor.execute(new TaskService(socket));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }


    }

  /*  public static class TaskService implements Runnable{
        private Socket socket;
        public TaskService() {
        }

        public TaskService(Socket socket) {
            this.socket = socket;
        }


        @Override
        public void run() {
            ObjectInputStream objInput = null;
            ObjectOutputStream objOutput = null;
            try {

                objInput = new ObjectInputStream(socket.getInputStream());

                // 因为序列化流对发送数据的顺序严格要求，因此需要参照发送顺序取
                String serviceName = objInput.readUTF();
                String methodName = objInput.readUTF();
                Class[] paraTypes = (Class[]) objInput.readObject();
                Object[] args = (Object[]) objInput.readObject();
                // 根据客户请求, 到map 中找到与之对应的接口

                Class serviceClass = serviceRegisterMap.get(Class.forName(serviceName));
                Method method = serviceClass.getMethod(methodName, paraTypes);
                Object result = method.invoke(serviceClass.newInstance(), args);

                // 向客户端发送执行结果
                objOutput = new ObjectOutputStream(socket.getOutputStream());
                objOutput.writeObject(result);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

                try {
                    if (objInput != null) {
                        objInput.close();
                    }
                    if (objOutput != null) {
                        objOutput.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }*/

    @Override
    public void stop() {
        isRunning = false;
        executor.shutdown();
    }

    @Override
    public void register(Class serviceInterface, Class impl) {
        serviceRegisterMap.put(serviceInterface, impl);

    }


}

