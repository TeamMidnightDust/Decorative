package eu.midnightdust.motschen.decorative.entity;

import eu.midnightdust.motschen.decorative.init.Pool;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvent;
import net.minecraft.tag.Tag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class BeachBallEntity extends PigEntity {
    public BeachBallEntity(EntityType<? extends PigEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected int getCurrentExperience(PlayerEntity player) {
        return 0;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return null;
    }

    protected void playStepSound(BlockPos pos, BlockState state) {
    }

    @Override
    public boolean canEat() {
        return false;
    }

    @Override
    protected void swimUpward(Tag<Fluid> fluid) {
            this.setVelocity(this.getVelocity().add(0.0D, 1.0D, 0.0D));
    }

    @Override
    public double getHeightOffset() {
        return 0.0D;
    }

    @Override
    public boolean canWalkOnFluid(Fluid fluid) {
        return true;
    }

    @Override
    public float getSaddledSpeed() {
        return 0;
    }

    @Override
    protected void initGoals() { }

    @Override
    public boolean canBeRiddenInWater() {
        return true;
    }

    @Override
    protected int computeFallDamage(float fallDistance, float damageMultiplier) {
        return 0;
    }

    @Override
    public boolean cannotDespawn() {
        return true;
    }

    @Override
    protected boolean movesIndependently() {
        return false;
    }

    @Override
    public boolean canMoveVoluntarily() {
        return false;
    }

    @Override
    public boolean canBeControlledByRider() {
        return true;
    }

    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if(!player.getEntityWorld().isClient && player.getStackInHand(hand)== ItemStack.EMPTY && hand==Hand.MAIN_HAND && player.isSneaking())
        {
            remove();
            player.setStackInHand(hand, new ItemStack(Pool.BEACH_BALL_ITEM));
            return ActionResult.SUCCESS;
        }
        return ActionResult.FAIL;
    }

    @Override
    public void updatePassengerPosition(Entity passenger) {
        if(this.getPrimaryPassenger() instanceof PlayerEntity)
        {
            passenger.updatePosition(this.getX(),this.getY(),this.getZ());
        }
    }


}
