package com.base;

import java.util.Scanner;

/**
 * Created by Brian in 18:15 2018/11/14
 */
public class SwitchTest {
    public static void main(String[] args) {
//        根据键盘输入的值判断是一年中的多少天
        Scanner scanner = new Scanner(System.in);
        int month = scanner.nextInt();
        int day = scanner.nextInt();
        int sum = 0;
        switch (month) {
            case 12:
                sum += 30;
            case 11:
                sum += 31;
            case 10:
                sum += 30;
            case 9:
                sum += 31;
            case 8:
                sum += 31;
            case 7:
                sum += 30;
            case 6:
                sum += 31;
            case 5:
                sum += 30;
            case 4:
                sum += 31;
            case 3:
                sum += 28;
            case 2:
                sum += 31;
            case 1:
                sum += day;
                break;
        }
        System.out.println("sum == "+sum);
    }
}
