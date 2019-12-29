package com.exception.base;

import java.util.Scanner;

/**
 * Created by Brian in 14:45 2018/11/6
 */
public class Demo {
    public static void main(String[] args) {
        int result = try3();
        System.out.println("result == " + result);
    }

    public static void try1() {
        try {
            System.out.println("请输入年龄");
            Scanner intput = new Scanner(System.in);
            int age = intput.nextInt();
        } catch (Exception e) {
            System.out.println("你输入的不是整数");
        }
        System.out.println("结束== ");
    }

    public static int try2() {
        int divider = 10;
        int result = 100;
        try {
            while (divider > -1) {
                divider--;
                result += 100 / divider;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("循环出现异常了");
            return result;
        }
    }

    public static int try3() {
        int divider = 10;
        int result = 100;
        try {
            while (divider > -1) {
                divider--;
                result += 100 / divider;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return result;
        } finally {
            System.out.println("这是finally");
            return result = 999;

        }

    }

}
