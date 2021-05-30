package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.blockstates.CeilingFanStage;
import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.CeilingFanBlockEntity;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.BrewingStandBlockEntity;
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
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class CeilingFan extends BlockWithEntity implements BlockEntityProvider {
    private static final VoxelShape SHAPE;
    private static final EnumProperty<CeilingFanStage> STAGE = DecorativeMain.STAGE;

    public CeilingFan() {
        super(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(STAGE, CeilingFanStage.OFF));
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CeilingFanBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, BlockEntities.CeilingFanBlockEntity, CeilingFanBlockEntity::tick);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return super.getPlacementState(itemPlacementContext)
                .with(STAGE, CeilingFanStage.OFF);
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (state.get(STAGE) == CeilingFanStage.OFF) {world.setBlockState(pos, state.with(STAGE, CeilingFanStage.LEVEL_1));}
        if (state.get(STAGE) == CeilingFanStage.LEVEL_1) {world.setBlockState(pos, state.with(STAGE, CeilingFanStage.LEVEL_2));}
        if (state.get(STAGE) == CeilingFanStage.LEVEL_2) {world.setBlockState(pos, state.with(STAGE, CeilingFanStage.LEVEL_3));}
        if (state.get(STAGE) == CeilingFanStage.LEVEL_3) {world.setBlockState(pos, state.with(STAGE, CeilingFanStage.OFF));}

        world.playSound(player, pos, SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.2f, 0.5f);
        return ActionResult.SUCCESS;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }
    static {
        VoxelShape shape = createCuboidShape(-3, 5, -3, 19, 16, 19);
        SHAPE = shape;
    }
    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.up());
    }

}
