package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.block.ShowerHead;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.util.ParticleUtil;
import net.fabricmc.fabric.api.networking.v1.PlayerLookup;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ShowerHeadBlockEntity extends BlockEntity {

    public ShowerHeadBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ShowerHeadBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ShowerHeadBlockEntity blockEntity) {
        if (state.get(ShowerHead.POWERED) && !world.isClient) {
            Vec3d particlePos = switch (state.get(ShowerHead.FACING)) {
                case NORTH -> new Vec3d( pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.625);
                case EAST -> new Vec3d(pos.getX() + 0.375, pos.getY() + 0.5, pos.getZ() + 0.5);
                case SOUTH -> new Vec3d(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.375);
                case WEST -> new Vec3d(pos.getX() + 0.625, pos.getY() + 0.5, pos.getZ() + 0.5);
                default -> Vec3d.ZERO;
            };
            PlayerLookup.tracking(blockEntity).forEach(watchingPlayer -> ParticleUtil.spawnParticle(watchingPlayer, ParticleTypes.DRIPPING_WATER, particlePos, new Vec3d(1, 0, 1), 1));
        }

    }
}
