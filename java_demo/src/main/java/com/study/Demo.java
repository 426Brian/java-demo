package com.study;

/**
 * Created by Brian in 15:22 2018/4/1
 */
public class Demo {
    private int t;
     {
         System.out.println("aa");
        int a = 0;
        t = 3;
    }

    public static void main(String[] args) {
        Demo d = new Demo();
        System.out.println(d.t);


      /*  int[] arr = {89, -23, 64, 91, 119, 52, 73};
        Arrays.sort(arr);

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i > 0 && i <= 100) {
                list.add(i);
            }
        }

        System.out.println(list);


        double avg1 = 78.5;
        int rise = 5;
        int avg2 = (int) (avg1 + rise);
        System.out.println("考试平均分：" + avg1);
        System.out.println("调整后的平均分：" + avg2);*/
    }
}
