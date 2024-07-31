package eu.midnightdust.motschen.decorative.sound;

import eu.pb4.polymer.core.api.other.PolymerSoundEvent;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class DecorativeSoundEvents {
    public static SoundEvent CEILINGFAN_AMBIENT;

    public static void init() {
        CEILINGFAN_AMBIENT = register(id("ceiling_fan.ambient"));
    }

    private static SoundEvent register(Identifier id) {
        return Registry.register(Registries.SOUND_EVENT, id, PolymerSoundEvent.of(id, null));
    }
}