package com.timer;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * Created by Brian in 20:16 2018/1/25
 */
public class DancingRobot extends TimerTask {
    @Override
    public void run() {
//        获取最近一次任务执行的时间，并将其格式化
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Dancing Scheduled time is: "+sf.format(scheduledExecutionTime()));

        System.out.println("Dancing happily!");
    }

}
