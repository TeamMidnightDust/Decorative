package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayLampModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RedstoneLampBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class Lamp extends Block implements FactoryBlock {
    private static final VoxelShape SHAPE;
    public static final BooleanProperty LIT = RedstoneLampBlock.LIT;

    public Lamp() {
        super(AbstractBlock.Settings.copy(Blocks.REDSTONE_LAMP).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(LIT, false));
    }
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> arg) {
        arg.add(LIT);
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext arg) {
        return this.getDefaultState().with(LIT, arg.getWorld().isReceivingRedstonePower(arg.getBlockPos()));
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        world.setBlockState(pos, state.with(LIT, !state.get(LIT)));
        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 0.5f);
        return ActionResult.SUCCESS;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        SHAPE = createCuboidShape(4, 0, 4, 12, 10, 12);
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
        return new ItemDisplayLampModel(initialBlockState);
    }
}
