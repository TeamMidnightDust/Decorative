package eu.midnightdust.motschen.decorative.block;

import com.mojang.serialization.MapCodec;
import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class RotatableBlock extends HorizontalFacingBlock implements PolymerTexturedBlock {
    public BlockState MODEL_NORMAL;
    public BlockState MODEL_ROTATED;

    public RotatableBlock(Identifier id) {
        super(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
        MODEL_NORMAL = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(id("block/"+id.getPath())));
        MODEL_ROTATED = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(id("block/"+id.getPath()), 0, 90));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return this.getDefaultState().with(FACING, itemPlacementContext.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return switch (state.get(FACING)) {
            case NORTH, SOUTH -> MODEL_NORMAL;
            default -> MODEL_ROTATED;
        };
    }
}
