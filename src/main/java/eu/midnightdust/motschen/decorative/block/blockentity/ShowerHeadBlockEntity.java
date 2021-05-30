package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShowerHeadBlockEntity extends BlockEntity {

    public ShowerHeadBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ShowerHeadBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ShowerHeadBlockEntity blockEntity) {
        if (state.get(PoolSprinkler.POWERED)) {
            switch (state.get(PoolSprinkler.FACING)) {
                case NORTH: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.625, 1, 1, 1); break;
                case EAST: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.375, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 1, 1); break;
                case SOUTH: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.375, 1, 1, 1); break;
                case WEST: world.addParticle(ParticleTypes.DRIPPING_WATER, pos.getX() + 0.625, pos.getY() + 0.5, pos.getZ() + 0.5, 1, 1, 1); break;
                default: break;
            }
        }

    }
}
