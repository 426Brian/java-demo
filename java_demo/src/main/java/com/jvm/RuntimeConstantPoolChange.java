package com.jvm;

/**
 * Created by Brian in 16:59 2018/5/31
 */
public class RuntimeConstantPoolChange {
    public static void main(String[] args) {
        String str = new StringBuilder("Jvm").append(" RuntimeConstantPool test").toString();
        System.out.println("intern == "+str.intern() == str);

        String str2 = new StringBuilder("java").toString();
        System.out.println("str2 intern == "+str2.intern() == str2);
    }
}
