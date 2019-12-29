package com.multiThread.thread;


import com.designPattern.old.filter.Person;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.logging.impl.Log4JLogger;

/**
 * Created by Brian in 19:14 2018/11/24
 */
public class Demo implements Runnable {
    private static final Log4JLogger log = (Log4JLogger) LogFactory.getLog(Demo.class);

    @Override
    public void run() {
        testDemo();
    }

    public static void main(String[] args) {
        Demo demo = new Demo();

        Thread th1 = new Thread(demo);
        Thread th2 = new Thread(demo);
        Thread th3 = new Thread(demo);
        Thread th4 = new Thread(demo);

        th1.start();
        th2.start();
        th3.start();
        th4.start();

        Tes tes = new Tes();
        Tes2 tes2 = new Tes2(tes);
        Tes2 tes3 = new Tes2(tes);
        Tes2 tes4 = new Tes2(tes);

        tes2.tes.testDemo();
        tes3.tes.testDemo();
        tes4.tes.testDemo();
    }

    public void testDemo(){
        Person person = new Person();
//        log.info(person.hashCode());
    }


}

class Tes {
    public void testDemo(){
        Person person = new Person();
        System.out.println(person.hashCode());
    }
}

class Tes2 {
    public Tes tes;

    public Tes2(Tes tes) {
        this.tes = tes;
    }
}