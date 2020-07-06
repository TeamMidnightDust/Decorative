package eu.midnightdust.motschen.decorative.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
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

public class SlidingDoor extends DoorBlock {

    private static final VoxelShape NORTH_SHAPE;
    private static final VoxelShape EAST_SHAPE;
    private static final VoxelShape SOUTH_SHAPE;
    private static final VoxelShape WEST_SHAPE;
    private static final VoxelShape NORTH_SHAPE_OPEN;
    private static final VoxelShape EAST_SHAPE_OPEN;
    private static final VoxelShape SOUTH_SHAPE_OPEN;
    private static final VoxelShape WEST_SHAPE_OPEN;

    public SlidingDoor() {
        super(FabricBlockSettings.copy(Blocks.BLACK_CONCRETE).nonOpaque().sounds(BlockSoundGroup.STONE));
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        state = state.cycle(OPEN);
        world.setBlockState(pos, state, 10);
        world.playSound(player, pos, SoundEvents.BLOCK_IRON_DOOR_OPEN, SoundCategory.BLOCKS, 0.1f, 1.2f);
        return ActionResult.SUCCESS;
    }

    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        state.get(FACING);
        boolean bl = !state.get(OPEN);
        boolean bl2 = state.get(HINGE) == DoorHinge.RIGHT;
        switch(state.get(FACING)) {
            default:
                return bl ? WEST_SHAPE : (bl2 ? EAST_SHAPE_OPEN : WEST_SHAPE_OPEN);
            case NORTH:
                return bl ? NORTH_SHAPE : (bl2 ? SOUTH_SHAPE_OPEN : NORTH_SHAPE_OPEN);
            case EAST:
                return bl ? EAST_SHAPE : (bl2 ? WEST_SHAPE_OPEN : EAST_SHAPE_OPEN);
            case SOUTH:
                return bl ? SOUTH_SHAPE : (bl2 ? NORTH_SHAPE_OPEN : SOUTH_SHAPE_OPEN);
        }
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
}