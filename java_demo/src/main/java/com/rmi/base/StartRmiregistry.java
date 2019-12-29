package com.rmi.base;



import java.io.File;
import java.io.IOException;

/**
 * 通过cmd 命令开启 rmiregistry 注册表
 * Created by Brian in 21:06 2018/5/16
 */
public class StartRmiregistry {
    public static void main(String[] args) throws Exception {
        Runtime runtime = Runtime.getRuntime();

        String cmd_start = " cmd /c start ";
        String startRmiregistry = "start rmiregistry";

        String classpath = StartRmiregistry.class.getResource("/").getFile();
        System.out.println(classpath);
        Process process = null;
        try {
            process = runtime.exec(cmd_start + startRmiregistry, null, new File(classpath));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
