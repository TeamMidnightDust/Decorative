package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.time.LocalTime;

public class WallClockBlockEntity extends BlockEntity implements Tickable {
    private int facing;
    private double x;
    private double z;
    private int second;

    public WallClockBlockEntity() {
        super(BlockEntities.WallClockBlockEntity);
    }

    @Override
    public void tick() {
        if (LocalTime.now().getSecond() != second) {
            second = LocalTime.now().getSecond();
            world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.004f, 1f);
        }

        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);


        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.EAST) {
            facing = 270;
            x = 0.05;
            z = 0.5;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.SOUTH) {
            facing = 180;
            x = 0.5;
            z = 0.05;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.WEST) {
            facing = 90;
            x = 0.95;
            z = 0.5;
            return;
        }
        else {
            facing = 0;
            x = 0.5;
            z = 0.95;
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
