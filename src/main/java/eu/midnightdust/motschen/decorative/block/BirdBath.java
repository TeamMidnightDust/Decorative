package eu.midnightdust.motschen.decorative.block;

import com.mojang.serialization.MapCodec;
import eu.midnightdust.motschen.decorative.polymer.model.ItemDisplayBirdBathModel;
import eu.pb4.factorytools.api.block.FactoryBlock;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import net.minecraft.block.*;
import net.minecraft.block.cauldron.CauldronBehavior;
import net.minecraft.block.enums.BlockFace;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class BirdBath extends AbstractCauldronBlock implements FactoryBlock {
    private static final VoxelShape SHAPE;
    public static final IntProperty LEVEL = IntProperty.of("level",0,3);

    public BirdBath() {
        super(AbstractBlock.Settings.copy(Blocks.WATER_CAULDRON).nonOpaque().sounds(BlockSoundGroup.STONE), CauldronBehavior.WATER_CAULDRON_BEHAVIOR);
    }
    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (stack.getItem().equals(Items.WATER_BUCKET) || (stack.getItem().equals(Items.POTION) && stack.getComponents().contains(DataComponentTypes.POTION_CONTENTS) && stack.getComponents().get(DataComponentTypes.POTION_CONTENTS).matches(Potions.WATER))) {
            if (stack.getItem().equals(Items.WATER_BUCKET)) {
                world.setBlockState(pos, state.with(LEVEL, 3));
                if (!player.isCreative()) player.setStackInHand(hand, new ItemStack(Items.BUCKET));
                return ItemActionResult.SUCCESS;
            }
            else if (!state.get(LEVEL).equals(3)) {
                world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) + 1));
                if (!player.isCreative()) player.setStackInHand(hand, new ItemStack(Items.GLASS_BOTTLE));
                return ItemActionResult.SUCCESS;
            }
        }
        if (stack.getItem().equals(Items.BUCKET) || (stack.getItem().equals(Items.GLASS_BOTTLE))) {
            if (stack.getItem().equals(Items.BUCKET) && state.get(LEVEL).equals(3)) {
                world.setBlockState(pos, state.with(LEVEL, 0));
                if (!player.isCreative()) player.setStackInHand(hand, new ItemStack(Items.WATER_BUCKET));
                return ItemActionResult.SUCCESS;
            }
            else if (!stack.getItem().equals(Items.BUCKET) && !state.get(LEVEL).equals(0)) {
                world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) - 1));
                stack.applyComponentsFrom(ComponentMap.builder().add(DataComponentTypes.POTION_CONTENTS, new PotionContentsComponent(Potions.WATER)).build());
                if (!player.isCreative()) player.setStackInHand(hand, stack);
                return ItemActionResult.SUCCESS;
            }
        }
        return ItemActionResult.FAIL;
    }
    @Override
    public boolean isFull(BlockState state) {
        return state.get(LEVEL) == 3;
    }

    @Override
    protected boolean canBeFilledByDripstone(Fluid fluid) {
        return fluid == Fluids.WATER;
    }

    @Override
    protected MapCodec<? extends AbstractCauldronBlock> getCodec() {
        return null;
    }

    @Override
    protected double getFluidHeight(BlockState state) {
        return (6.0D + (double)state.get(LEVEL) * 3.0D) / 16.0D;
    }

    @Override
    public int getComparatorOutput(BlockState state, World world, BlockPos pos) {
        return state.get(LEVEL);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LEVEL);
    }
    @Override
    protected void fillFromDripstone(BlockState state, World world, BlockPos pos, Fluid fluid) {
        if (!this.isFull(state)) {
            world.setBlockState(pos, state.with(LEVEL, state.get(LEVEL) + 1));
            world.syncWorldEvent(1047, pos, 0);
        }
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return Objects.requireNonNull(super.getPlacementState(itemPlacementContext))
                .with(LEVEL, 0);
    }


    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
            return SHAPE;
    }
    static {
        SHAPE = createCuboidShape(4, 0, 4, 12, 9, 12);
    }

    public boolean canPlaceAt(BlockState state, WorldView worldView, BlockPos pos) {
        return !worldView.isAir(pos.down());
    }

    // Polymer
    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }
    @Override
    public BlockState getPolymerBreakEventBlockState(BlockState state, ServerPlayerEntity player) {
        return Blocks.COBBLESTONE.getDefaultState();
    }

    @Override
    public @Nullable ElementHolder createElementHolder(ServerWorld world, BlockPos pos, BlockState initialBlockState) {
        return new ItemDisplayBirdBathModel(initialBlockState, pos, world);
    }
}
