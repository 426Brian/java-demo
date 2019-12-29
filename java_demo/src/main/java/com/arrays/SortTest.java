package com.arrays;

import java.util.Arrays;

/**
 * Created by Brian in 12:30 2018/11/15
 */
public class SortTest {
    public static void main(String[] args) {

        bubble();
    }

    /**
     * 直接选择排序
     */
    private static void selectSort() {
        int[] arr = new int[]{15, 2, 7, 9, 3, 5, 13, 11, 21, 17, 23};
        int tmp;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                // arr[i] < arr[j] 倒序排
                if (arr[i] > arr[j]) {
                    tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     *
     */

    public static void bubble() {
        int[] arr = new int[]{15, 2, 7, 9, 3, 5, 13, 11, 21, 17, 23};
        int tmp;
        for (int i = 0; i < arr.length -1; i++) {
            for(int j = 0; j< arr.length -1-i ;j++){
                if(arr[j] > arr[j+1]){
                    tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    /**
     * 最大值放在数组的末尾索引处
     */
    public static void useMax() {
        int[] arr = new int[]{15, 2, 7, 9, 3, 5, 13, 11, 21, 17, 23};

        int lng = arr.length;
        int max = 0;
        int index = -1;
        int tmp;
        int times = 1;

        while (times < lng) {
            for (int i = 0; i <= lng - times; i++) {
                max = max > arr[i] ? max : arr[i];
            }

//            System.out.println(times +" == "+ max);
            for (int i = 0; i <= lng - times; i++) {
                index = max == arr[i] ? i : -1;
                if (index > -1) {
                    break;
                }
            }

            if (index != lng - times) {
                tmp = arr[lng - times];
                arr[lng - times] = max;
                arr[index] = tmp;
            }
            times++;
            max = 0;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void reverse() {
        int[] arr = new int[]{15, 2, 7, 9, 3, 5, 13, 11, 21, 17, 23};
        int tmp;
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;

        }
        System.out.println(Arrays.toString(arr));

    }


}
