package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.Lamp;
import net.minecraft.block.Block;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerFurniture;

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
        registerFurniture(id("white_lamp"), WhiteLamp);
        registerFurniture(id("orange_lamp"), OrangeLamp);
        registerFurniture(id("magenta_lamp"), MagentaLamp);
        registerFurniture(id("light_blue_lamp"), LightBlueLamp);
        registerFurniture(id("yellow_lamp"), YellowLamp);
        registerFurniture(id("lime_lamp"), LimeLamp);
        registerFurniture(id("pink_lamp"), PinkLamp);
        registerFurniture(id("gray_lamp"), GrayLamp);
        registerFurniture(id("light_gray_lamp"), LightGrayLamp);
        registerFurniture(id("cyan_lamp"), CyanLamp);
        registerFurniture(id("purple_lamp"), PurpleLamp);
        registerFurniture(id("blue_lamp"), BlueLamp);
        registerFurniture(id("brown_lamp"), BrownLamp);
        registerFurniture(id("green_lamp"), GreenLamp);
        registerFurniture(id("red_lamp"), RedLamp);
        registerFurniture(id("black_lamp"), BlackLamp);
    }
}
