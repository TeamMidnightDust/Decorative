package eu.midnightdust.motschen.decorative.block;

import com.mojang.serialization.MapCodec;
import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.blockstates.Program;
import eu.pb4.factorytools.api.block.FactoryBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;

import java.util.Objects;
import java.util.function.ToIntFunction;

public class Television extends HorizontalFacingBlock implements FactoryBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final EnumProperty<Program> PROGRAM = DecorativeMain.PROGRAM;

    public Television() {
        super(AbstractBlock.Settings.copy(Blocks.BLACK_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE).luminance(createLightLevelFromBlockState()));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(PROGRAM, Program.OFF));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.setBlockState(pos, state.with(PROGRAM, state.get(PROGRAM).next()));
        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 1.5f);
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return Objects.requireNonNull(super.getPlacementState(itemPlacementContext))
                .with(FACING, itemPlacementContext.getPlayerLookDirection().getOpposite())
                .with(PROGRAM, Program.OFF);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(PROGRAM);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> NORTH_SHAPE;
            case EAST -> EAST_SHAPE;
            case SOUTH -> SOUTH_SHAPE;
            case WEST -> WEST_SHAPE;
            default -> super.getOutlineShape(state, view, pos, context);
        };
    }
    static {
        VoxelShape shape = createCuboidShape(-7, 4, 7, 22, 22, 9);

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

    private static ToIntFunction<BlockState> createLightLevelFromBlockState() {
        return (blockState) -> {
            if (blockState.get(PROGRAM) == Program.OFF) {
                return 0;
            }
            else {
                return 11;
            }
        };
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
        return null;
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }
}
