package com.cmd;

import java.io.*;

/**
 * Created by Brian in 1:11 2018/3/24
 */
public class Shutdown {
    private static final String CMDBAT = "cmd /c start ";


    public static void main(String[] args){
        String filepath = new File("C:\\Users\\Brian\\Desktop\\shutdown.bat").toString();

        Runtime rt = Runtime.getRuntime();

        Process ps = null;
        try {
            ps = rt.exec(CMDBAT+filepath);
            InputStream inputStream = new FileInputStream(new File(filepath));
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String str;

            while((str = reader.readLine())!= null){
                System.out.println(str);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
