package eu.midnightdust.motschen.decorative.sound;

import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class DecorativeSoundEvents {
    public static final SoundEvent CEILINGFAN_AMBIENT = register("decorative:ceiling_fan.ambient");

    private static SoundEvent register(String id) {
        return Registry.register(Registry.SOUND_EVENT, id, new SoundEvent(new Identifier(id)));
    }
}