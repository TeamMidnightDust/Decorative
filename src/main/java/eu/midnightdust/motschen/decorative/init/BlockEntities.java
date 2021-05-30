package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.*;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<PoolSprinklerBlockEntity> PoolSprinklerBlockEntity;
    public static BlockEntityType<ShowerHeadBlockEntity> ShowerHeadBlockEntity;
    public static BlockEntityType<CeilingFanBlockEntity> CeilingFanBlockEntity;
    public static BlockEntityType<ChoppingLogBlockEntity> ChoppingLogBlockEntity;
    public static BlockEntityType<WallClockBlockEntity> WallClockBlockEntity;
    public static BlockEntityType<DigitalClockBlockEntity> DigitalClockBlockEntity;

    public static void init() {
        PoolSprinklerBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"pool_sprinkler_blockentity"), FabricBlockEntityTypeBuilder.create(PoolSprinklerBlockEntity::new, Pool.PoolSprinkler).build(null));
        ShowerHeadBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"shower_head_blockentity"), FabricBlockEntityTypeBuilder.create(ShowerHeadBlockEntity::new, DecorativeMain.ShowerHead).build(null));
        CeilingFanBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"ceiling_fan_blockentity"), FabricBlockEntityTypeBuilder.create(CeilingFanBlockEntity::new, DecorativeMain.CeilingFan).build(null));
        ChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"chopping_log_blockentity"), FabricBlockEntityTypeBuilder.create(ChoppingLogBlockEntity::new, LogsWithAxes.OakChoppingLog, LogsWithAxes.BirchChoppingLog, LogsWithAxes.AcaciaChoppingLog, LogsWithAxes.DarkOakChoppingLog, LogsWithAxes.JungleChoppingLog, LogsWithAxes.SpruceChoppingLog).build(null));
        WallClockBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"wall_clock_blockentity"), FabricBlockEntityTypeBuilder.create(WallClockBlockEntity::new, DecorativeMain.WallClock).build(null));
        DigitalClockBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"digital_clock_blockentity"), FabricBlockEntityTypeBuilder.create(DigitalClockBlockEntity::new, Clocks.RedDigitalClock, Clocks.BlackDigitalClock, Clocks.BlueDigitalClock, Clocks.BrownDigitalClock, Clocks.CyanDigitalClock, Clocks.GrayDigitalClock, Clocks.GreenDigitalClock, Clocks.LightBlueDigitalClock, Clocks.LightGrayDigitalClock, Clocks.LimeDigitalClock, Clocks.MagentaDigitalClock, Clocks.OrangeDigitalClock, Clocks.PinkDigitalClock, Clocks.PurpleDigitalClock, Clocks.WhiteDigitalClock, Clocks.YellowDigitalClock).build(null));
    }
}
