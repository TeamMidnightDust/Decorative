package eu.midnightdust.motschen.decorative.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Objects;

public class BirdBath extends AbstractCauldronBlock {
    private static final VoxelShape SHAPE;
    public static final IntProperty LEVEL = IntProperty.of("level",0,3);

    public BirdBath() {
        super(FabricBlockSettings.copy(Blocks.WATER_CAULDRON).nonOpaque().sounds(BlockSoundGroup.STONE), CauldronBehavior.WATER_CAULDRON_BEHAVIOR);
    }
    @Override
    public boolean isFull(BlockState state) {
        return state.get(LEVEL) == 3;
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return fluid == Fluids.WATER;
    }
    @Override
    protected double getFluidHeight(BlockState state) {
        return (6.0D + (double)state.get(LEVEL) * 3.0D) / 16.0D;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }
    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (!this.isFull(state)) {
            world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) + 1));
            world.syncWorldEvent(1047, pos, 0);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return Objects.requireNonNull(super.getPlacementState(itemPlacementContext))
                .with(LEVEL, 0);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
            return SHAPE;
    }
    static {
        SHAPE = createCuboidShape(4, 0, 4, 12, 9, 12);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

}
