package com.inet;

import java.io.IOException;
import java.net.*;

/**
 * Created by Brian in 23:00 2018/1/30
 */
public class UDPClient {
    public static void main(String[] args){
        // 1. 定义要发送的数据报包
        byte[] data = "name: admin, password: 123".getBytes();
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
            int port = 8800;

            DatagramPacket packet = new DatagramPacket(data, data.length, address, port);

            // 2. 创建数据报包对象，发送数据报包
            DatagramSocket socket = new DatagramSocket();
            socket.send(packet);

            // 3. 接收服务器的响应
            byte[] data2 = new byte[1024];

            DatagramPacket packet2 = new DatagramPacket(data2, data2.length);
            socket.receive(packet2);
            String info = new String(data2, 0, packet2.getLength());
            System.out.println("我是客户端 === 服务器说 === "+info);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
