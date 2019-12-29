package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Brian in 20:29 2018/1/24
 */
public class MyTimer {
    public static void main(String[] args) throws InterruptedException {
        Timer timer = new Timer();
        MyTimerTask myTimerTask = new MyTimerTask("NO.1", 2000);
        MyTimerTask myTimerTask2 = new MyTimerTask("NO.2", 2000);
        /**
         * 两秒后每隔一秒执行myTimerTask
         */
//        timer.schedule(myTimerTask, 2000L, 1000L);

        /**
         * 获取当前时间，并设置成距离当时间三秒之后的时间
         * 如果是 2017-12-12 23:59:57
         * 则设置后的时间则为 2017-12-13 00:00:00
         *
         */
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is: "+sf.format(calendar.getTime()));
      /*  calendar.add(Calendar.SECOND, 3);
//        timer.schedule(myTimerTask, calendar.getTime());

//        timer.schedule(myTimerTask, 3000L);
        System.out.println("schedule time is "+sf.format(myTimerTask.scheduledExecutionTime()));



        System.out.println("current canceled task number is: "+ timer.purge());
//        休眠5秒
        Thread.sleep(3000L);
        myTimerTask2.cancel();
        System.out.println("current canceled task number is: "+ timer.purge());*/


        timer.scheduleAtFixedRate(myTimerTask, calendar.getTime(), 2000);
        timer.scheduleAtFixedRate(myTimerTask2, calendar.getTime(), 2000);
    }
}
