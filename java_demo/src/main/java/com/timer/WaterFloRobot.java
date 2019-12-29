package com.timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Brian in 20:16 2018/1/25
 */
public class WaterFloRobot extends TimerTask {
    private Integer bucketCapacity = 0;
    private Timer timer;

    public WaterFloRobot(Timer timer){
        this.timer = timer;
    }

    @Override
    public void run() {
//        灌水直至桶满为止
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(bucketCapacity < 5){
            System.out.println("Add water time is: "+sf.format(Calendar.getInstance().getTime()));
            System.out.println("Add 1L water into the bucket!");
            bucketCapacity++;
        }else {
//            水满之后停止
            System.out.println("The number of cancled task in timer is: "+timer.purge());
            cancel();
            System.out.println("The waterFloRobot has been aborted!");
            System.out.println("The number of cancled task in timer is: "+timer.purge());
            System.out.println("Current water is: "+bucketCapacity+" L");
//            等待5秒钟，终止timer里面的所有内容
            try {
                Thread.sleep(5000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("timer.cancel() : "+sf.format(Calendar.getInstance().getTime()));
            timer.cancel();

        }

    }

}
