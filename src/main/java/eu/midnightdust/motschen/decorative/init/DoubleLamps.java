package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.DoubleLamp;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DoubleLamps {
    public static Block WhiteDoubleLamp = new DoubleLamp();
    public static Block OrangeDoubleLamp = new DoubleLamp();
    public static Block MagentaDoubleLamp = new DoubleLamp();
    public static Block LightBlueDoubleLamp = new DoubleLamp();
    public static Block YellowDoubleLamp = new DoubleLamp();
    public static Block LimeDoubleLamp = new DoubleLamp();
    public static Block PinkDoubleLamp = new DoubleLamp();
    public static Block GrayDoubleLamp = new DoubleLamp();
    public static Block LightGrayDoubleLamp = new DoubleLamp();
    public static Block CyanDoubleLamp = new DoubleLamp();
    public static Block PurpleDoubleLamp = new DoubleLamp();
    public static Block BlueDoubleLamp = new DoubleLamp();
    public static Block BrownDoubleLamp = new DoubleLamp();
    public static Block GreenDoubleLamp = new DoubleLamp();
    public static Block RedDoubleLamp = new DoubleLamp();
    public static Block BlackDoubleLamp = new DoubleLamp();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"white_double_lamp"), WhiteDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"white_double_lamp"), new BlockItem(WhiteDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"orange_double_lamp"), OrangeDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"orange_double_lamp"), new BlockItem(OrangeDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"magenta_double_lamp"), MagentaDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"magenta_double_lamp"), new BlockItem(MagentaDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"light_blue_double_lamp"), LightBlueDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"light_blue_double_lamp"), new BlockItem(LightBlueDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"yellow_double_lamp"), YellowDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"yellow_double_lamp"), new BlockItem(YellowDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"lime_double_lamp"), LimeDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"lime_double_lamp"), new BlockItem(LimeDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"pink_double_lamp"), PinkDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"pink_double_lamp"), new BlockItem(PinkDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"gray_double_lamp"), GrayDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"gray_double_lamp"), new BlockItem(GrayDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"light_gray_double_lamp"), LightGrayDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"light_gray_double_lamp"), new BlockItem(LightGrayDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"cyan_double_lamp"), CyanDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"cyan_double_lamp"), new BlockItem(CyanDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"purple_double_lamp"), PurpleDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"purple_double_lamp"), new BlockItem(PurpleDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"blue_double_lamp"), BlueDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"blue_double_lamp"), new BlockItem(BlueDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"brown_double_lamp"), BrownDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"brown_double_lamp"), new BlockItem(BrownDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"green_double_lamp"), GreenDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"green_double_lamp"), new BlockItem(GreenDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"red_double_lamp"), RedDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"red_double_lamp"), new BlockItem(RedDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"black_double_lamp"), BlackDoubleLamp);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"black_double_lamp"), new BlockItem(BlackDoubleLamp, new Item.Settings().group(DecorativeMain.IndoorGroup)));
    }
}
