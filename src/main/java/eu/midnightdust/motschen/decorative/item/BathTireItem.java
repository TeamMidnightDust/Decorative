package eu.midnightdust.motschen.decorative.item;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RayTraceContext;
import net.minecraft.world.World;

public class BathTireItem extends Item {
    private static final Map<EntityType<?>, BathTireItem> SPAWN_EGGS = Maps.newIdentityHashMap();
    private final EntityType<?> type;

    public BathTireItem(EntityType<?> type, Item.Settings settings) {
        super(settings);
        this.type = type;
        SPAWN_EGGS.put(type, this);
    }

    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        HitResult hitResult = rayTrace(world, user, RayTraceContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else if (world.isClient) {
            return TypedActionResult.success(itemStack);
        } else {
            BlockHitResult blockHitResult = (BlockHitResult)hitResult;
            BlockPos blockPos = blockHitResult.getBlockPos();
            if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                return TypedActionResult.pass(itemStack);
            } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, blockHitResult.getSide(), itemStack)) {
                EntityType<?> entityType = this.getEntityType(itemStack.getTag());
                if (entityType.spawnFromItemStack(world, itemStack, user, blockPos.up(1), SpawnReason.SPAWN_EGG, false, false) == null) {
                    return TypedActionResult.pass(itemStack);
                } else {
                    if (!user.abilities.creativeMode) {
                        itemStack.decrement(1);
                    }

                    user.incrementStat(Stats.USED.getOrCreateStat(this));
                    return TypedActionResult.success(itemStack);
                }
            } else {
                return TypedActionResult.fail(itemStack);
            }
        }
    }

    public EntityType<?> getEntityType(CompoundTag tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            CompoundTag compoundTag = tag.getCompound("EntityTag");
            if (compoundTag.contains("id", 8)) {
                return EntityType.get(compoundTag.getString("id")).orElse(this.type);
            }
        }

        return this.type;
    }
}
