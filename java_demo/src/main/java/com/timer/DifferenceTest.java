package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Brian in 23:21 2018/1/24
 */
public class DifferenceTest {
    public static void main(String[] args) throws InterruptedException {
        final SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();

//        当前时间
        System.out.println("Current time is: "+sf.format(calendar.getTime()));
        /**
         * 设置成6秒前的时间 若当前时间为2016-12-12 00:00:06,
         * 设置后的时间为2016-12-12 00:00:00
         */
        calendar.add(Calendar.SECOND, -6);
        System.out.println("(changed)Current time is: "+sf.format(calendar.getTime()));
        Timer timer = new Timer();
//        第一次执行时间为6秒前，之后每隔两秒钟执行一次
        //scheduleAtFixedRate
        timer.scheduleAtFixedRate(new TimerTask(){

            @Override
            public void run() {
//                try {
//                    Thread.sleep(3000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                当前执行时间
                System.out.println("Scheduled time is: "+sf.format(scheduledExecutionTime()));
                System.out.println("Task is being executed!");
            }
        }, calendar.getTime(), 2000L);

        Thread.sleep(15000L);
        timer.cancel();
    }
}
