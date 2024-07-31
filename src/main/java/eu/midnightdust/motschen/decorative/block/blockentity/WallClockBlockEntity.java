package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.init.BlockEntities;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.LocalTime;

public class WallClockBlockEntity extends BlockEntity {
    public int second;

    public WallClockBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.WallClockBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, WallClockBlockEntity blockEntity) {
        if (LocalTime.now().getSecond() != blockEntity.second) {
            blockEntity.second = LocalTime.now().getSecond();
            world.playSound(null, pos, SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON, SoundCategory.BLOCKS, 0.04f, 1f);
        }
    }
}
