package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.DoubleLamp;
import net.minecraft.block.Block;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerFurniture;

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
        registerFurniture(id("white_double_lamp"), WhiteDoubleLamp);
        registerFurniture(id("orange_double_lamp"), OrangeDoubleLamp);
        registerFurniture(id("magenta_double_lamp"), MagentaDoubleLamp);
        registerFurniture(id("light_blue_double_lamp"), LightBlueDoubleLamp);
        registerFurniture(id("yellow_double_lamp"), YellowDoubleLamp);
        registerFurniture(id("lime_double_lamp"), LimeDoubleLamp);
        registerFurniture(id("pink_double_lamp"), PinkDoubleLamp);
        registerFurniture(id("gray_double_lamp"), GrayDoubleLamp);
        registerFurniture(id("light_gray_double_lamp"), LightGrayDoubleLamp);
        registerFurniture(id("cyan_double_lamp"), CyanDoubleLamp);
        registerFurniture(id("purple_double_lamp"), PurpleDoubleLamp);
        registerFurniture(id("blue_double_lamp"), BlueDoubleLamp);
        registerFurniture(id("brown_double_lamp"), BrownDoubleLamp);
        registerFurniture(id("green_double_lamp"), GreenDoubleLamp);
        registerFurniture(id("red_double_lamp"), RedDoubleLamp);
        registerFurniture(id("black_double_lamp"), BlackDoubleLamp);
    }
}
