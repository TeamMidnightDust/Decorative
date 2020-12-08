package eu.midnightdust.motschen.decorative.config;

import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;
import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;

@Config(name = "decorative")
public class DecorativeConfig implements ConfigData {
    @Comment(value = "Use 12h Time")
    public boolean use12hTime = true;
}
