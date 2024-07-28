package eu.midnightdust.motschen.decorative.block;

import com.mojang.serialization.MapCodec;
import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.blockstates.PoolShape;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.Waterloggable;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class PoolWall extends HorizontalFacingBlock implements Waterloggable {
    public static final DirectionProperty FACING = DoorBlock.FACING;
    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    public static final EnumProperty<PoolShape> SHAPE = DecorativeMain.POOL_SHAPE;
    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape NORTH_WEST_CORNER_SHAPE;
    private static final VoxelShape SOUTH_WEST_CORNER_SHAPE;
    private static final VoxelShape NORTH_EAST_CORNER_SHAPE;
    private static final VoxelShape SOUTH_EAST_CORNER_SHAPE;


    public PoolWall() {
        super(AbstractBlock.Settings.copy(Blocks.STONE_STAIRS).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(SHAPE, PoolShape.STRAIGHT).with(WATERLOGGED, false));
    }

    @Override
    public FluidState getFluidState(BlockState blockState_1) {
        return blockState_1.get(WATERLOGGED) ? Fluids.WATER.getStill(true) : super.getFluidState(blockState_1);
    }

    public BlockState getPlacementState(ItemPlacementContext ctx) {
        BlockPos blockPos = ctx.getBlockPos();
        FluidState fluidState = ctx.getWorld().getFluidState(blockPos);
        BlockState blockState = this.getDefaultState().with(FACING, ctx.getPlayerLookDirection().getOpposite()).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
        return blockState.with(SHAPE, getPoolShape(blockState, ctx.getWorld(), blockPos));
    }

    private static PoolShape getPoolShape(BlockState state, BlockView view, BlockPos pos) {
        Direction direction = state.get(FACING).getOpposite();
        BlockState blockState2 = view.getBlockState(pos.offset(direction.getOpposite()));
        if (isPoolWall(blockState2)) {
            Direction direction3 = blockState2.get(FACING).getOpposite();
            if (direction3.getAxis() != (state.get(FACING).getOpposite()).getAxis() && getSide(state, view, pos, direction3)) {
                if (direction3 == direction.rotateYCounterclockwise()) {
                    return PoolShape.INNER_LEFT;
                }

                return PoolShape.INNER_RIGHT;
            }
        }

        return PoolShape.STRAIGHT;
    }

    private static boolean getSide(BlockState state, BlockView view, BlockPos pos, Direction dir) {
        BlockState blockState = view.getBlockState(pos.offset(dir));
        return !isPoolWall(blockState) || blockState.get(FACING) != state.get(FACING);
    }

    public static boolean isPoolWall(BlockState state) {
        return state.getBlock() instanceof PoolWall;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING,SHAPE,WATERLOGGED);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> switch (state.get(SHAPE)) {
                case STRAIGHT -> NORTH_SHAPE;
                case INNER_LEFT -> NORTH_WEST_CORNER_SHAPE;
                case INNER_RIGHT -> NORTH_EAST_CORNER_SHAPE;
            };
            case EAST -> switch (state.get(SHAPE)) {
                case STRAIGHT -> EAST_SHAPE;
                case INNER_LEFT -> NORTH_EAST_CORNER_SHAPE;
                case INNER_RIGHT -> SOUTH_EAST_CORNER_SHAPE;
            };
            case SOUTH -> switch (state.get(SHAPE)) {
                case STRAIGHT -> SOUTH_SHAPE;
                case INNER_LEFT -> SOUTH_EAST_CORNER_SHAPE;
                case INNER_RIGHT -> SOUTH_WEST_CORNER_SHAPE;
            };
            case WEST -> switch (state.get(SHAPE)) {
                case STRAIGHT -> WEST_SHAPE;
                case INNER_LEFT -> SOUTH_WEST_CORNER_SHAPE;
                case INNER_RIGHT -> NORTH_WEST_CORNER_SHAPE;
            };
            default -> super.getOutlineShape(state, view, pos, context);
        };
    }
    static {
        VoxelShape base = createCuboidShape(0, 0, 15, 16, 16, 16);
        VoxelShape corner = createCuboidShape(15, 0, 0, 16, 16, 16);
        VoxelShape corner_shapes = VoxelShapes.union(base, corner);

        NORTH_SHAPE = base;
        WEST_SHAPE = rotate(Direction.EAST, Direction.NORTH, base);
        EAST_SHAPE = rotate(Direction.EAST, Direction.SOUTH, base);
        SOUTH_SHAPE = rotate(Direction.EAST, Direction.WEST, base);
        NORTH_WEST_CORNER_SHAPE = corner_shapes;
        SOUTH_WEST_CORNER_SHAPE = rotate(Direction.EAST, Direction.NORTH, corner_shapes);
        NORTH_EAST_CORNER_SHAPE = rotate(Direction.EAST, Direction.SOUTH, corner_shapes);
        SOUTH_EAST_CORNER_SHAPE = rotate(Direction.EAST, Direction.WEST, corner_shapes);
    }
    private static VoxelShape rotate(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{ shape, VoxelShapes.empty() };

        int times = (to.getHorizontal() - from.getHorizontal() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = VoxelShapes.union(buffer[1], VoxelShapes.cuboid(1-maxZ, minY, minX, 1-minZ, maxY, maxX)));
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }
}
