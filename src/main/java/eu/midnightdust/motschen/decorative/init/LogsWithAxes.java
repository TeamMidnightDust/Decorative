package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.LogWithAxe;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LogsWithAxes {
    public static Block OakLogWithAxe = new LogWithAxe();
    public static Block SpruceLogWithAxe = new LogWithAxe();
    public static Block BirchLogWithAxe = new LogWithAxe();
    public static Block AcaciaLogWithAxe = new LogWithAxe();
    public static Block JungleLogWithAxe = new LogWithAxe();
    public static Block DarkOakLogWithAxe = new LogWithAxe();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier("decorative","oak_log_with_axe"), OakLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","oak_log_with_axe"), new BlockItem(OakLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","spruce_log_with_axe"), SpruceLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","spruce_log_with_axe"), new BlockItem(SpruceLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","birch_log_with_axe"), BirchLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","birch_log_with_axe"), new BlockItem(BirchLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","acacia_log_with_axe"), AcaciaLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","acacia_log_with_axe"), new BlockItem(AcaciaLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","jungle_log_with_axe"), JungleLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","jungle_log_with_axe"), new BlockItem(JungleLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","dark_oak_log_with_axe"), DarkOakLogWithAxe);
        Registry.register(Registry.ITEM, new Identifier("decorative","dark_oak_log_with_axe"), new BlockItem(DarkOakLogWithAxe, new Item.Settings().group(DecorativeMain.GardenGroup)));
    }
}
