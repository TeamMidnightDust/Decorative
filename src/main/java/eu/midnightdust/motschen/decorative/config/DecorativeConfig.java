package eu.midnightdust.motschen.decorative.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.annotation.ConfigEntry;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "decorative")
public class DecorativeConfig implements ConfigData {
    @Comment(value = "Change the time format")
    @ConfigEntry.Gui.EnumHandler(option = ConfigEntry.Gui.EnumHandler.EnumDisplayOption.BUTTON)
    public TimeFormat timeFormat = TimeFormat.h12;

    public enum TimeFormat {
        h12, h24
    }
}
