package eu.midnightdust.motschen.decorative.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class Lamp extends Block {
    private static final VoxelShape SHAPE;
    public static final BooleanProperty LIT = RedstoneLampBlock.LIT;

    public Lamp() {
        super(FabricBlockSettings.copy(Blocks.REDSTONE_LAMP).nonOpaque().sounds(BlockSoundGroup.STONE));
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

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        world.setBlockState(pos, state.with(LIT, Boolean.valueOf(!state.get(LIT))));
        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 0.5f);
        return ActionResult.SUCCESS;
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        VoxelShape shape = createCuboidShape(4, 0, 4, 12, 10, 12);
        SHAPE = shape;
    }
}
