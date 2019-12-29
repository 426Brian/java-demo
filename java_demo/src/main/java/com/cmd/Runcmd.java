package com.cmd;


import java.io.*;

/**
 * Created by Brian in 17:02 2018/3/22
 */
public class Runcmd {
    private static final String CMD = "cmd /c start ";


    public static void main(String[] args){
        String filepath = Runcmd.class.getResource("").getPath().substring(1)+"closejdk.bat";

        Runtime rt = Runtime.getRuntime();

        Process ps = null;
        try {
            ps = rt.exec(CMD+filepath);
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
