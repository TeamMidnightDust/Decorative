package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.polymer.model.SimpleItemDisplayModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ShapeContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class TrafficCone extends Block implements FactoryBlock {
    private static final VoxelShape SHAPE;

    public TrafficCone() {
        super(AbstractBlock.Settings.copy(Blocks.STONE).nonOpaque().sounds(BlockSoundGroup.STONE));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        SHAPE = createCuboidShape(4, 0, 4, 12, 11.5, 12);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.ORANGE_CONCRETE.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new SimpleItemDisplayModel(initialBlockState);
    }

}
