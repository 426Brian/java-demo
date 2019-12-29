package com.study.order;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Brian in 0:16 2018/3/23
 */
public class OrderTest {
    public static void main(String[] args){
        Random rd = new Random();
        int[] arr = new int[20];
        for(int i = 0; i < arr.length; i++){
            arr[i] = rd.nextInt(50);
        }
        System.out.println(Arrays.toString(arr));
        arr = buddle(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static int[] buddle(int[] arr){
        int tmp = 0;
        for(int i = 0; i < arr.length -1; i++){
            for(int j = i+1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;

                }
            }

        }

        return arr;
    }
}
