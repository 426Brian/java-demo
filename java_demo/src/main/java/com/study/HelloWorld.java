package com.study;

/**
 * Created by Brian in 18:35 2018/3/12
 */
public class HelloWorld {
    public static void main(String[] args){
     /*   System.out.println("Hello World.");
        test();
        System.out.println(" == "+HelloWorld.class.getResource(""));
        System.out.println(" == "+HelloWorld.class.getResource("/"));
        System.out.println(" == "+HelloWorld.class.getPackage());




        System.out.println("= JavaInfo "+new JavaInfo().hashCode());
        System.out.println("= JavaInfo "+new JavaInfo().hashCode());

        Integer a = 127;
        Integer b = 127;
        System.out.println("a == b "+(a == b));

        Integer c = 128;
        Integer d = 128;
        System.out.println("c == d "+(c == d));*/

        String str1 = "123";
        String str2 = new String("123");
        System.out.println("= str1 "+str1.hashCode());
        System.out.println("= str2 "+str2.hashCode());

        System.out.println(str1 == str2);

    }

    public static void test(){
        System.out.println("== test ==");
        return;
    }
}