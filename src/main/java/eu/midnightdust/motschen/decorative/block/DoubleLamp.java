package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayDoubleLampModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class DoubleLamp extends Block implements FactoryBlock {
    private static final VoxelShape SHAPE_TOP;
    private static final VoxelShape SHAPE_BOTTOM;

    public static final BooleanProperty LIT = RedstoneLampBlock.LIT;
    public static final EnumProperty<DoubleBlockHalf> HALF = Properties.DOUBLE_BLOCK_HALF;

    public DoubleLamp() {
        super(AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false).with(HALF, DoubleBlockHalf.LOWER));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.setBlockState(pos, state.with(LIT, !state.get(LIT)));
        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 0.5f);
        return ActionResult.SUCCESS;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext arg) {
        return this.getDefaultState().with(LIT, arg.getWorld().isReceivingRedstonePower(arg.getBlockPos()));
    }

    @Override
    public void onPlaced(World arg, BlockPos arg2, BlockState arg3, LivingEntity arg4, ItemStack arg5) {
        arg.setBlockState(arg2.up(), arg3.with(HALF, DoubleBlockHalf.UPPER), 3);
    }
    @Override
    public BlockState getStateForNeighborUpdate(BlockState arg, Direction arg2, BlockState arg3, WorldAccess arg4, BlockPos arg5, BlockPos arg6) {
        DoubleBlockHalf lv = arg.get(HALF);
        if (arg2.getAxis() == Direction.Axis.Y && lv == DoubleBlockHalf.LOWER == (arg2 == Direction.UP)) {
            if (arg3.isOf(this) && arg3.get(HALF) != lv) {
                return (arg.with(LIT, arg3.get(LIT)));
            }
            return Blocks.AIR.getDefaultState();
        }
        if (lv == DoubleBlockHalf.LOWER && arg2 == Direction.DOWN && !arg.canPlaceAt(arg4, arg5)) {
            return Blocks.AIR.getDefaultState();
        }
        return super.getStateForNeighborUpdate(arg, arg2, arg3, arg4, arg5, arg6);
    }

    @Override
    public boolean canPlaceAt(BlockState arg, WorldView arg2, BlockPos arg3) {
        BlockPos lv = arg3.down();
        BlockState lv2 = arg2.getBlockState(lv);
        if (arg.get(HALF) == DoubleBlockHalf.LOWER) {
            return lv2.isSideSolidFullSquare(arg2, lv, Direction.UP);
        }
        return lv2.isOf(this);
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> arg) {
        arg.add(LIT);
        arg.add(HALF);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        boolean bl = state.get(HALF) == DoubleBlockHalf.UPPER;
        return bl ? SHAPE_TOP : SHAPE_BOTTOM;
    }
    static {
        VoxelShape shape_top = createCuboidShape(4, -16, 4, 12, 10, 12);
        VoxelShape shape_bottom = createCuboidShape(4, 0, 4, 12, 26, 12);
        SHAPE_TOP = shape_top;
        SHAPE_BOTTOM = shape_bottom;
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.WHITE_WOOL.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplayDoubleLampModel(initialBlockState);
    }
}
