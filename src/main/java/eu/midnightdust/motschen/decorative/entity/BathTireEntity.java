package eu.midnightdust.motschen.decorative.entity;

import eu.midnightdust.motschen.decorative.polymer.entity.ItemDisplayBasedEntity;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.joml.Vector3f;

public class BathTireEntity extends MobEntity implements ItemDisplayBasedEntity {
    public BathTireEntity(EntityType<? extends BathTireEntity> entityType, World world) {
        super(entityType, world);
        this.onCreated(this);
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if (!player.getEntityWorld().isClient && player.getStackInHand(hand)== ItemStack.EMPTY && hand==Hand.MAIN_HAND ) {
            if (player.isSneaking()) {
                this.remove(RemovalReason.DISCARDED);
                System.out.println(Identifier.tryParse(this.getType().getUntranslatedName()));
                player.setStackInHand(hand, getItemStackForType());
                return ActionResult.SUCCESS;
            }
            else if (!player.isSneaking()) {
                player.startRiding(this, true);
                return ActionResult.SUCCESS;
            }
        }
        return super.interactAt(player, hitPos, hand);
    }
    @Override
    public boolean shouldDismountUnderwater() {
        return false;
    }
    @Override
    public Vec3d getPassengerRidingPos(Entity passenger) {
        return this.getPos().add(0,0.4d, 0);
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
    private ItemStack getItemStackForType() {
        return new ItemStack(Registries.ITEM.get(Identifier.tryParse("decorative:" + this.getType().getUntranslatedName())));
    }

    // Polymer
    @Override
    public ItemStack getVisualItemStack() {
        return getItemStackForType();
    }
    @Override
    public void setItemDisplayProperties(ItemDisplayElement display) {
        display.setInvisible(false);
        display.setModelTransformation(ModelTransformationMode.HEAD);
        display.setTeleportDuration(3);
        display.setScale(new Vector3f(1f));
        display.setTranslation(new Vector3f(0, 0.4f, 0));
    }
    @Override
    public Vec3d getClientSidePosition(Vec3d vec3d) {
        return vec3d.add(0, -1.5d, 0);
    }
}
