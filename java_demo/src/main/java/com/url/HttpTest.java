package com.url;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brian in 4:32 2018/12/7
 */
public class HttpTest {
    public static void main(String[] args) throws Exception {
        Map<String, String> map = new HashMap();

        map.put("city", "shenzhen");
        map.put("appkey", "ffab9ebe7b1655fc0a64bbebda33db8e");

        String url = "https://way.jd.com/he/freeweather";
        String responseStr = WeatherUtils.sendHttpRequest(url, map);

        System.out.println(responseStr);

    }


}
