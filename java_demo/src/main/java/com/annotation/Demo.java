package com.annotation;

import com.annotation.brianAnnotation.Description;
import com.annotation.service.Person;
import com.annotation.service.impl.Child;

/**
 * Created by Brian in 17:22 2018/3/9
 */
public class Demo {
    @SuppressWarnings("deprecation")
    public void sing() {
        Person p = new Child();
        p.sing();
    }

    @Description(desc = "I am eyeColor", author = "Brian", age = 18)
    public String eyeColor() {
        return "red";
    }

    public static void main(String[] args) {

        whileTest();
       /* int c = 5;
        System.out.println(c <<= 2);
        System.out.println(sum(5));*/
    }


    public static int sum(int n) {
        if (n > 0) {
            return n + sum(--n);
        }
        return 0;

    }

    public static void whileTest() {
        int x = 10;
        while (x < 20) {
            System.out.println(x);
            x++;
        }
        System.out.println("=== do while ===");
        do {
            System.out.println(x);
            x++;
        } while (x < 30);
    }

}
