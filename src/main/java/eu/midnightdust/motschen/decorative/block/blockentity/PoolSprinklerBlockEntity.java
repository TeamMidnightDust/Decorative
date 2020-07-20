package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.init.Pool;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

public class PoolSprinklerBlockEntity extends BlockEntity implements Tickable {

    public PoolSprinklerBlockEntity() {
        super(BlockEntities.PoolSprinklerBlockEntity);
    }

    @Override
    public void tick() {
        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);
        if (world != null && state.get(PoolSprinkler.POWERED) == true) {
            switch (state.get(PoolSprinkler.FACING)) {
                case NORTH: world.addParticle(ParticleTypes.DRIPPING_WATER,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()-0.34,1,1,1); return;
                case EAST: world.addParticle(ParticleTypes.DRIPPING_WATER,pos.getX()+1.34,pos.getY()+0.5,pos.getZ()+0.5,1,1,1); return;
                case SOUTH: world.addParticle(ParticleTypes.DRIPPING_WATER,pos.getX()+0.5,pos.getY()+0.5,pos.getZ()+1.34,1,1,1); return;
                case WEST: world.addParticle(ParticleTypes.DRIPPING_WATER,pos.getX()-0.34,pos.getY()+0.5,pos.getZ()+0.5,1,1,1); return;
                default: return;
            }
        }
    }
}
