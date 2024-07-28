package eu.midnightdust.motschen.decorative.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class DecorativeSoundEvents {
    public static final SoundEvent CEILINGFAN_AMBIENT = register(id("ceiling_fan.ambient"));

    private static SoundEvent register(Identifier id) {
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}