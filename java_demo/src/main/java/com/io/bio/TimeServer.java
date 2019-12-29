package com.io.bio;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


/**
 * Created by Brian in 18:12 2018/4/25
 */
public class TimeServer {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(TimeServer.class);

    public static void main(String[] args) {
        int port = 9030;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            log.info("[server] is listening port " + port);
            Socket socket = null;

            while (true) {
                // 当没有客户端连接时，程序会阻塞在accept这里，当有客户端访问时，就会创建新的线程去重新执行
                socket = serverSocket.accept();
                // 每有一个客户端访问，就添加一个线程执行
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(serverSocket !=null){
                try {
                    serverSocket.close();
                    log.info("[server] close");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket =null;
            }
        }
    }

}
