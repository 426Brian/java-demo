package com.study.test;

/**
 * Created by Brian in 14:13 2018/3/13
 */
public class Demo {
    public static void main(String[] args){
        Animal animal = new Dog();

        System.out.println("animal == "+animal.name);

        Animal animal2 = animal;
        animal.name = "dog1";

       /* System.out.println("animal == "+animal.name);
        System.out.println("animal2 == "+animal2.name);

        System.out.println(animal == animal2);*/

        int a = 10;
        int b = a;
        System.out.println("a == "+a);
        System.out.println("b == "+b);
        a = 3;
        System.out.println();
        System.out.println("a == "+a);
        System.out.println("b == "+b);
    }
}
