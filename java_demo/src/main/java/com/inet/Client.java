package com.inet;

import java.io.*;
import java.net.Socket;

/**
 * Created by Brian in 18:49 2018/1/29
 */
public class Client {
    public static void main(String[] args){
        // 1. 创建客户端Socket
        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);

            // 2. 获取输出端向服务器发出请求
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write("name: admin, password: 123");
            pw.flush();
            socket.shutdownOutput();

            // 3. 获取输入端读取服务器端做出的响应
            InputStream is = socket.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br = new BufferedReader(isr);
            String info = null;

            while((info = br.readLine()) != null){
                System.out.println("我是客户端 === 服务器端响应信息 === "+info);

            }
            socket.shutdownInput();

            // 4. 关闭资源
            br.close();
            isr.close();
            is.close();

            pw.close();
            os.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
