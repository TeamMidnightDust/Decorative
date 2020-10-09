package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.*;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<PoolSprinklerBlockEntity> PoolSprinklerBlockEntity;
    public static BlockEntityType<ShowerHeadBlockEntity> ShowerHeadBlockEntity;
    public static BlockEntityType<CeilingFanBlockEntity> CeilingFanBlockEntity;
    public static BlockEntityType<OakChoppingLogBlockEntity> OakChoppingLogBlockEntity;
    public static BlockEntityType<SpruceChoppingLogBlockEntity> SpruceChoppingLogBlockEntity;
    public static BlockEntityType<BirchChoppingLogBlockEntity> BirchChoppingLogBlockEntity;
    public static BlockEntityType<AcaciaChoppingLogBlockEntity> AcaciaChoppingLogBlockEntity;
    public static BlockEntityType<JungleChoppingLogBlockEntity> JungleChoppingLogBlockEntity;
    public static BlockEntityType<DarkOakChoppingLogBlockEntity> DarkOakChoppingLogBlockEntity;

    public static void init() {
        PoolSprinklerBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"pool_sprinkler_blockentity"), BlockEntityType.Builder.create(PoolSprinklerBlockEntity::new, Pool.PoolSprinkler).build(null));
        ShowerHeadBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"shower_head_blockentity"), BlockEntityType.Builder.create(ShowerHeadBlockEntity::new, DecorativeMain.ShowerHead).build(null));
        CeilingFanBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"ceiling_fan_blockentity"), BlockEntityType.Builder.create(CeilingFanBlockEntity::new, DecorativeMain.CeilingFan).build(null));
        OakChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"oak_chopping_log_blockentity"), BlockEntityType.Builder.create(OakChoppingLogBlockEntity::new, LogsWithAxes.OakChoppingLog).build(null));
        SpruceChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"spruce_chopping_log_blockentity"), BlockEntityType.Builder.create(SpruceChoppingLogBlockEntity::new, LogsWithAxes.SpruceChoppingLog).build(null));
        BirchChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"birch_chopping_log_blockentity"), BlockEntityType.Builder.create(BirchChoppingLogBlockEntity::new, LogsWithAxes.BirchChoppingLog).build(null));
        AcaciaChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"acacia_chopping_log_blockentity"), BlockEntityType.Builder.create(AcaciaChoppingLogBlockEntity::new, LogsWithAxes.AcaciaChoppingLog).build(null));
        JungleChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"jungle_chopping_log_blockentity"), BlockEntityType.Builder.create(JungleChoppingLogBlockEntity::new, LogsWithAxes.JungleChoppingLog).build(null));
        DarkOakChoppingLogBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier(DecorativeMain.MOD_ID,"dark_oak_chopping_log_blockentity"), BlockEntityType.Builder.create(DarkOakChoppingLogBlockEntity::new, LogsWithAxes.DarkOakChoppingLog).build(null));
    }
}
