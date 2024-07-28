package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import net.minecraft.block.Block;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerGarden;

public class LogsWithAxes {
    public static Block OakChoppingLog = new ChoppingLog();
    public static Block SpruceChoppingLog = new ChoppingLog();
    public static Block BirchChoppingLog = new ChoppingLog();
    public static Block AcaciaChoppingLog = new ChoppingLog();
    public static Block JungleChoppingLog = new ChoppingLog();
    public static Block DarkOakChoppingLog = new ChoppingLog();

    public static void init() {
        registerGarden(id("oak_log_with_axe"), OakChoppingLog);
        registerGarden(id("spruce_log_with_axe"), SpruceChoppingLog);
        registerGarden(id("birch_log_with_axe"), BirchChoppingLog);
        registerGarden(id("acacia_log_with_axe"), AcaciaChoppingLog);
        registerGarden(id("jungle_log_with_axe"), JungleChoppingLog);
        registerGarden(id("dark_oak_log_with_axe"), DarkOakChoppingLog);
    }
}
