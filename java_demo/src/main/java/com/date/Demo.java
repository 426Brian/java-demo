package com.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Brian in 1:34 2018/11/25
 */
public class Demo {
    public static void main(String[] args) {
        long cur = System.currentTimeMillis();
        Date date = new Date();
        System.out.println(date);

        date = new Date(cur);
        System.out.println(date.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        String datestr = sdf.format(date);
        System.out.println(datestr);

        datestr = "2018-11-25 01:50:53.697";

        try {
            date = sdf.parse(datestr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);

    }
}
