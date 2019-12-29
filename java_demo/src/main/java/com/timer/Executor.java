package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;

/**
 * Created by Brian in 20:24 2018/1/25
 */
public class Executor {
    public static void main(String[] args){
        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current time is: "+sf.format(calendar.getTime()));

        DancingRobot dr = new DancingRobot();
        WaterFloRobot wr = new WaterFloRobot(timer);

        timer.schedule(dr, calendar.getTime(), 2000L);
        timer.scheduleAtFixedRate(wr, calendar.getTime(), 1000L);
    }
}
