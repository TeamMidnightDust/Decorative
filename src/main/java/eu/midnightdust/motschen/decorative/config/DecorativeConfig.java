package eu.midnightdust.motschen.decorative.config;

import eu.midnightdust.lib.config.MidnightConfig;

import java.util.TimeZone;

public class DecorativeConfig extends MidnightConfig {
    @Entry public static TimeFormat timeFormat = TimeZone.getDefault().useDaylightTime() ? TimeFormat.h12 : TimeFormat.h24;
    @Entry public static boolean polymerIntegration = false;

    public enum TimeFormat {
        h12, h24
    }
}
