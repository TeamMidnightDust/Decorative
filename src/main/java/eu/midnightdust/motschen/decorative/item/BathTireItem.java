package eu.midnightdust.motschen.decorative.item;

import eu.pb4.factorytools.api.item.AutoModeledPolymerItem;
import net.minecraft.block.FluidBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.stat.Stats;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.RaycastContext;
import net.minecraft.world.World;

public class BathTireItem extends Item implements AutoModeledPolymerItem {
    private final EntityType<?> type;

    public BathTireItem(EntityType<?> type, Item.Settings settings) {
        super(settings);
        this.type = type;
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        BlockHitResult hitResult = raycast(world, user, RaycastContext.FluidHandling.SOURCE_ONLY);
        if (hitResult.getType() != HitResult.Type.BLOCK) {
            return TypedActionResult.pass(itemStack);
        } else if (world.isClient) {
            return TypedActionResult.success(itemStack);
        } else {
            BlockPos blockPos = hitResult.getBlockPos();
            if (!(world.getBlockState(blockPos).getBlock() instanceof FluidBlock)) {
                return TypedActionResult.pass(itemStack);
            } else if (world.canPlayerModifyAt(user, blockPos) && user.canPlaceOn(blockPos, hitResult.getSide(), itemStack)) {
                EntityType<?> entityType = this.getEntityType(itemStack.getComponents().get(DataComponentTypes.ENTITY_DATA).copyNbt());
                if (entityType.spawnFromItemStack((ServerWorld) world, itemStack, user, blockPos.up(1), SpawnReason.SPAWN_EGG, false, false) == null) {
                    return TypedActionResult.pass(itemStack);
                } else {
                    if (!user.getAbilities().creativeMode) {
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

    public EntityType<?> getEntityType(NbtCompound tag) {
        if (tag != null && tag.contains("EntityTag", 10)) {
            NbtCompound compoundTag = tag.getCompound("EntityTag");
            if (compoundTag.contains("id", 8)) {
                return EntityType.get(compoundTag.getString("id")).orElse(this.type);
            }
        }

        return this.type;
    }

    @Override
    public Item getPolymerItem() {
        return Items.DRIED_KELP;
    }
}
