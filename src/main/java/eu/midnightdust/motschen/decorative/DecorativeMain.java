package eu.midnightdust.motschen.decorative;

import eu.midnightdust.lib.config.MidnightConfig;
import eu.midnightdust.motschen.decorative.block.*;
import eu.midnightdust.motschen.decorative.blockstates.CeilingFanStage;
import eu.midnightdust.motschen.decorative.blockstates.Part;
import eu.midnightdust.motschen.decorative.blockstates.PoolShape;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.midnightdust.motschen.decorative.init.*;
import eu.midnightdust.motschen.decorative.polymer.PolymerSupport;
import eu.midnightdust.motschen.decorative.polymer.TexturedSimpleBlock;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import eu.midnightdust.motschen.decorative.util.RegistryUtil;
import eu.midnightdust.motschen.decorative.world.OreFeatures;
import eu.pb4.polymer.core.api.item.PolymerItemGroupUtils;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerFurniture;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerGarden;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerTraffic;


public class DecorativeMain implements ModInitializer {
    public static final String MOD_ID = "decorative";
    public static final List<Block> BLOCKS = new ArrayList<>();

    public static ItemGroup IndoorGroup;
    public static ItemGroup TrafficGroup;
    public static ItemGroup GardenGroup;
    public static ItemGroup PoolGroup;
    public static final EnumProperty<PoolShape> POOL_SHAPE = EnumProperty.of("shape", PoolShape.class);
    public static final EnumProperty<Part> PART = EnumProperty.of("part", Part.class);
    public static final EnumProperty<CeilingFanStage> STAGE = EnumProperty.of("stage", CeilingFanStage.class);
    public static Block RockyAsphalt = new TexturedSimpleBlock(Blocks.COAL_ORE, id("rocky_asphalt"));
    public static Block Road = new TexturedSimpleBlock(Blocks.STONE, id("road"));
    public static Block RoadWhiteShort = new RotatableBlock(id("road_white_short"));
    public static Block RoadWhiteLong = new RotatableBlock(id("road_white_long"));
    public static Block TrafficCone = new TrafficCone();
    public static Block Guardrail = new Guardrail();
    public static Block SignPost = new SignPost();
    public static Block KitchenTiles = new TexturedSimpleBlock(Blocks.STONE, id("kitchen_tiles"));
    public static Block Television = new Television();
    public static Block OldTelevision = new OldTelevision();
    public static Block CeilingFan = new CeilingFan();
    public static Block SlidingDoor = new SlidingDoor();
    public static Block WaterPump = new WaterPump();
    public static Block FireHydrant = new FireHydrant();
    public static Block BirdBath = new BirdBath();
    public static Block ChristmasTree = new ChristmasTree();
    public static Block ChristmasLights = new ChristmasLights();
    public static Block ShowerHead = new ShowerHead();
    public static Block WallClock = new WallClock();
    public static Block StonePath = new StonePath();

    @Override
    public void onInitialize() {
        MidnightConfig.init(MOD_ID, DecorativeConfig.class);
        PolymerSupport.init();

        IndoorGroup = createGroup(id("indoor"), () -> DecorativeMain.Television);
        TrafficGroup = createGroup(id("traffic"), () -> DecorativeMain.TrafficCone);
        GardenGroup = createGroup(id("garden"), LogsWithAxes.TYPES::getFirst);
        PoolGroup = createGroup(id("pool"), () -> Pool.BEACH_BALL_ITEM);

        // Traffic //
        registerTraffic(id("rocky_asphalt"), RockyAsphalt);
        registerTraffic(id("road"), Road);
        registerTraffic(id("road_white_short"), RoadWhiteShort);
        registerTraffic(id("road_white_long"), RoadWhiteLong);
        registerTraffic(id("traffic_cone"), TrafficCone);
        registerTraffic(id("fire_hydrant"), FireHydrant);
        registerTraffic(id("guardrail"), Guardrail);
        registerTraffic(id("sign_post"), SignPost);
        Signs.init();

        //Garden//
        registerGarden(id("stone_path"), StonePath);
        registerGarden(id("bird_bath"), BirdBath);
        registerGarden(id("water_pump"), WaterPump);
        LogsWithAxes.init();
        Pool.init();

        //Furniture//
        registerFurniture(id("kitchen_tiles"), KitchenTiles);
        registerFurniture(id("wall_clock"), WallClock);
        registerFurniture(id("television"), Television);
        registerFurniture(id("old_television"), OldTelevision);
        registerFurniture(id("ceilingfan"), CeilingFan);
        registerFurniture(id("shower_head"), ShowerHead);
        registerFurniture(id("sliding_door"), SlidingDoor);
        registerFurniture(id("christmas_tree"), ChristmasTree);
        registerFurniture(id("christmas_lights"), ChristmasLights);

        Lamps.init();
        DoubleLamps.init();
        Clocks.init();
        OreFeatures.init();
        BlockEntities.init();
        DecorativeSoundEvents.init();
    }
    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
    public static ItemGroup createGroup(Identifier id, Supplier<ItemConvertible> icon) {
        ItemGroup group;
        Text name = Text.translatable("itemGroup."+id.getNamespace()+"."+id.getPath());

        //if (DecorativeConfig.polymerIntegration) {
            group = PolymerItemGroupUtils.builder().displayName(name).icon(() -> new ItemStack(icon.get())).entries(((displayContext, entries) -> {
                List<ItemStack> groupItems = new ArrayList<>();
                RegistryUtil.groupItems.stream().filter(itemEntry -> itemEntry.groupName() == name).forEach(itemEntry -> groupItems.add(itemEntry.stack()));
                entries.addAll(groupItems);
            })).build();
            PolymerItemGroupUtils.registerPolymerItemGroup(id, group);
//        } else {
//            group = FabricItemGroup.builder().displayName(name).icon(() -> new ItemStack(icon.get())).entries(((displayContext, entries) -> {
//                List<ItemStack> groupItems = new ArrayList<>();
//                RegistryUtil.groupItems.stream().filter(itemEntry -> itemEntry.groupName() == name).forEach(itemEntry -> groupItems.add(itemEntry.stack()));
//                entries.addAll(groupItems);
//            })).build();
//            Registry.register(Registries.ITEM_GROUP, id, group);
//        }
        return group;
    }
}
