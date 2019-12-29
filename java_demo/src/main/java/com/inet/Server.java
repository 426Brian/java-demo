package com.inet;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Brian in 18:49 2018/1/29
 */
public class Server {
    public static void main(String[] args){
        // 1. 创建服务器端Socket, 即ServerSocket
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8888);

            System.out.println("服务器正在监听端口：8888, 等待客户端请求");
            int count = 0;
            while(true){
                // 2. 调用accept()方法，监听端口
                Socket socket = serverSocket.accept();

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
                count++;
                System.out.println("客户端数量 === "+count);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
