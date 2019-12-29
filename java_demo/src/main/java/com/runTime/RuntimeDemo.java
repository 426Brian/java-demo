package com.runTime;

import java.io.IOException;

/**
 * Created by Brian in 23:30 2018/11/24
 */
public class RuntimeDemo {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("maxMemory == "+runtime.maxMemory()/(1024*1024*1024)+"G");
        System.out.println("totalMemory == "+runtime.totalMemory()/(1024*1024)+"M");
        System.out.println("freeMemory == "+runtime.freeMemory()/(1024*1024)+"M");

        String str = "";
        for (int i = 0; i < 1000 ; i++) {
            str += i;
        }
        System.out.println("2maxMemory == "+runtime.maxMemory()/(1024*1024*1024)+"G");
        System.out.println("2totalMemory == "+runtime.totalMemory()/(1024*1024)+"M");
        System.out.println("2freeMemory == "+runtime.freeMemory()/(1024*1024)+"M");

        // 释放垃圾空间
        runtime.gc();

        System.out.println("3maxMemory == "+runtime.maxMemory()/(1024*1024*1024)+"G");
        System.out.println("3totalMemory == "+runtime.totalMemory()/(1024*1024)+"M");
        System.out.println("3freeMemory == "+runtime.freeMemory()/(1024*1024)+"M");


//        用runtime 打开画板进程, 2s 后关闭
        Process process = null;
        try {
            // 处理进程
            process =  runtime.exec("mspaint.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //
        process.destroy();
    }
}
