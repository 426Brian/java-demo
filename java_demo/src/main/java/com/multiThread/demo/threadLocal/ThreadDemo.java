package com.multiThread.demo.threadLocal;

import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Brian in 22:09 2018/4/29
 */
public class ThreadDemo {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(ThreadDemo.class);

    public static void main(String[] args) {
        log.info("Random integer " + new Random().nextInt());
        log.info("Seeded integer " + new Random(15).nextInt());
        log.info("ThreadLocalRandom integer " + ThreadLocalRandom.current().nextInt());
        final ThreadLocalRandom random = ThreadLocalRandom.current();
        random.setSeed(15);
        log.info("Seeded ThreadLocalRandom integer " + random.nextInt());
    }
}
