package com.io.bio;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Brian in 21:51 2018/4/25
 */
public class TimeServerHandler implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(TimeServer.class);
    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;


        try {
            // 获取输入流
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            // 构造输出流
            out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

            String body = null;
            String str = null;
            Scanner sc = new Scanner(System.in);

            while (true) {
                str = sc.nextLine();
                while (str != null) {
                    body = in.readLine();
                    if (body == null) {
                        break;
                    }
                    log.info("[server] receive == " + body);

                    out.println(str);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if (out != null) {
                out.close();
                out = null;
            }
            if (this.socket != null) {
                try {
                    socket.close();
                    socket = null;
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}
