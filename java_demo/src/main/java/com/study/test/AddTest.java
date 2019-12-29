package com.study.test;

/**
 * 功能： 为指定的成绩进行加分，分数大于等于60分为止，
 * 输出加分前的成绩和加分后的成绩，并且统计加分的次数
 * <p>
 * Created by Brian in 18:42 2018/3/12
 */
public class AddTest {
    public static void main(String[] args) {
        int score = 53;
        int count = 0;
        System.out.println("=== before score  == " + score);
        while(score < 60){
            score++;
            count++;
        }
        System.out.println("=== after score  == " +score);
        System.out.println("===加的次数 === " + count);
    }
}
