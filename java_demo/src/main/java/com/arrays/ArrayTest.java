package com.arrays;

import java.util.*;

/**
 * Created by Brian in 22:54 2018/11/14
 */
public class ArrayTest {
    private String a;
    private String b;
    public ArrayTest(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public static void main(String[] args) {
        mapTest();

        Generic generic = new Generic();
        System.out.println((Integer) generic.getT2());

        int a = 0;
        String b = "3";
        
    }

    public static void test3(int a, String b) {

    }

    public static void copyTest() {
        int[] arr1, arr2;
        arr1 = new int[]{2, 3, 5, 7, 9, 11, 13, 15, 17};
        for (int i = 0; i < arr1.length; i++) {
//            System.out.print(arr1[i]+"\t");
        }

        // arr2 变量跟arr1 指向同一个对象
        arr2 = arr1;
        // 利用克隆
        arr2 = arr1.clone();
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = i;
        }
        System.out.println("arr1 反转前= " + Arrays.toString(arr1));
        System.out.println("arr2 = " + Arrays.toString(arr2));

        int tmp;
        for (int i = 0, j = arr1.length - 1; i < j; i++, j--) {
            tmp = arr1[j];
            arr1[j] = arr1[i];
            arr1[i] = tmp;
        }

        System.out.println("arr1 反转后= " + Arrays.toString(arr1));
    }

    /**
     * 杨辉三角
     * 1
     * 1 1
     * 1 2 1
     * 1 3 3 1
     * 1 4 6 4 1
     * 1 5 10 10 5 1
     */
    public static void triangle() {
       /* int[][] tringle = new int[10][];
        // 初始化二位数组
        for (int i = 0; i < tringle.length; i++) {
            tringle[i] = new int[i + 1];
        }
        // 显示的为二位数组的每个元素赋值
        for (int i = 0; i < tringle.length; i++) {
            for (int j = 0; j < tringle[i].length; j++) {
                tringle[i][0] = 1;
                tringle[i][i] = 1;
                if (i > 1 && j > 0 && j < i) {
                    tringle[i][j] = tringle[i - 1][j] + tringle[i - 1][j - 1];
                }
            }
        }

        for (int[] a : tringle) {
            System.out.println(Arrays.toString(a));
        }
        */
        int[][] arr = new int[10][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new int[i + 1];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][0] = 1;
            arr[i][i] = 1;
            for (int j = 0; j < arr[i].length; j++) {
                if (i > 1 && j > 0 && j < i)
                    arr[i][j] = arr[i - 1][j] + arr[i - 1][j - 1];
            }
        }
        for (int[] i : arr) {
            System.out.println(Arrays.toString(i));
        }

    }

    public static void testList() {
        List list = new ArrayList();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }

        Collections.sort(list);
        Collections.reverse(list);
        System.out.println(list);
    }

    public static void mapTest() {
        Map map = new HashMap();
        map.put(1, 2);
        map.put(3, 5);
        map.put(2, 8);
        map.put(5, 7);
        map.put(4, 6);
        map.put(9, 2);

        map.keySet().iterator();

        List list = new ArrayList();
        List<?> list_g = new ArrayList();
        List<Object> list1 = new ArrayList();
        List<String> list2 = new ArrayList();
        list = list2;
        list_g = list2;
    }

    static class Generic<E> {
        public <T> T getT(T t) {
            return t;
        }

        public <T> T getT2() {
            Object obj = new Integer(1);
            return (T) obj;
        }
    }

    class SubGeneric<E> extends Generic<E> {

    }
}
