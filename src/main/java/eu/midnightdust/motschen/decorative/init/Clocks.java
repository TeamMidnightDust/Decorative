package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.DigitalClock;
import net.minecraft.block.Block;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerFurniture;

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
        registerFurniture(id("white_digital_clock"), WhiteDigitalClock);
        registerFurniture(id("orange_digital_clock"), OrangeDigitalClock);
        registerFurniture(id("magenta_digital_clock"), MagentaDigitalClock);
        registerFurniture(id("light_blue_digital_clock"), LightBlueDigitalClock);
        registerFurniture(id("yellow_digital_clock"), YellowDigitalClock);
        registerFurniture(id("lime_digital_clock"), LimeDigitalClock);
        registerFurniture(id("pink_digital_clock"), PinkDigitalClock);
        registerFurniture(id("gray_digital_clock"), GrayDigitalClock);
        registerFurniture(id("light_gray_digital_clock"), LightGrayDigitalClock);
        registerFurniture(id("cyan_digital_clock"), CyanDigitalClock);
        registerFurniture(id("purple_digital_clock"), PurpleDigitalClock);
        registerFurniture(id("blue_digital_clock"), BlueDigitalClock);
        registerFurniture(id("brown_digital_clock"), BrownDigitalClock);
        registerFurniture(id("green_digital_clock"), GreenDigitalClock);
        registerFurniture(id("red_digital_clock"), RedDigitalClock);
        registerFurniture(id("black_digital_clock"), BlackDigitalClock);
    }
}
