package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.block.blockentity.ShowerHeadBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

public class ShowerHead extends HorizontalFacingBlock implements BlockEntityProvider {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    public static final BooleanProperty POWERED = DoorBlock.POWERED;

    public ShowerHead() {
        super(FabricBlockSettings.copy(Blocks.STONE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(POWERED, Boolean.FALSE));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.setBlockState(pos, state.with(POWERED, Boolean.valueOf(!state.get(POWERED))));
        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 0.5f);
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(FACING, itemPlacementContext.getPlayerFacing().getOpposite())
                .with(POWERED, Boolean.FALSE);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(POWERED);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH: return NORTH_SHAPE;
            case EAST: return EAST_SHAPE;
            case SOUTH: return SOUTH_SHAPE;
            case WEST: return WEST_SHAPE;
            default: return super.getOutlineShape(state, view, pos, context);
        }
    }
    static {
        VoxelShape pipe = createCuboidShape(7, 12, 8.75, 9, 14, 16);
        VoxelShape pivot_pipe = createCuboidShape(7, 12, 8.25, 9, 13, 11);
        VoxelShape pivot_pipe2 = createCuboidShape(7, 10.5, 7.25, 9, 12, 11);
        VoxelShape head = createCuboidShape(4, 9.75, 5, 12, 11.25, 13);
        VoxelShape shape = VoxelShapes.union(pipe, head, pivot_pipe, pivot_pipe2);

        NORTH_SHAPE = shape;
        WEST_SHAPE = rotate(Direction.EAST, Direction.NORTH, shape);
        EAST_SHAPE = rotate(Direction.EAST, Direction.SOUTH, shape);
        SOUTH_SHAPE = rotate(Direction.EAST, Direction.WEST, shape);
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
    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.north()) | !worldView.isAir(pos.east()) | !worldView.isAir(pos.south()) | !worldView.isAir(pos.west());
    }
    @Override
    public BlockEntity createBlockEntity(BlockView world) {
        return new ShowerHeadBlockEntity();
    }

}
