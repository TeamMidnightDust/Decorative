package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.DigitalClock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Clocks {
    public static Block WhiteDigitalClock = new DigitalClock();
    public static Block OrangeDigitalClock = new DigitalClock();
    public static Block MagentaDigitalClock = new DigitalClock();
    public static Block LightBlueDigitalClock = new DigitalClock();
    public static Block YellowDigitalClock = new DigitalClock();
    public static Block LimeDigitalClock = new DigitalClock();
    public static Block PinkDigitalClock = new DigitalClock();
    public static Block GrayDigitalClock = new DigitalClock();
    public static Block LightGrayDigitalClock = new DigitalClock();
    public static Block CyanDigitalClock = new DigitalClock();
    public static Block PurpleDigitalClock = new DigitalClock();
    public static Block BlueDigitalClock = new DigitalClock();
    public static Block BrownDigitalClock = new DigitalClock();
    public static Block GreenDigitalClock = new DigitalClock();
    public static Block RedDigitalClock = new DigitalClock();
    public static Block BlackDigitalClock = new DigitalClock();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"white_digital_clock"), WhiteDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"white_digital_clock"), new BlockItem(WhiteDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"orange_digital_clock"), OrangeDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"orange_digital_clock"), new BlockItem(OrangeDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"magenta_digital_clock"), MagentaDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"magenta_digital_clock"), new BlockItem(MagentaDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"light_blue_digital_clock"), LightBlueDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"light_blue_digital_clock"), new BlockItem(LightBlueDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"yellow_digital_clock"), YellowDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"yellow_digital_clock"), new BlockItem(YellowDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"lime_digital_clock"), LimeDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"lime_digital_clock"), new BlockItem(LimeDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"pink_digital_clock"), PinkDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"pink_digital_clock"), new BlockItem(PinkDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"gray_digital_clock"), GrayDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"gray_digital_clock"), new BlockItem(GrayDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"light_gray_digital_clock"), LightGrayDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"light_gray_digital_clock"), new BlockItem(LightGrayDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"cyan_digital_clock"), CyanDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"cyan_digital_clock"), new BlockItem(CyanDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"purple_digital_clock"), PurpleDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"purple_digital_clock"), new BlockItem(PurpleDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"blue_digital_clock"), BlueDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"blue_digital_clock"), new BlockItem(BlueDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"brown_digital_clock"), BrownDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"brown_digital_clock"), new BlockItem(BrownDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"green_digital_clock"), GreenDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"green_digital_clock"), new BlockItem(GreenDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"red_digital_clock"), RedDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"red_digital_clock"), new BlockItem(RedDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"black_digital_clock"), BlackDigitalClock);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"black_digital_clock"), new BlockItem(BlackDigitalClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
    }
}
