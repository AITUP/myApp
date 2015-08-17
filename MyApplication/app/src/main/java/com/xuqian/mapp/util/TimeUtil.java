package com.xuqian.mapp.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuqian on 2015/8/17.
 */
public class TimeUtil {

    public static String timeAgo(String timeStr) {
        Date date = null;
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss Z");
            date = format.parse(timeStr);
        } catch (ParseException  e) {
          e.printStackTrace();
            return "";
        }
        long timeStamp = date.getTime();
        Date currentTime = new Date();
        long currrentTimeStamp = currentTime.getTime();
        long seconds = (currrentTimeStamp - timeStamp)/1000;

        long minutes = Math.abs(seconds/60);
        long hours = Math.abs(minutes/60);
        long days= Math.abs(hours/24);

        if (seconds <= 15) {
            return "刚刚";
        } else {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
            return formatter.format(date);
        }
    }
}
