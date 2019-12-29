package com.strings;

/**
 * Created by Brian in 20:38 2018/10/21
 */
public class Demo {
    public static void main(String[] args) {
        String str = new String("ab");
        str +=str;
        System.out.println(str);

        StringBuffer sbf = new StringBuffer("abdag4gyl");
        sbf.reverse();
        System.out.println(sbf);

        test();
    }

    public static void test(){
        while(true){
            Demo demo = new Demo();
            System.out.println(demo.toString());
        }
    }
}
