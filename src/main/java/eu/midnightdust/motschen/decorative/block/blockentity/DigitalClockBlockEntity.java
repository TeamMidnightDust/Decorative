package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.time.LocalTime;

public class DigitalClockBlockEntity extends BlockEntity implements Tickable {
    private int facing;
    private double x;
    private double z;
    private int second;

    public DigitalClockBlockEntity() {
        super(BlockEntities.DigitalClockBlockEntity);
    }

    @Override
    public void tick() {
        if (LocalTime.now().getSecond() != second) {
            second = LocalTime.now().getSecond();
        }

        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);


        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.EAST) {
            facing = 270;
            x = 0.626;
            z = 0.825;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.SOUTH) {
            facing = 180;
            x = 0.175;
            z = 0.626;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.WEST) {
            facing = 90;
            x = 0.374;
            z = 0.175;
            return;
        }
        else {
            facing = 0;
            x = 0.825;
            z = 0.374;
            return;
        }

    }
    public int getFacing() {
        return facing;
    }
    public double getX() {
        return x;
    }
    public double getZ() {
        return z;
    }
}
