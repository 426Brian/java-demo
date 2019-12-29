package com.nioBase;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Brian in 22:56 2018/11/25
 */
public class TestBlockingNIO2 {
    private static final String FILE_PATH = System.getProperty("user.dir")+"/file_dir";

    // 客户端
    @Test
    public void client() throws IOException {
        // 1. 打开网络连接
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9898));

        // 2. 要发送的本地文件连接
        FileChannel fileChannel = FileChannel.open(Paths.get(FILE_PATH, "testin.txt"), StandardOpenOption.READ);

        // 3. 存储信息的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 发送信息
        while(fileChannel.read(buffer) > 0){
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }
        // 5. 已经发送完成
        socketChannel.shutdownOutput();

        // 6. 接收服务器端响应
        int len = 0;
        while((len = socketChannel.read(buffer)) > 0){
            buffer.flip();
            System.out.println("client accepts from server: "+new String(buffer.array(), 0, len));
            buffer.clear();
        }

        //  6. 关闭连接
        socketChannel.close();
        fileChannel.close();

    }

    // 服务器端
    @Test
    public void server() throws IOException {

        // 1. 打开网络连接
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9898));

        SocketChannel socketChannel = serverSocketChannel.accept();

        // 2. 本地文件连接
        FileChannel fileChannel = FileChannel.open(Paths.get(FILE_PATH, "testin3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 3. 存储信息的缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 接收读取客户端信息并写入
        while(socketChannel.read(buffer) > 0){
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        socketChannel.shutdownInput();

        // 5. 发送响应到客户端
        buffer.put("response from server".getBytes());
        buffer.flip();
        socketChannel.write(buffer);


        // 3. 关闭连接
        serverSocketChannel.close();
        socketChannel.close();
        fileChannel.close();


    }
}
