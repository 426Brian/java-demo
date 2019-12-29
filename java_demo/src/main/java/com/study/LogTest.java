package com.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Brian in 17:58 2018/1/2
 */
public class LogTest {
    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    public static void main(String[] args){
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");

    }
}
