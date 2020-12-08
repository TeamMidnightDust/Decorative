package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.block.blockentity.SmokeDetectorBlockEntity;
import eu.midnightdust.motschen.decorative.block.blockentity.WallClockBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class SmokeDetector extends HorizontalFacingBlock implements BlockEntityProvider {
    private static final VoxelShape SHAPE;
    public static final BooleanProperty ACTIVE = BooleanProperty.of("active");

    public SmokeDetector() {
        super(FabricBlockSettings.copy(Blocks.SMOOTH_QUARTZ).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(ACTIVE, false));
    }

    @Override
    public BlockEntity createBlockEntity(BlockView view) {
        return new SmokeDetectorBlockEntity();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVE);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        VoxelShape shape = createCuboidShape(4, 14, 4, 12, 16, 12);

        SHAPE = shape;
    }
}
