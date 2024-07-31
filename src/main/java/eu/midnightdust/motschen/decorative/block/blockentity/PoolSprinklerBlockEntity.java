package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.util.ParticleUtil;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class PoolSprinklerBlockEntity extends BlockEntity {

    public PoolSprinklerBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.PoolSprinklerBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, PoolSprinklerBlockEntity blockEntity) {
        if (state.get(PoolSprinkler.POWERED) && !world.isClient) {
            Vec3d particlePos = switch (state.get(PoolSprinkler.FACING)) {
                case NORTH -> new Vec3d( pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() - 0.34);
                case EAST -> new Vec3d(pos.getX() + 1.34, pos.getY() + 0.5, pos.getZ() + 0.5);
                case SOUTH -> new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 1.34);
                case WEST -> new Vec3d(pos.getX() - 0.34, pos.getY() + 0.5, pos.getZ() + 0.5);
                default -> Vec3d.ZERO;
            };
            PlayerLookup.tracking(blockEntity).forEach(watchingPlayer -> ParticleUtil.spawnParticle(watchingPlayer, ParticleTypes.DRIPPING_WATER, particlePos, new Vec3d(0, 0, 0), 1));
        }
    }
}
