package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ChoppingLogBlockEntity extends BlockEntity {
    private int facing;
    private double axe_x;
    private double axe_z;

    public ChoppingLogBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.ChoppingLogBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, ChoppingLogBlockEntity blockEntity) {
        if (state.get(HorizontalFacingBlock.FACING) == Direction.EAST) {
            blockEntity.facing = 180;
            blockEntity.axe_x = 0.2D;
            blockEntity.axe_z = 0.5D;
        }
        else if (state.get(HorizontalFacingBlock.FACING) == Direction.SOUTH) {
            blockEntity.facing = 90;
            blockEntity.axe_x = 0.5D;
            blockEntity.axe_z = 0.2D;
        }
        else if (state.get(HorizontalFacingBlock.FACING) == Direction.WEST) {
            blockEntity.facing = 0;
            blockEntity.axe_x = 0.8D;
            blockEntity.axe_z = 0.5D;
        }
        else {
            blockEntity.facing = 270;
            blockEntity.axe_x = 0.5D;
            blockEntity.axe_z = 0.8D;
        }
    }

    public int getFacing() {
        return facing;
    }
    public double getAxeX() {
        return axe_x;
    }
    public double getAxeZ() {
        return axe_z;
    }
}
