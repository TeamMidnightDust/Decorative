package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.LocalTime;

public class DigitalClockBlockEntity extends BlockEntity {
    private int facing;
    private double x;
    private double z;
    private int second;

    public DigitalClockBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.DigitalClockBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, DigitalClockBlockEntity blockEntity) {
        if (LocalTime.now().getSecond() != blockEntity.second) {
            blockEntity.second = LocalTime.now().getSecond();
        }
        switch (state.get(HorizontalFacingBlock.FACING)) {
            case NORTH: {
                blockEntity.facing = 0;
                blockEntity.x = 0.825;
                blockEntity.z = 0.374;
                break;
            }
            case EAST:{
                blockEntity.facing = 270;
                blockEntity.x = 0.626;
                blockEntity.z = 0.825;
                break;
            }
            case SOUTH:{
                blockEntity.facing = 180;
                blockEntity.x = 0.175;
                blockEntity.z = 0.626;
                break;
            }
            case WEST:{
                blockEntity.facing = 90;
                blockEntity.x = 0.374;
                blockEntity.z = 0.175;
                break;
            }
            default: break;
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
