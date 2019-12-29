package com.base;


import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 14:10 2018/11/19
 */
public class Test {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(Test.class);


    public static void main(String[] args) {
        String str = "hello world, good morning";
        String[] arr = str.replace(",", " ,").split(" ");
        StringBuffer sbf = new StringBuffer();
        for (int i = arr.length - 1; i >= 0; i--) {
            sbf.append(arr[i] + " ");
        }

        System.out.println(sbf.toString().replace(" ,", ","));
        log.info("Character.MAX_VALUE == "+Character.MAX_VALUE);
        log.info("Character.MIN_VALUE == "+Character.MIN_VALUE);
        log.info("Byte.MAX_VALUE == "+Byte.MAX_VALUE);
        log.info("Byte.MIN_VALUE == "+Byte.MIN_VALUE);
        log.info("Short.MAX_VALUE == "+Short.MAX_VALUE);
        log.info("Short.MAX_VALUE == "+Short.MIN_VALUE);
        log.info("Integer.MAX_VALUE == "+Integer.MAX_VALUE);
        log.info("Integer.MIN_VALUE == "+Integer.MIN_VALUE);
        log.info("Long.MAX_VALUE == "+Long.MAX_VALUE);
        log.info("Long.MAX_VALUE == "+Long.MIN_VALUE);
        log.info("Float.MAX_VALUE == "+Float.MAX_VALUE);
        log.info("Float.MIN_VALUE == "+Float.MIN_VALUE);
        log.info("Double.MAX_VALUE == "+Double.MAX_VALUE);
        log.info("Double.MAX_VALUE == "+Double.MIN_VALUE);



    }
}
