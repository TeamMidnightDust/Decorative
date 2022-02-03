package eu.midnightdust.motschen.decorative;

import eu.midnightdust.lib.config.MidnightConfig;
import eu.midnightdust.motschen.decorative.block.*;
import eu.midnightdust.motschen.decorative.blockstates.CeilingFanStage;
import eu.midnightdust.motschen.decorative.blockstates.Part;
import eu.midnightdust.motschen.decorative.blockstates.PoolShape;
import eu.midnightdust.motschen.decorative.blockstates.Program;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.midnightdust.motschen.decorative.init.*;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import eu.midnightdust.motschen.decorative.world.OreFeatures;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.*;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;


public class DecorativeMain implements ModInitializer {
    public static final String MOD_ID = "decorative";

    public static final ItemGroup IndoorGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "indoor"), () -> new ItemStack(DecorativeMain.Television));
    public static final ItemGroup TrafficGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "traffic"), () -> new ItemStack(DecorativeMain.TrafficCone));
    public static final ItemGroup GardenGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "garden"), () -> new ItemStack(LogsWithAxes.OakChoppingLog));
    public static final ItemGroup PoolGroup = FabricItemGroupBuilder.build(new Identifier(MOD_ID, "pool"), () -> new ItemStack(Pool.BEACH_BALL_ITEM));
    public static final EnumProperty<Program> PROGRAM = EnumProperty.of("program", Program.class);
    public static final EnumProperty<PoolShape> POOL_SHAPE = EnumProperty.of("shape", PoolShape.class);
    public static final EnumProperty<Part> PART = EnumProperty.of("part", Part.class);
    public static final EnumProperty<CeilingFanStage> STAGE = EnumProperty.of("stage", CeilingFanStage.class);
    public static Block RockyAsphalt = new Block(FabricBlockSettings.copyOf(Blocks.COAL_ORE));
    public static Block Road = new Block(FabricBlockSettings.copyOf(Blocks.STONE));
    public static Block RoadWhiteShort = new RotatableBlock();
    public static Block RoadWhiteLong = new RotatableBlock();
    public static Block TrafficCone = new TrafficCone();
    public static Block Guardrail = new Guardrail();
    public static Block SignPost = new SignPost();
    public static Block KitchenTiles = new Block(FabricBlockSettings.copyOf(Blocks.STONE));
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
        MidnightConfig.init("decorative", DecorativeConfig.class);

        BlockEntities.init();

        // Traffic //
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"rocky_asphalt"), RockyAsphalt);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"rocky_asphalt"), new BlockItem(RockyAsphalt, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"road"), Road);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"road"), new BlockItem(Road, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"road_white_short"), RoadWhiteShort);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"road_white_short"), new BlockItem(RoadWhiteShort, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"road_white_long"), RoadWhiteLong);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"road_white_long"), new BlockItem(RoadWhiteLong, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"traffic_cone"), TrafficCone);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"traffic_cone"), new BlockItem(TrafficCone, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"fire_hydrant"), FireHydrant);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"fire_hydrant"), new BlockItem(FireHydrant, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"guardrail"), Guardrail);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"guardrail"), new BlockItem(Guardrail, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"sign_post"), SignPost);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"sign_post"), new BlockItem(SignPost, new Item.Settings().group(DecorativeMain.TrafficGroup)));
        Signs.init();

        //Garden//
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"stone_path"), StonePath);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"stone_path"), new BlockItem(StonePath, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"bird_bath"), BirdBath);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"bird_bath"), new BlockItem(BirdBath, new Item.Settings().group(DecorativeMain.GardenGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"water_pump"), WaterPump);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"water_pump"), new BlockItem(WaterPump, new Item.Settings().group(DecorativeMain.GardenGroup)));
        LogsWithAxes.init();
        Pool.init();

        //Furniture//
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"kitchen_tiles"), KitchenTiles);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"kitchen_tiles"), new BlockItem(KitchenTiles, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"wall_clock"), WallClock);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"wall_clock"), new BlockItem(WallClock, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"television"), Television);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"television"), new BlockItem(Television, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"old_television"), OldTelevision);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"old_television"), new BlockItem(OldTelevision, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"ceilingfan"), CeilingFan);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"ceilingfan"), new BlockItem(CeilingFan, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"shower_head"), ShowerHead);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"shower_head"), new BlockItem(ShowerHead, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"sliding_door"), SlidingDoor);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"sliding_door"), new BlockItem(SlidingDoor, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"christmas_tree"), ChristmasTree);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"christmas_tree"), new BlockItem(ChristmasTree, new Item.Settings().group(DecorativeMain.IndoorGroup)));
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID,"christmas_lights"), ChristmasLights);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID,"christmas_lights"), new BlockItem(ChristmasLights, new Item.Settings().group(DecorativeMain.IndoorGroup)));

        Lamps.init();
        DoubleLamps.init();
        Clocks.init();
        OreFeatures.init();
        new DecorativeSoundEvents();
    }
}
