package com.study;

/**
 * Created by Brian in 15:52 2018/4/1
 */
public class Test {
    public static void main(String[] args){
        int count = 0;
        float score = 51.2f;
        System.out.println("before = "+score);
        for(;score < 60f;score++){
            count++;
        }

        System.out.println("after = "+score+" count = "+count);

        float a = 0.2f;
        int b = 3;
        float c = a+b;
        System.out.println("c = "+  Integer.MAX_VALUE);

        String[][] names={{"tom","jack","mike"},{"zhangsan","lisi","wangwu"}};
        String[][] arr = new String[2][3];


        for(int i = 0; i < names.length; i++){
            for(int j = 0; j < names[i].length; j++){
                arr[i][j] = names[i][j];
            }
        }
    }
}
