package com.base;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Brian in 18:25 2018/11/14
 */
public class LoopTest {
    public static void main(String[] args) {
        prime();
    }


    public static void test1() {
        for (int i = 1; i <= 150; i++) {
            System.out.print(i + " = ");
            if (i % 3 == 0) {
                System.out.print("foo ");
            }
            if (i % 5 == 0) {
                System.out.print("biz ");
            }
            if (i % 7 == 0) {
                System.out.print("baz");
            }
            System.out.println();
        }
    }

    //    水仙花数字 一个三位数, 各个位上数字立方和等于其本身
    public static void test2() {
        int j = 0, k = 0, m = 0;

        for (int i = 100; i < 999; i++) {

            j = Integer.parseInt((i + "").substring(0, 1));
            k = Integer.parseInt((i + "").substring(1, 2));
            m = Integer.parseInt((i + "").substring(2, 3));
//            System.out.println(j+" = "+j+", "+k+" = "+k+", "+m+" = "+m);

            if (i == j * j * j + k * k * k + m * m * m) {
                System.out.println("水仙花数字 =" + i);
            }
        }
    }

    public static void whileTest() {
        int i = 1;
       /* while (i <= 100) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        }*/

        do {
            if (i % 2 == 0) {
                System.out.println(i);
            }
            i++;
        } while (i <= 100);

    }

    /**
     * 打印菱形
     * ----*-
     * ---*-*-
     * --*-*-*-
     * -*-*-*-*-
     * -*-*-*-*-
     * -*-*-*-*-
     * --*-*-*-
     * ---*-*-
     * ----*-
     */
    public static void forTest() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
//        System.out.println("===========");
        for (int i = 3; i >= 0; i--) {
            for (int j = 0; j < 4 - i; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i + 1; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }

    /**
     * 乘法口诀
     */
    public static void multiplicative() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();

        }
    }

    /**
     * 100 以内的质数
     */
    public static void prime() {
        boolean flag = false;
        long start = System.currentTimeMillis();

        for (int i = 2; i <= 100; i++) {
            flag = false;
            for (int j = i - 1; j > 2; j--) {
                if (i % j == 0) {
                    flag = true;
                    break;
                }
            }

            if (!flag) {
                System.out.print(i + "\t");
            }

        }
        long end = System.currentTimeMillis();
        System.out.println();
        System.out.println("用时 == " + (end - start) + "ms");

    }

    public static void testMax() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生数量");
        int num = scanner.nextInt();
        int[] scores = new int[num];
        int tmp = 0;
        for (int i = 0; i < num; i++) {
            scores[i] = scanner.nextInt();
            tmp = scores[i] > tmp ? scores[i] : tmp;
        }

        System.out.println(Arrays.toString(scores));
        System.out.println("最高成绩为" + tmp);
    }

}
