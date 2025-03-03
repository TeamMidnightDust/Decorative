package eu.midnightdust.motschen.decorative.util;

import eu.midnightdust.motschen.decorative.config.DecorativeConfig;

import java.time.LocalTime;

public class TimeUtil {
    public static int getHour12hFormat() {
        int hour = LocalTime.now().getHour();
        if (hour > 12)
            hour -= 12;
        return hour;
    }

    public static String getTime() {
        String hour = switch (DecorativeConfig.timeFormat) {
            case h12 -> (getHour12hFormat() <= 9 ? "0" : "") + getHour12hFormat();
            default -> (LocalTime.now().getHour() <= 9 ? "0" : "") + LocalTime.now().getHour();
        };
        String minute = (LocalTime.now().getMinute() <= 9 ? "0" : "") + LocalTime.now().getMinute();

        return hour+":"+minute;
    }
}