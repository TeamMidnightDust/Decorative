package eu.midnightdust.motschen.decorative.block;

import com.mojang.serialization.MapCodec;
import eu.midnightdust.motschen.decorative.block.blockentity.ChoppingLogBlockEntity;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayChoppingLogModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

public class ChoppingLog extends BlockWithEntity implements BlockEntityProvider, FactoryBlock {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;

    public ChoppingLog() {
        super(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS).nonOpaque().sounds(BlockSoundGroup.WOOD));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return this.getDefaultState().with(FACING, itemPlacementContext.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new ChoppingLogBlockEntity(pos, state);
    }
    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return validateTicker(type, BlockEntities.ChoppingLogBlockEntity, ChoppingLogBlockEntity::tick);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return null;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return switch (state.getBlock().getTranslationKey()) {
            case "block.decorative.oak_log_with_axe" -> Blocks.OAK_LOG.getDefaultState();
            case "block.decorative.spruce_log_with_axe" -> Blocks.SPRUCE_LOG.getDefaultState();
            case "block.decorative.birch_log_with_axe" -> Blocks.BIRCH_LOG.getDefaultState();
            case "block.decorative.acacia_log_with_axe" -> Blocks.ACACIA_LOG.getDefaultState();
            case "block.decorative.dark_oak_log_with_axe" -> Blocks.DARK_OAK_LOG.getDefaultState();
            case "block.decorative.jungle_log_with_axe" -> Blocks.JUNGLE_LOG.getDefaultState();
            case "block.decorative.warped_stem_with_axe" -> Blocks.WARPED_STEM.getDefaultState();
            case "block.decorative.crimson_stem_with_axe" -> Blocks.CRIMSON_STEM.getDefaultState();
            case "block.decorative.cherry_log_with_axe" -> Blocks.CHERRY_LOG.getDefaultState();
            case "block.decorative.mangrove_log_with_axe" -> Blocks.MANGROVE_LOG.getDefaultState();
            default -> Blocks.BARRIER.getDefaultState();
        };
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.STONE_BUTTON.getDefaultState().with(Properties.BLOCK_FACE, BlockFace.FLOOR);
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplayChoppingLogModel(initialBlockState, pos);
    }

}
