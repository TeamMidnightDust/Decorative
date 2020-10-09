package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

public class JungleChoppingLogBlockEntity extends BlockEntity implements Tickable {
    private int facing;
    private double axe_x;
    private double axe_z;

    public JungleChoppingLogBlockEntity() {
        super(BlockEntities.JungleChoppingLogBlockEntity);
    }

    @Override
    public void tick() {

        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);

        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.EAST) {
            facing = 180;
            axe_x = 0.2D;
            axe_z = 0.5D;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.SOUTH) {
            facing = 90;
            axe_x = 0.5D;
            axe_z = 0.2D;
            return;
        }
        if (world != null && state.get(HorizontalFacingBlock.FACING) == Direction.WEST) {
            facing = 0;
            axe_x = 0.8D;
            axe_z = 0.5D;
            return;
        }
        else {
            facing = 270;
            axe_x = 0.5D;
            axe_z = 0.8D;
            return;
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
