package com.url;


import org.springframework.util.StreamUtils;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by Brian in 4:32 2018/12/7
 */
public class WeatherUtils {

    public static String sendHttpRequest(String urlStr, Map map) {
        // 1. 定义需要访问的地址
        URL url = null;
        String responseStr = null;
        try {
            url = new URL(urlStr);
            // 2. 开启连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            // 3. 设置请求方式
            conn.setRequestMethod("POST");

            // 4. 需要输出参数
            StringBuffer params = new StringBuffer();
            if(params != null){
                Iterator iter = map.entrySet().iterator();
                int i = 1;
                while(iter.hasNext()){
                    Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                    if(i==1){
                        params.append(entry.getKey()+"="+entry.getValue());
                    }else{
                        params.append("&"+entry.getKey()+"="+entry.getValue());
                    }
                    i++;

                }
            }


            // 5. 写出参数
            conn.setDoOutput(true);
            conn.setDoInput(true);
            OutputStream outStream =conn.getOutputStream();
            outStream.write(params.toString().getBytes(Charset.forName("utf-8")));
            outStream.flush();
            outStream.close();


            // 7. 接收对方响应
            responseStr = StreamUtils.copyToString(conn.getInputStream(), Charset.forName("utf-8"));

            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return responseStr;
    }

}
