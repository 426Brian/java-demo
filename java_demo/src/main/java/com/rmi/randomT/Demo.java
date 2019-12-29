package com.rmi.randomT;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Brian in 0:15 2018/11/25
 */
public class Demo {
    public static void main(String[] args) {
        Random random = new Random();
        int[] arr = new int[7];
        int foot = 0;

        while (foot < 7){
            int t = random.nextInt(37);
            if(!isRepeat(arr, t)){
                arr[foot++] = t;
            }
        }

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static boolean isRepeat(int[] tmp, int num) {
        if (num == 0) {
            return true;
        }
        for (int i = 0; i < tmp.length; i++) {
            if(tmp[i] == num){
                return true;
            }
        }

        return false;
    }
}
