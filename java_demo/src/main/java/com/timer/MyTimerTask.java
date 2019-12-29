package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * Created by Brian in 20:27 2018/1/24
 */
public class MyTimerTask extends TimerTask {

    private String name;
    private long costTime;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyTimerTask(String name, long costTime) {
        this.name = name;
        this.costTime = costTime;
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(name + "Current time is: " + sf.format(calendar.getTime()));

        try {
            Thread.sleep(costTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(name + "finish time is: " + sf.format(calendar.getTime()));
        throw new RuntimeException();

    }

}
