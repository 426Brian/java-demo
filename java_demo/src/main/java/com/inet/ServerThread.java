package com.inet;

import java.io.*;
import java.net.Socket;

/**
 * Created by Brian in 2:24 2018/1/30
 */
public class ServerThread extends Thread {
    // 和本线程相关的socket
    Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        OutputStream os = null;
        PrintWriter pw = null;

        try {
            if (socket != null) {
                // 获取输入流读取客户端请求信息
                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                String info = null;

                while ((info = br.readLine()) != null) {
                    System.out.println("我是服务器端 === 读取到的客户端信息 === " + info);
                }
                socket.shutdownInput();

                // 获取输出流，对客户端做出响应
                os = socket.getOutputStream();
                pw = new PrintWriter(os);
                pw.write("访问成功");
                pw.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭资源
                pw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
