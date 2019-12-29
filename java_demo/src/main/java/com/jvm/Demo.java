package com.jvm;

/**
 * Created by Brian in 17:45 2018/11/22
 */
public class Demo {
    private int i = 1;
    public void test(){
      i++;
      test();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        try {
            demo.test();
        } catch (Throwable e) {
            System.out.println("demo.i == "+demo.i);
            e.printStackTrace();
        }
    }
}
