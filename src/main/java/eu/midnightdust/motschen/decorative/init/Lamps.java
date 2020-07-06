package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.Lamp;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Lamps {
    public static Block WhiteLamp = new Lamp();
    public static Block OrangeLamp = new Lamp();
    public static Block MagentaLamp = new Lamp();
    public static Block LightBlueLamp = new Lamp();
    public static Block YellowLamp = new Lamp();
    public static Block LimeLamp = new Lamp();
    public static Block PinkLamp = new Lamp();
    public static Block GrayLamp = new Lamp();
    public static Block LightGrayLamp = new Lamp();
    public static Block CyanLamp = new Lamp();
    public static Block PurpleLamp = new Lamp();
    public static Block BlueLamp = new Lamp();
    public static Block BrownLamp = new Lamp();
    public static Block GreenLamp = new Lamp();
    public static Block RedLamp = new Lamp();
    public static Block BlackLamp = new Lamp();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier("decorative","white_lamp"), WhiteLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","white_lamp"), new BlockItem(WhiteLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","orange_lamp"), OrangeLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","orange_lamp"), new BlockItem(OrangeLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","magenta_lamp"), MagentaLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","magenta_lamp"), new BlockItem(MagentaLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","light_blue_lamp"), LightBlueLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","light_blue_lamp"), new BlockItem(LightBlueLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","yellow_lamp"), YellowLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","yellow_lamp"), new BlockItem(YellowLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","lime_lamp"), LimeLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","lime_lamp"), new BlockItem(LimeLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","pink_lamp"), PinkLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","pink_lamp"), new BlockItem(PinkLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","gray_lamp"), GrayLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","gray_lamp"), new BlockItem(GrayLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","light_gray_lamp"), LightGrayLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","light_gray_lamp"), new BlockItem(LightGrayLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","cyan_lamp"), CyanLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","cyan_lamp"), new BlockItem(CyanLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","purple_lamp"), PurpleLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","purple_lamp"), new BlockItem(PurpleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","blue_lamp"), BlueLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","blue_lamp"), new BlockItem(BlueLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","brown_lamp"), BrownLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","brown_lamp"), new BlockItem(BrownLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","green_lamp"), GreenLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","green_lamp"), new BlockItem(GreenLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","red_lamp"), RedLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","red_lamp"), new BlockItem(RedLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","black_lamp"), BlackLamp);
        Registry.register(Registry.ITEM, new Identifier("decorative","black_lamp"), new BlockItem(BlackLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
    }
}
