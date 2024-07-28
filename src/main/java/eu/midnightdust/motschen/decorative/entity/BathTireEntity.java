package eu.midnightdust.motschen.decorative.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BathTireEntity extends MobEntity {
    public BathTireEntity(EntityType<? extends BathTireEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if (!player.getEntityWorld().isClient && player.getStackInHand(hand)== ItemStack.EMPTY && hand==Hand.MAIN_HAND ) {
            if (player.isSneaking()) {
                this.remove(RemovalReason.DISCARDED);
                System.out.println(Identifier.tryParse(this.getType().getUntranslatedName()));
                player.setStackInHand(hand, new ItemStack(Registries.ITEM.get(Identifier.tryParse("decorative:" + this.getType().getUntranslatedName()))));
                return ActionResult.SUCCESS;
            }
            else if (!player.isSneaking()) {
                player.startRiding(this, true);
                return ActionResult.SUCCESS;
            }
        }
        return super.interactAt(player, hitPos, hand);
    }
}
