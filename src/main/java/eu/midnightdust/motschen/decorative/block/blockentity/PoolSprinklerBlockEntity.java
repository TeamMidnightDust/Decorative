package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class PoolSprinklerBlockEntity extends BlockEntity {

    public PoolSprinklerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.PoolSprinklerBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, PoolSprinklerBlockEntity blockEntity) {
        if (state.get(PoolSprinkler.POWERED)) {
            switch (state.get(PoolSprinkler.FACING)) {
                case NORTH: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() - 0.34, 1, 1, 1); break;
                case EAST: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 1.34, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 1, 1); break;
                case SOUTH: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 1.34, 1, 1, 1); break;
                case WEST: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() - 0.34, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 1, 1); break;
                default: break;
            }
        }
    }
}
