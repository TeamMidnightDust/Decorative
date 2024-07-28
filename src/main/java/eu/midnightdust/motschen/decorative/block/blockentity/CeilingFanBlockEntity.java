package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.blockstates.CeilingFanStage;
import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.time.LocalTime;

public class CeilingFanBlockEntity extends BlockEntity {
    private int rot;
    private int second;

    public CeilingFanBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntities.CeilingFanBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, CeilingFanBlockEntity blockEntity) {
        if (state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_1) {
            if (LocalTime.now().getSecond() != blockEntity.second) {
                blockEntity.second = LocalTime.now().getSecond();
                world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.1f, 1.0f);
            }
            blockEntity.rot = blockEntity.rot + 6;
        }
        else if (state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_2) {
            if (LocalTime.now().getSecond() != blockEntity.second) {
                blockEntity.second = LocalTime.now().getSecond();
                world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.2f, 1.0f);
            }
            blockEntity.rot = blockEntity.rot + 10;
        }
        else if (state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_3) {
            if (LocalTime.now().getSecond() != blockEntity.second) {
                blockEntity.second = LocalTime.now().getSecond();
                world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.3f, 1.0f);
            }

            blockEntity.rot = blockEntity.rot + 14;
        }
    }
    public int getRot() {
        return rot;
    }
}
