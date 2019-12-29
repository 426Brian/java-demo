package com.multiThread.base;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 22:17 2018/11/23
 */
public class Count {
    private static final Log4JLogger logger = (Log4JLogger) LogFactory.getLog(Count.class);
    private static volatile int count;

    public static synchronized void add() {
        count++;
        logger.info(Thread.currentThread().getName() + ": " + count);
    }
}
