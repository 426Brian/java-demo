package com.study;

import java.util.Date;

public class Main {
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            System.out.println(new Date());
            try{
                Thread.sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }



    }



    public int demo(int a, String b, boolean c){
        /**
         * @description:
         * @params: [a, b, c]
         * @return: int
         * @author: Brian
         * @date: 2017/12/29 19:21
         */

        return 0;
    }
}
