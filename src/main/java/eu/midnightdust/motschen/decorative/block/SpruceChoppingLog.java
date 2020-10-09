package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.block.blockentity.SpruceChoppingLogBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class SpruceChoppingLog extends HorizontalFacingBlock implements BlockEntityProvider {

    public SpruceChoppingLog() {
        super(FabricBlockSettings.copy(Blocks.OAK_PLANKS).nonOpaque().sounds(BlockSoundGroup.WOOD));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(FACING, itemPlacementContext.getPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new SpruceChoppingLogBlockEntity();
    }

}
