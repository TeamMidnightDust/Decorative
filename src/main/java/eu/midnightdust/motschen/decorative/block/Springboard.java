package eu.midnightdust.motschen.decorative.block;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.blockstates.Part;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.BlockSoundGroup;
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

import java.util.Objects;

public class Springboard extends HorizontalFacingBlock {
    private static final VoxelShape NORTH_SHAPE_FRONT;
    private static final VoxelShape EAST_SHAPE_FRONT;
    private static final VoxelShape SOUTH_SHAPE_FRONT;
    private static final VoxelShape WEST_SHAPE_FRONT;
    private static final VoxelShape NORTH_SHAPE_BACK;
    private static final VoxelShape EAST_SHAPE_BACK;
    private static final VoxelShape SOUTH_SHAPE_BACK;
    private static final VoxelShape WEST_SHAPE_BACK;
    private static final EnumProperty<Part> PART = DecorativeMain.PART;

    public Springboard() {
        super(FabricBlockSettings.copy(Blocks.STONE).nonOpaque().sounds(BlockSoundGroup.STONE));
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(PART, Part.BACK));
    }
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!world.isClient) {
            if (itemStack.isEmpty() && hand==Hand.MAIN_HAND) {
                if (state.get(PART) == Part.FRONT) {
                    if (player.getY() >= pos.getY() + 0.1 && player.squaredDistanceTo(pos.getX(), pos.getY(), pos.getZ()) <= 1.0) {
                        player.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 10, 10));
                        return ActionResult.SUCCESS;
                    }
                }
            }
        }
        return ActionResult.FAIL;
    }
    @Override
    public BlockState getPlacementState(ItemPlacementContext itemPlacementContext) {
        return Objects.requireNonNull(super.getPlacementState(itemPlacementContext))
                .with(FACING, itemPlacementContext.getPlayerFacing())
                .with(PART, Part.BACK);
    }

    @Override
    public void onPlaced(World arg, BlockPos pos, BlockState state, LivingEntity arg4, ItemStack arg5) {
        if (state.get(PART) == Part.BACK) {
            switch (state.get(FACING)) {
                case NORTH:
                    if (!arg.getBlockState(pos.north()).isAir()) {
                        arg.breakBlock(pos, true);
                    } else {
                        arg.setBlockState(pos.north(), state.with(PART, Part.FRONT).with(FACING, Direction.NORTH));
                    }
                case EAST:
                    if (!arg.getBlockState(pos.east()).isAir()) {
                        arg.breakBlock(pos, true);
                    } else {
                        arg.setBlockState(pos.east(), state.with(PART, Part.FRONT).with(FACING, Direction.EAST));
                    }
                case SOUTH:
                    if (!arg.getBlockState(pos.south()).isAir()) {
                        arg.breakBlock(pos, true);
                    } else {
                        arg.setBlockState(pos.south(), state.with(PART, Part.FRONT).with(FACING, Direction.SOUTH));
                    }
                case WEST:
                    if (!arg.getBlockState(pos.west()).isAir()) {
                        arg.breakBlock(pos, true);
                    } else {
                        arg.setBlockState(pos.west(), state.with(PART, Part.FRONT).with(FACING, Direction.WEST));
                    }
            }
        }
    }
    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        switch (state.get(PART)) {
            case BACK: switch (state.get(FACING)) {
                case NORTH:
                    if (world.getBlockState(pos.north()).contains(PART)) { world.breakBlock(pos.north(), true);}
                case EAST:
                    if (world.getBlockState(pos.east()).contains(PART)) { world.breakBlock(pos.east(), true);}
                case SOUTH:
                    if (world.getBlockState(pos.south()).contains(PART)) { world.breakBlock(pos.south(), true);}
                case WEST:
                    if (world.getBlockState(pos.west()).contains(PART)) { world.breakBlock(pos.west(), true);}
            }
            case FRONT: switch (state.get(FACING)) {
                case NORTH:
                    if (world.getBlockState(pos.south()).contains(PART)) { world.breakBlock(pos.south(), true); }
                case EAST:
                    if (world.getBlockState(pos.west()).contains(PART)) { world.breakBlock(pos.south(), true); }
                case SOUTH:
                    if (world.getBlockState(pos.north()).contains(PART)) { world.breakBlock(pos.south(), true); }
                case WEST:
                    if (world.getBlockState(pos.east()).contains(PART)) { world.breakBlock(pos.south(), true); }
            }
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
        builder.add(PART);
    }
    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        return switch (state.get(FACING)) {
            case NORTH -> switch (state.get(PART)) {
                case FRONT -> NORTH_SHAPE_FRONT;
                case BACK -> NORTH_SHAPE_BACK;
            };
            case EAST -> switch (state.get(PART)) {
                case FRONT -> EAST_SHAPE_FRONT;
                case BACK -> EAST_SHAPE_BACK;
            };
            case SOUTH -> switch (state.get(PART)) {
                case FRONT -> SOUTH_SHAPE_FRONT;
                case BACK -> SOUTH_SHAPE_BACK;
            };
            case WEST -> switch (state.get(PART)) {
                case FRONT -> WEST_SHAPE_FRONT;
                case BACK -> WEST_SHAPE_BACK;
            };
            default -> super.getOutlineShape(state, view, pos, context);
        };
    }
    static {
        //long_plank
        VoxelShape front1 = createCuboidShape(1, 2, 0, 15, 3, 28);
        VoxelShape back1 = createCuboidShape(1, 2, -16, 15, 3, 12);
        //plank-y
        VoxelShape front2 = createCuboidShape(1, 1, 21, 15, 2, 30);
        VoxelShape back2 = createCuboidShape(1, 1, 5, 15, 2, 14);
        //plank--y
        VoxelShape front3 = createCuboidShape(1, 0, 23, 15, 1, 32);
        VoxelShape back3 = createCuboidShape(1, 0, 7, 15, 1, 16);
        //lower_siding
        VoxelShape front4left = createCuboidShape(0, 0, 8, 1, 1, 32);
        VoxelShape back4left = createCuboidShape(0, 0, -8, 1, 1, 16);
        VoxelShape front4right = createCuboidShape(15, 0, 8, 16, 1, 32);
        VoxelShape back4right = createCuboidShape(15, 0, -8, 16, 1, 16);
        //upper_siding
        VoxelShape front5left = createCuboidShape(0, 6, 9, 1, 7, 31);
        VoxelShape back5left = createCuboidShape(0, 6, -7, 1, 7, 15);
        VoxelShape front5right = createCuboidShape(15, 6, 9, 16, 7, 31);
        VoxelShape back5right = createCuboidShape(15, 6, -7, 16, 7, 15);
        //siding_front
        VoxelShape front6left = createCuboidShape(0, 1, 31, 1, 6, 32);
        VoxelShape back6left = createCuboidShape(0, 1, 15, 1, 6, 16);
        VoxelShape front6right = createCuboidShape(15, 1, 31, 16, 6, 32);
        VoxelShape back6right = createCuboidShape(15, 1, 15, 16, 6, 16);
        //siding_back
        VoxelShape front7left = createCuboidShape(0, 1, 8, 1, 6, 9);
        VoxelShape back7left = createCuboidShape(0, 1, -8, 1, 6, -7);
        VoxelShape front7right = createCuboidShape(15, 1, 8, 16, 6, 9);
        VoxelShape back7right = createCuboidShape(15, 1, -8, 16, 6, -7);
        //dot_front
        VoxelShape front8left = createCuboidShape(0, 5, 30, 1, 6, 31);
        VoxelShape back8left = createCuboidShape(0, 5, 14, 1, 6, 15);
        VoxelShape front8right = createCuboidShape(15, 5, 30, 16, 6, 31);
        VoxelShape back8right = createCuboidShape(15, 5, 14, 16, 6, 15);
        //dot_back
        VoxelShape front9left = createCuboidShape(0, 5, 9, 1, 6, 10);
        VoxelShape back9left = createCuboidShape(0, 5, -7, 1, 6, -6);
        VoxelShape front9right = createCuboidShape(15, 5, 9, 16, 6, 10);
        VoxelShape back9right = createCuboidShape(15, 5, -7, 16, 6, -6);
        //union
        VoxelShape front = VoxelShapes.union(front1, front2, front3, front4left, front4right, front5left, front5right, front6left, front6right, front7left, front7right, front8left, front8right, front9left, front9right);
        VoxelShape back = VoxelShapes.union(back1, back2, back3, back4left, back4right, back5left, back5right, back6left, back6right, back7left, back7right, back8left, back8right, back9left, back9right);

        NORTH_SHAPE_FRONT = front;
        WEST_SHAPE_FRONT = rotate(Direction.EAST, Direction.NORTH, front);
        EAST_SHAPE_FRONT = rotate(Direction.EAST, Direction.SOUTH, front);
        SOUTH_SHAPE_FRONT = rotate(Direction.EAST, Direction.WEST, front);
        NORTH_SHAPE_BACK = back;
        WEST_SHAPE_BACK = rotate(Direction.EAST, Direction.NORTH, back);
        EAST_SHAPE_BACK = rotate(Direction.EAST, Direction.SOUTH, back);
        SOUTH_SHAPE_BACK = rotate(Direction.EAST, Direction.WEST, back);
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

}
