package eu.midnightdust.motschen.decorative.mixin;

import eu.midnightdust.motschen.decorative.OreFeatures;
import net.minecraft.world.biome.GenerationSettings.Builder;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    @Inject(at = @At("RETURN"), method = "addDefaultOres")
    private static void addDefaultOres(Builder builder, CallbackInfo info) {
        builder.feature(GenerationStep.Feature.UNDERGROUND_ORES, OreFeatures.ROCKY_ASPHALT_FEATURE);
    }
}
