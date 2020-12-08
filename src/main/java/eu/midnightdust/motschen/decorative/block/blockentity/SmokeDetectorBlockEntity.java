package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.SmokeDetector;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.BlockTags;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

import java.time.LocalTime;

public class SmokeDetectorBlockEntity extends BlockEntity implements Tickable {
    private int second;
    private int sound = 0;

    public SmokeDetectorBlockEntity() {
        super(BlockEntities.SmokeDetectorBlockEntity);
    }

    public boolean isInFireRange() {
        return this.world.getBlockState(this.pos.down()).isIn(BlockTags.FIRE);
    }

    @Override
    public void tick() {
        if (LocalTime.now().getSecond() != second) {
            second = LocalTime.now().getSecond();

            if (this.isInFireRange()) {
                world.setBlockState(pos, DecorativeMain.SmokeDetector.getDefaultState().with(SmokeDetector.ACTIVE, true));

                sound = sound + 1;
                if (sound > 3) {sound = 0;}
                if (sound == 0) {
                    world.playSound(null, pos, DecorativeSoundEvents.SMOKE_DETECTOR_BEEP, SoundCategory.BLOCKS, 1f, 1f);
                }
            }
            else if (this.world.getBlockState(pos).get(SmokeDetector.ACTIVE).equals(true)) {
                world.setBlockState(pos, DecorativeMain.SmokeDetector.getDefaultState().with(SmokeDetector.ACTIVE, false));
            }
        }
    }
}
