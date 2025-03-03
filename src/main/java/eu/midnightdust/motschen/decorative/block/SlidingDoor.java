package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplaySlidingDoorModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class SlidingDoor extends DoorBlock implements FactoryBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape NORTH_SHAPE_OPEN;
    private static final VoxelShape EAST_SHAPE_OPEN;
    private static final VoxelShape SOUTH_SHAPE_OPEN;
    private static final VoxelShape WEST_SHAPE_OPEN;

    public SlidingDoor() {
        super(new BlockSetType("sliding_door", true, true, true, BlockSetType.ActivationRule.EVERYTHING, BlockSoundGroup.GLASS, SoundEvents.BLOCK_BARREL_CLOSE, SoundEvents.BLOCK_BARREL_OPEN, SoundEvents.BLOCK_WOODEN_TRAPDOOR_CLOSE, SoundEvents.BLOCK_WOODEN_TRAPDOOR_OPEN, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_OFF, SoundEvents.BLOCK_WOODEN_PRESSURE_PLATE_CLICK_ON, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON),
                AbstractBlock.Settings.copy(Blocks.WHITE_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE));
    }
    protected void playOpenCloseSound(World world, BlockPos pos, boolean open) {
        world.playSound(null, pos, open ? SoundEvents.BLOCK_BARREL_OPEN : SoundEvents.BLOCK_BARREL_CLOSE, SoundCategory.BLOCKS, 1.0F, world.getRandom().nextFloat() * 0.1F + 0.9F);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        setOpen(player, world, state, pos, !state.get(OPEN));
        return ActionResult.SUCCESS;
    }

    @Override
    protected void neighborUpdate(BlockState state, World world, BlockPos pos, Block sourceBlock, BlockPos sourcePos, boolean notify) {
        boolean bl = world.isReceivingRedstonePower(pos) || world.isReceivingRedstonePower(pos.offset(state.get(HALF) == DoubleBlockHalf.LOWER ? Direction.UP : Direction.DOWN));
        if (!this.getDefaultState().isOf(sourceBlock) && bl != state.get(POWERED)) {
            if (bl != state.get(OPEN)) {
                world.emitGameEvent(null, bl ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);
            }

            world.setBlockState(pos, state.with(POWERED, bl));
            setOpen(null, world, state, pos, bl);
        }

    }

    @Override
    public void setOpen(@Nullable Entity entity, World world, BlockState state, BlockPos pos, boolean open) {
        if (state.isOf(this) && state.get(OPEN) != open) {
            world.setBlockState(pos, state.with(OPEN, open), 10);
            this.playOpenCloseSound(world, pos, open);
            world.emitGameEvent(entity, open ? GameEvent.BLOCK_OPEN : GameEvent.BLOCK_CLOSE, pos);

            for (Direction dir : new Direction[]{Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST}) {
                BlockState neighbourState = world.getBlockState(pos.offset(dir));
                if (neighbourState.isOf(this)) {
                    world.setBlockState(pos.offset(dir), neighbourState.with(OPEN, open), 10);
                }
            }
        }
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        state.get(FACING);
        boolean bl = !state.get(OPEN);
        boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;
        return switch (state.get(FACING)) {
            case NORTH -> bl ? NORTH_SHAPE : (bl2 ? SOUTH_SHAPE_OPEN : NORTH_SHAPE_OPEN);
            case EAST -> bl ? EAST_SHAPE : (bl2 ? WEST_SHAPE_OPEN : EAST_SHAPE_OPEN);
            case SOUTH -> bl ? SOUTH_SHAPE : (bl2 ? NORTH_SHAPE_OPEN : SOUTH_SHAPE_OPEN);
            default -> bl ? WEST_SHAPE : (bl2 ? EAST_SHAPE_OPEN : WEST_SHAPE_OPEN);
        };
    }
    static {
        VoxelShape shape = createCuboidShape(0, 0, 7, 16, 16, 9);
        VoxelShape shape_open = createCuboidShape(-12, 0, 7, 4, 16, 9);

        NORTH_SHAPE = shape;
        WEST_SHAPE = rotate(Direction.EAST, Direction.NORTH, shape);
        EAST_SHAPE = rotate(Direction.EAST, Direction.SOUTH, shape);
        SOUTH_SHAPE = rotate(Direction.EAST, Direction.WEST, shape);
        NORTH_SHAPE_OPEN = shape_open;
        WEST_SHAPE_OPEN = rotate(Direction.EAST, Direction.NORTH, shape_open);
        EAST_SHAPE_OPEN = rotate(Direction.EAST, Direction.SOUTH, shape_open);
        SOUTH_SHAPE_OPEN = rotate(Direction.EAST, Direction.WEST, shape_open);
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

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return state.get(OPEN) ? Blocks.STRUCTURE_VOID.getDefaultState() : Blocks.BARRIER.getDefaultState();
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.WHITE_CONCRETE.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplaySlidingDoorModel(initialBlockState);
    }
}