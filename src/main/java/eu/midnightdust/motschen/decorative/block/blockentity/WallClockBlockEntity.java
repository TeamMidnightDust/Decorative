package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.LocalTime;

public class WallClockBlockEntity extends BlockEntity {
    public int facing;
    public double x;
    public double z;
    public int second;

    public WallClockBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.WallClockBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, WallClockBlockEntity blockEntity) {
        if (LocalTime.now().getSecond() != blockEntity.second) {
            blockEntity.second = LocalTime.now().getSecond();
            world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.04f, 1f);
        }

        switch (state.get(HorizontalFacingBlock.FACING)) {
            case NORTH: {
                blockEntity.facing = 0;
                blockEntity.x = 0.5;
                blockEntity.z = 0.95;
                break;
            }
            case EAST: {
                blockEntity.facing = 270;
                blockEntity.x = 0.05;
                blockEntity.z = 0.5;
                break;
            }
            case SOUTH: {
                blockEntity.facing = 180;
                blockEntity.x = 0.5;
                blockEntity.z = 0.05;
                break;
            }
            case WEST: {
                blockEntity.facing = 90;
                blockEntity.x = 0.95;
                blockEntity.z = 0.5;
                break;
            }
            default: break;
        }
    }
}
