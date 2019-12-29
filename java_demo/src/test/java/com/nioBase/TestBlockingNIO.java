package com.nioBase;

import org.junit.Test;

import java.io.File;
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
public class TestBlockingNIO {
    private static final String FILE_PATH = System.getProperty("user.dir") + "/file_dir";

    // 客户端
    @Test
    public void client() throws IOException {
        // 1. 打开网络连接
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9898));

        // 2. 要发送的本地文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get(FILE_PATH, "testin.txt"), StandardOpenOption.READ);

        // 3. 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 发送数据
        while (fileChannel.read(buffer) > 0) {
            buffer.flip();
            socketChannel.write(buffer);
            buffer.clear();
        }

        // 5. 关闭通道
        socketChannel.close();
        fileChannel.close();
    }

    // 服务器端
    @Test
    public void server() throws IOException {
        // 1. 打开服务器端
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(9898));
        SocketChannel socketChannel = serverSocketChannel.accept();

        // 2. 要写到本地的文件通道
        FileChannel fileChannel = FileChannel.open(Paths.get(FILE_PATH, "testin3.txt"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        // 3. 缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);

        // 4. 将接收到的文件写入本地文件
        while (socketChannel.read(buffer) > 0) {
            buffer.flip();
            fileChannel.write(buffer);
            buffer.clear();
        }

        // 5. 关闭通道
        serverSocketChannel.close();
        socketChannel.close();
        fileChannel.close();
    }
}
