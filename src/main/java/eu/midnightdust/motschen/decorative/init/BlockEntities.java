package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.PoolSprinklerBlockEntity;
import eu.midnightdust.motschen.decorative.block.blockentity.ShowerHeadBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockEntities {

    public static BlockEntityType<PoolSprinklerBlockEntity> PoolSprinklerBlockEntity;
    public static BlockEntityType<ShowerHeadBlockEntity> ShowerHeadBlockEntity;

    public static void init() {
        PoolSprinklerBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("decorative","pool_sprinkler_blockentity"), BlockEntityType.Builder.create(PoolSprinklerBlockEntity::new, Pool.PoolSprinkler).build(null));
        ShowerHeadBlockEntity = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("decorative","shower_head_blockentity"), BlockEntityType.Builder.create(ShowerHeadBlockEntity::new, DecorativeMain.ShowerHead).build(null));

    }
}
