package eu.midnightdust.motschen.decorative.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class BirdBath extends CauldronBlock {
    private static final VoxelShape SHAPE;

    public BirdBath() {
        super(FabricBlockSettings.copy(Blocks.CAULDRON).nonOpaque().sounds(BlockSoundGroup.STONE));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(LEVEL, 0);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
            return SHAPE;
    }
    static {
        VoxelShape shape = createCuboidShape(4, 0, 4, 12, 9, 12);
        SHAPE = shape;
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

}
