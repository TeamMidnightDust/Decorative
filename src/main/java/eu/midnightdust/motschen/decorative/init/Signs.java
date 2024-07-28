package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.Sign;
import net.minecraft.block.Block;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerTraffic;

public class Signs {
    public static Block EmptySign = new Sign();
    public static Block StopSign = new Sign();
    public static Block FiveSign = new Sign();
    public static Block TenSign = new Sign();
    public static Block TwentySign = new Sign();
    public static Block ThirtySign = new Sign();
    public static Block FortySign = new Sign();
    public static Block FiftySign = new Sign();
    public static Block SixtySign = new Sign();
    public static Block SeventySign = new Sign();
    public static Block EightySign = new Sign();
    public static Block NinetySign = new Sign();
    public static Block OnehundredSign = new Sign();
    public static Block OnehundredtenSign = new Sign();

    public static void init() {
        registerTraffic(id("empty_sign"), EmptySign);

        registerTraffic(id("stop_sign"), StopSign);
        registerTraffic(id("five_sign"), FiveSign);
        registerTraffic(id("ten_sign"), TenSign);
        registerTraffic(id("twenty_sign"), TwentySign);
        registerTraffic(id("thirty_sign"), ThirtySign);
        registerTraffic(id("forty_sign"), FortySign);
        registerTraffic(id("fifty_sign"), FiftySign);
        registerTraffic(id("sixty_sign"), SixtySign);
        registerTraffic(id("seventy_sign"), SeventySign);
        registerTraffic(id("eighty_sign"), EightySign);
        registerTraffic(id("ninety_sign"), NinetySign);
        registerTraffic(id("onehundred_sign"), OnehundredSign);
        registerTraffic(id("onehundredten_sign"), OnehundredtenSign);
    }
}
