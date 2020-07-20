package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.Sign;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

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
        Registry.register(Registry.BLOCK, new Identifier("decorative","empty_sign"), EmptySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","empty_sign"), new BlockItem(EmptySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));

        Registry.register(Registry.BLOCK, new Identifier("decorative","stop_sign"), StopSign);
        Registry.register(Registry.ITEM, new Identifier("decorative","stop_sign"), new BlockItem(StopSign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","five_sign"), FiveSign);
        Registry.register(Registry.ITEM, new Identifier("decorative","five_sign"), new BlockItem(FiveSign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","ten_sign"), TenSign);
        Registry.register(Registry.ITEM, new Identifier("decorative","ten_sign"), new BlockItem(TenSign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","twenty_sign"), TwentySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","twenty_sign"), new BlockItem(TwentySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","thirty_sign"), ThirtySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","thirty_sign"), new BlockItem(ThirtySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","forty_sign"), FortySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","forty_sign"), new BlockItem(FortySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","fifty_sign"), FiftySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","fifty_sign"), new BlockItem(FiftySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","sixty_sign"), SixtySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","sixty_sign"), new BlockItem(SixtySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","seventy_sign"), SeventySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","seventy_sign"), new BlockItem(SeventySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","eighty_sign"), EightySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","eighty_sign"), new BlockItem(EightySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","ninety_sign"), NinetySign);
        Registry.register(Registry.ITEM, new Identifier("decorative","ninety_sign"), new BlockItem(NinetySign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","onehundred_sign"), OnehundredSign);
        Registry.register(Registry.ITEM, new Identifier("decorative","onehundred_sign"), new BlockItem(OnehundredSign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier("decorative","onehundredten_sign"), OnehundredtenSign);
        Registry.register(Registry.ITEM, new Identifier("decorative","onehundredten_sign"), new BlockItem(OnehundredtenSign, new Item.Settings().group(DecorativeMain.TrafficGroup)));
    }
}
