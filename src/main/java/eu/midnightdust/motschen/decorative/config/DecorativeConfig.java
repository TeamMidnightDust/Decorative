package eu.midnightdust.motschen.decorative.config;

import eu.midnightdust.lib.config.MidnightConfig;

import java.util.TimeZone;

public class DecorativeConfig extends MidnightConfig {
    @Entry public static TimeFormat timeFormat = TimeZone.getDefault().useDaylightTime() ? TimeFormat.h12 : TimeFormat.h24;
    @Entry public static boolean polymerIntegration = true;
    @Entry(min = 0, max = 200, isSlider = true) public static int viewDistance = 100;

    public enum TimeFormat {
        h12, h24
    }
}
