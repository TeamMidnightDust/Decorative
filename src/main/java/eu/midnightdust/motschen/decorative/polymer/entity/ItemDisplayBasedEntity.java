package eu.midnightdust.motschen.decorative.polymer.entity;

import eu.midnightdust.motschen.decorative.mixin.ArmorStandEntityAccessor;
import eu.pb4.polymer.core.api.entity.PolymerEntity;
import eu.pb4.polymer.virtualentity.api.ElementHolder;
import eu.pb4.polymer.virtualentity.api.VirtualEntityUtils;
import eu.pb4.polymer.virtualentity.api.attachment.EntityAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import eu.pb4.polymer.virtualentity.api.tracker.EntityTrackedData;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import org.joml.Vector3f;

import java.util.List;
import java.util.WeakHashMap;

public interface ItemDisplayBasedEntity extends PolymerEntity {
    WeakHashMap<LivingEntity, ItemDisplayElement> DISPLAY_ELEMENTS = new WeakHashMap<>();

    ItemStack getVisualItemStack();

    // This needs to be called on entity init
    default void onCreated(LivingEntity entity) {
        ElementHolder holder = new ElementHolder();

        ItemDisplayElement display = initDisplayEntity();
        holder.addElement(display);
        DISPLAY_ELEMENTS.put(entity, display);

        EntityAttachment.of(holder, entity);
        VirtualEntityUtils.addVirtualPassenger(entity, display.getEntityId());
    }
    default ItemDisplayElement initDisplayEntity() {
        ItemDisplayElement display = new ItemDisplayElement(getVisualItemStack());
        setItemDisplayProperties(display);
        return display;
    }
    default void setItemDisplayProperties(ItemDisplayElement display) {
        display.setInvisible(false);
        display.setModelTransformation(ModelTransformationMode.HEAD);
        display.setTeleportDuration(3);
        display.setScale(new Vector3f(1f));
    }
    default boolean isSmall() {
        return false;
    }
    @Override
    default float getClientSideYaw(float yaw) {
        if (DISPLAY_ELEMENTS.containsKey((LivingEntity) this)) {
            DISPLAY_ELEMENTS.get((LivingEntity) this).setYaw(yaw);
        }
        return yaw;
    }

    @Override
    default float getClientSidePitch(float pitch) {
        if (DISPLAY_ELEMENTS.containsKey((LivingEntity) this)) {
            DISPLAY_ELEMENTS.get((LivingEntity) this).setPitch(pitch);
        }
        return pitch;
    }

    @Override
    default EntityType<?> getPolymerEntityType(ServerPlayerEntity player) {
        return EntityType.ARMOR_STAND;
    }
    @Override
    default void modifyRawTrackedData(List<DataTracker.SerializedEntry<?>> data, ServerPlayerEntity player, boolean initial) {
        setInvisible(data, true);
        if (isSmall()) data.add(DataTracker.SerializedEntry.of(ArmorStandEntityAccessor.getARMOR_STAND_FLAGS(), (byte) (0b00000011)));
    }

    static void setInvisible(List<DataTracker.SerializedEntry<?>> data, boolean invisible) {
        setFlag(data, EntityTrackedData.FLAGS, EntityTrackedData.INVISIBLE_FLAG_INDEX, invisible);
    }
    static void setFlag(List<DataTracker.SerializedEntry<?>> data, TrackedData<Byte> type, int index, boolean value) {
        // More elegant code that doesn't work somehow
        //var flagsData = data.stream().filter(serializedEntry -> serializedEntry.handler().equals(type.dataType())).findFirst();
        //byte b = flagsData.isEmpty() ? 0 : (byte) flagsData.get().value();
        //flagsData.ifPresent(data::remove);
        byte b = 0;
        if (value) {
            data.add(DataTracker.SerializedEntry.of(type, (byte) (b | 1 << index)));
        } else {
            data.add(DataTracker.SerializedEntry.of(type, (byte) (b & ~(1 << index))));
        }

    }
}
