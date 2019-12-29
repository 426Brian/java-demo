package com.io.bio;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.*;
import java.net.Socket;

/**
 * Created by Brian in 22:04 2018/4/25
 */
public class TimeClient {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(TimeClient.class);

    public static void main(String[] args) {
        int port = 9030;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        String res = null;
        try {
            while(true){
                socket = new Socket("127.0.0.1", port);

                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

                // 发送请求
                out.println("[client] this is request from client");

                // 获得响应
                res = in.readLine();
                log.info("[client] reveive res == "+res);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(socket !=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }
    }
}
