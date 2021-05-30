package eu.midnightdust.motschen.decorative.world;

import com.google.common.collect.Lists;
import eu.midnightdust.motschen.decorative.mixin.GenerationSettingsAccessorMixin;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class OreFeatureInjector {

    public static void init() {
        BuiltinRegistries.BIOME.forEach(OreFeatureInjector::addToBiome);
        RegistryEntryAddedCallback.event(BuiltinRegistries.BIOME).register((i, identifier, biome) -> addToBiome(biome));
    }

    private static void addToBiome(Biome biome) {
        addSaltOre(biome);
    }

    private static void addSaltOre(Biome biome) {
            if (biome.getCategory() != Biome.Category.NETHER && biome.getCategory() != Biome.Category.THEEND) {
                addFeature(biome, GenerationStep.Feature.UNDERGROUND_DECORATION, OreFeatures.ROCKY_ASPHALT_FEATURE);
        }
    }

    public static void addFeature(Biome biome, GenerationStep.Feature step, ConfiguredFeature<?, ?> feature) {
        GenerationSettingsAccessorMixin generationSettingsAccessor  = (GenerationSettingsAccessorMixin) biome.getGenerationSettings();
        int stepIndex = step.ordinal();
        List<List<Supplier<ConfiguredFeature<?, ?>>>> featuresByStep = new ArrayList<>( generationSettingsAccessor.getFeatures());
        while (featuresByStep.size() <= stepIndex) {
            featuresByStep.add(Lists.newArrayList());
        }
        List<Supplier<ConfiguredFeature<?, ?>>> features = new ArrayList<>(featuresByStep.get(stepIndex));
        features.add(() -> feature);
        featuresByStep.set(stepIndex, features);
        generationSettingsAccessor.setFeatures(featuresByStep);
    }
}