package eu.midnightdust.motschen.decorative.mixin;

import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.decoration.ArmorStandEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ArmorStandEntity.class)
public interface ArmorStandEntityAccessor {
    @Accessor
    static TrackedData<Byte> getARMOR_STAND_FLAGS() {
        throw new RuntimeException();
    }
}
