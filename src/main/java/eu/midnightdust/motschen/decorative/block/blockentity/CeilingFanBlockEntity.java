package eu.midnightdust.motschen.decorative.block.blockentity;

import eu.midnightdust.motschen.decorative.blockstates.CeilingFanStage;
import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.sound.DecorativeSoundEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.Tickable;
import net.minecraft.util.math.BlockPos;

public class CeilingFanBlockEntity extends BlockEntity implements Tickable {
    private int rot;

    public CeilingFanBlockEntity() {
        super(BlockEntities.CeilingFanBlockEntity);
    }



    @Override
    public void tick() {

        BlockPos pos = this.pos;
        BlockState state = this.world.getBlockState(pos);
        if (world != null && state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_1) {
            world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.1f, 1.0f);
            rot = rot + 6;
            return;
        }
        if (world != null && state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_2) {
            world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.2f, 1.0f);
            rot = rot + 10;
            return;
        }
        if (world != null && state.get(DecorativeMain.STAGE) == CeilingFanStage.LEVEL_3) {
            world.playSound(null,pos, DecorativeSoundEvents.CEILINGFAN_AMBIENT, SoundCategory.BLOCKS, 0.3f, 1.0f);
            rot = rot + 14;
            return;
        }
        else {
            rot = rot;
            return;
        }
    }
    public int getRot() {
        return rot;
    }
}
