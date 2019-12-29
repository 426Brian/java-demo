package com.study.test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Brian in 22:42 2018/3/26
 */
public class DeleteFile {
    private static final String BASE_PATH = "E:\\Brian\\maven\\localRepo\\org\\springframework";
    private static int num = 0;
    private static ArrayList<String> list = new ArrayList();
    private static String str;
    private static String CMD = "cmd /c ";
    private static String d_dr = "rd/s/q ";
    private static Runtime runtime = Runtime.getRuntime();

    public static void main(String[] var0) {
        deleteDir(BASE_PATH, "5.0.2.RELEASE");
        for(String str : list){
            System.out.println(str);
        }

    }

    public static ArrayList<String> deleteDir(String basePath, String name) {
        File file = new File(basePath);
        if (file.isDirectory() && file.listFiles().length > 0) {
            File[] files = file.listFiles();

            for(File fileT : files) {

                if (fileT.isDirectory()) {
                    if (name.equals(fileT.getName())) {
                        str = "[" + ++num + "]" + fileT.getAbsolutePath();
                        System.out.println(CMD+(d_dr+fileT.getAbsolutePath()));
                        try {
                            runtime.exec(CMD+(d_dr+fileT.getAbsolutePath()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        list.add(str);

                    }

                    deleteDir(fileT.getAbsolutePath(), name);
                }
            }
        }

        return list;
    }
}
