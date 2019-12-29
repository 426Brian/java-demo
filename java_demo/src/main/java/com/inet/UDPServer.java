package com.inet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * Created by Brian in 23:00 2018/1/30
 */
public class UDPServer {
    public static void main(String[] args){
        // 1. 创建数据报Socket, 指定要监听的端口
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(8800);

            // 2. 创建数据报包，用于接收客户端发送的数据报
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);

            // 3. 等待接收客户端发送的数据报, receive()放在未接收到数据前处于阻塞状态
            System.out.println("*** 服务器端已启动， 等待客户端发送数据 ***");
            socket.receive(packet);

            // 4. 读取接收到的数据报信息
            String info = new String(data, 0, packet.getLength());
            System.out.println("我是服务器端 === 客户端发送的信息 === "+info);

            // 5. 响应客户端
            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            byte[] data2 = "欢迎您".getBytes();

            DatagramPacket packet2 = new DatagramPacket(data2, data2.length, address, port);
            socket.send(packet2);

            socket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
