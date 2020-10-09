package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.blockstates.Program;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
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

import java.util.function.ToIntFunction;

public class OldTelevision extends HorizontalFacingBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final EnumProperty<Program> PROGRAM = DecorativeMain.PROGRAM;

    public OldTelevision() {
        super(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE).lightLevel(createLightLevelFromBlockState(15)));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(PROGRAM, Program.OFF));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
            switch (state.get(PROGRAM)) {
                case OFF: world.setBlockState(pos, state.with(PROGRAM, Program.NYANCAT));
                    world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
                    return ActionResult.SUCCESS;
                case NYANCAT: world.setBlockState(pos, state.with(PROGRAM, Program.CREEPER));
                    world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
                    return ActionResult.SUCCESS;
                case CREEPER: world.setBlockState(pos, state.with(PROGRAM, Program.WOODYS));
                    world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
                    return ActionResult.SUCCESS;
                case WOODYS: world.setBlockState(pos, state.with(PROGRAM, Program.TATER));
                    world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
                    return ActionResult.SUCCESS;
                case TATER: world.setBlockState(pos, state.with(PROGRAM, Program.OFF));
                    world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
                    return ActionResult.SUCCESS;
            }
            return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(FACING, itemPlacementContext.getPlayerFacing().getOpposite())
                .with(PROGRAM, Program.OFF);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(PROGRAM);
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
        VoxelShape shape = createCuboidShape(0, 0, 1, 16, 14, 14);

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
        return !worldView.isAir(pos.down());
    }

    private static ToIntFunction<BlockState> createLightLevelFromBlockState(int litLevel) {
        return (blockState) -> {
            if (blockState.get(PROGRAM) == Program.OFF) {
                return 0;
            }
            else {
                return 11;
            }
        };
    }

}
