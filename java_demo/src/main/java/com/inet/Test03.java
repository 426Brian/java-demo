package com.inet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Brian in 0:02 2018/1/28
 */
public class Test03 {
    public static void main(String[] args){
        try {
            // 创建URL 实例
            URL url = new URL("http://www.baidu.com");

            // 通过URL 的openStream 方法获取URL 对象所表示的资源的字节输入流
            InputStream is = url.openStream();

            // 将字节输入流转换成字符输入流
            InputStreamReader isr = new InputStreamReader(is);
            // 为字符输入流添加缓冲
            BufferedReader br = new BufferedReader(isr);
            // 读取数据
            String data = br.readLine();
            while(data != null){
                System.out.println(data);
                data = br.readLine();
            }

            br.close();
            isr.close();
            is.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
