package eu.midnightdust.motschen.decorative.entity;

import eu.midnightdust.motschen.decorative.init.Pool;
import eu.midnightdust.motschen.decorative.polymer.entity.ItemDisplayBasedEntity;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class BeachBallEntity extends MobEntity implements ItemDisplayBasedEntity {
    public BeachBallEntity(EntityType<? extends BeachBallEntity> entityType, World world) {
        super(entityType, world);
        this.onCreated(this);
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
    @Override
    protected void swimUpward(TagKey<Fluid> fluid) {
        if (this.getNavigation().canSwim()) {
            super.swimUpward(fluid);
        } else {
            this.setVelocity(this.getVelocity().add(0.0D, 0.7D, 0.0D));
        }

    }
    @Override
    public boolean canWalkOnFluid(FluidState fluid) {
        return true;
    }
    // Polymer
    @Override
    public ItemStack getVisualItemStack() {
        return new ItemStack(Pool.BEACH_BALL_ITEM);
    }
    @Override
    public void setItemDisplayProperties(ItemDisplayElement display) {
        display.setInvisible(false);
        display.setModelTransformation(ModelTransformationMode.HEAD);
        display.setTeleportDuration(3);
        display.setScale(new Vector3f(1f));
        display.setTranslation(new Vector3f(0, -0.4f, 0));
    }
    @Override
    public Vec3d getClientSidePosition(Vec3d vec3d) {
        return vec3d.add(0, 0.25d, 0);
    }
    @Override
    public boolean isSmall() {
        return true;
    }
}
