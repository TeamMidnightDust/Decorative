package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class ChoppingLogBlockEntity extends BlockEntity {
    public ChoppingLogBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ChoppingLogBlockEntity, pos, state);
    }
}
