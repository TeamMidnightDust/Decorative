package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LogsWithAxes {
    public static Block OakChoppingLog = new OakChoppingLog();
    public static Block SpruceChoppingLog = new SpruceChoppingLog();
    public static Block BirchChoppingLog = new BirchChoppingLog();
    public static Block AcaciaChoppingLog = new AcaciaChoppingLog();
    public static Block JungleChoppingLog = new JungleChoppingLog();
    public static Block DarkOakChoppingLog = new DarkOakChoppingLog();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"oak_log_with_axe"), OakChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"oak_log_with_axe"), new BlockItem(OakChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"spruce_log_with_axe"), SpruceChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"spruce_log_with_axe"), new BlockItem(SpruceChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"birch_log_with_axe"), BirchChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"birch_log_with_axe"), new BlockItem(BirchChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"acacia_log_with_axe"), AcaciaChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"acacia_log_with_axe"), new BlockItem(AcaciaChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"jungle_log_with_axe"), JungleChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"jungle_log_with_axe"), new BlockItem(JungleChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"dark_oak_log_with_axe"), DarkOakChoppingLog);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"dark_oak_log_with_axe"), new BlockItem(DarkOakChoppingLog, new Item.Settings().group(DecorativeMain.GardenGroup)));
    }
}
