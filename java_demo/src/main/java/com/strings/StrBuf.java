package com.strings;

/**
 * Created by Brian in 23:17 2018/11/24
 */
public class StrBuf {
    public static void main(String[] args) {
        StringBuffer sbf = new StringBuffer("hello");
        sbf.append("abcd");
        sbf.reverse();
        System.out.println(sbf);

        long start = System.currentTimeMillis();
        String str = "";
        for (int i = 0; i < 30000; i++) {
            str += i;
        }
        long end = System.currentTimeMillis();

        System.out.println(end-start);
    }
}
