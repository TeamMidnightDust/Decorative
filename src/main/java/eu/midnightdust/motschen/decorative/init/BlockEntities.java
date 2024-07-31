package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.*;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.polymer.core.api.block.PolymerBlockUtils;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class BlockEntities {

    public static BlockEntityType<PoolSprinklerBlockEntity> PoolSprinklerBlockEntity;
    public static BlockEntityType<ShowerHeadBlockEntity> ShowerHeadBlockEntity;
    public static BlockEntityType<CeilingFanBlockEntity> CeilingFanBlockEntity;
    public static BlockEntityType<ChoppingLogBlockEntity> ChoppingLogBlockEntity;
    public static BlockEntityType<WallClockBlockEntity> WallClockBlockEntity;
    public static BlockEntityType<DigitalClockBlockEntity> DigitalClockBlockEntity;

    public static void init() {
        PoolSprinklerBlockEntity = registerBlockEntity(id("pool_sprinkler_blockentity"), PoolSprinklerBlockEntity::new, Pool.PoolSprinkler);
        ShowerHeadBlockEntity = registerBlockEntity(id("shower_head_blockentity"), ShowerHeadBlockEntity::new, DecorativeMain.ShowerHead);
        CeilingFanBlockEntity = registerBlockEntity(id("ceiling_fan_blockentity"), CeilingFanBlockEntity::new, DecorativeMain.CeilingFan);
        ChoppingLogBlockEntity = registerBlockEntity( id("chopping_log_blockentity"), ChoppingLogBlockEntity::new, LogsWithAxes.OakChoppingLog, LogsWithAxes.BirchChoppingLog, LogsWithAxes.AcaciaChoppingLog, LogsWithAxes.DarkOakChoppingLog, LogsWithAxes.JungleChoppingLog, LogsWithAxes.SpruceChoppingLog);
        WallClockBlockEntity = registerBlockEntity(id("wall_clock_blockentity"), WallClockBlockEntity::new, DecorativeMain.WallClock);
        DigitalClockBlockEntity = registerBlockEntity(id("digital_clock_blockentity"), DigitalClockBlockEntity::new, Clocks.RedDigitalClock, Clocks.BlackDigitalClock, Clocks.BlueDigitalClock, Clocks.BrownDigitalClock, Clocks.CyanDigitalClock, Clocks.GrayDigitalClock, Clocks.GreenDigitalClock, Clocks.LightBlueDigitalClock, Clocks.LightGrayDigitalClock, Clocks.LimeDigitalClock, Clocks.MagentaDigitalClock, Clocks.OrangeDigitalClock, Clocks.PinkDigitalClock, Clocks.PurpleDigitalClock, Clocks.WhiteDigitalClock, Clocks.YellowDigitalClock);
    }
    private static <T extends BlockEntity> BlockEntityType<T> registerBlockEntity(Identifier id, BlockEntityType.BlockEntityFactory<T> factory, Block... blocks) {
        var blockEntity = Registry.register(Registries.BLOCK_ENTITY_TYPE, id, BlockEntityType.Builder.create(factory, blocks).build(null));
        //if (DecorativeConfig.polymerIntegration)
        PolymerBlockUtils.registerBlockEntity(blockEntity);
        return blockEntity;
    }
}
