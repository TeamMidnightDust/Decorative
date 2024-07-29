package eu.midnightdust.motschen.decorative.util;

import eu.midnightdust.motschen.decorative.config.DecorativeConfig;

import java.time.LocalTime;

public class TimeUtil {
    public static int getHour12hFormat() {
        int hour;
        hour = LocalTime.now().getHour();
        if (hour > 12) {
            hour = hour - 12;
        }
        return hour;
    }

    public static String getTime() {
        String hour;
        String minute;

        // Hour
        if (DecorativeConfig.timeFormat.equals(DecorativeConfig.TimeFormat.h12)) {
            if (getHour12hFormat() <= 9) {
                hour = "0" + getHour12hFormat();
            } else {
                hour = "" + getHour12hFormat();
            }
        }
        else {
            if (LocalTime.now().getHour() <= 9) {
                hour = "0" + LocalTime.now().getHour();
            } else {
                hour = "" + LocalTime.now().getHour();
            }
        }

        // Minute
        if (LocalTime.now().getMinute() <= 9) {
            minute = "0" + LocalTime.now().getMinute();
        }
        else {
            minute = "" + LocalTime.now().getMinute();
        }

        return hour +":"+ minute;
    }
}
