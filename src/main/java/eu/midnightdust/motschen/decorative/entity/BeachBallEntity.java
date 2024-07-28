package eu.midnightdust.motschen.decorative.entity;

import eu.midnightdust.motschen.decorative.init.Pool;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BeachBallEntity extends MobEntity {
    public BeachBallEntity(EntityType<? extends BeachBallEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if(!player.getEntityWorld().isClient && player.getStackInHand(hand)== ItemStack.EMPTY && hand==Hand.MAIN_HAND && player.isSneaking())
        {
            this.remove(RemovalReason.DISCARDED);
            player.setStackInHand(hand, new ItemStack(Pool.BEACH_BALL_ITEM));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }
}
