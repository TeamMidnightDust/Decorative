package eu.midnightdust.motschen.decorative.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class ChristmasTree extends Block{
    private static final VoxelShape SHAPE;

    public ChristmasTree() {
        super(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        VoxelShape shape = createCuboidShape(0, 0, 0, 16, 32, 16);
        SHAPE = shape;
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

}
