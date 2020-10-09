package eu.midnightdust.motschen.decorative.world;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.fabricmc.fabric.api.event.registry.RegistryEntryAddedCallback;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.ArrayList;
import java.util.List;

public class RockyAsphalt {
    private static List<Biome> checkedBiomes = new ArrayList<>();

    public static void initBiomeFeatures() {
        for (Biome biome : Registry.BIOME) {
            addToBiome(biome);
        }

        //Handles modded biomes
        RegistryEntryAddedCallback.event(Registry.BIOME).register((i, identifier, biome) -> addToBiome(biome));
    }
    private static void addToBiome(Biome biome){
        if(checkedBiomes.contains(biome)){
            //Just to be sure we dont add the stuff twice to the same biome
            return;
        }
        checkedBiomes.add(biome);
        addOre(biome, OreFeatureConfig.Target.NATURAL_STONE, DecorativeMain.Ores.RockyAsphalt);
    }

    private static void addOre(Biome biome, OreFeatureConfig.Target canReplaceIn, DecorativeMain.Ores ore) {
        biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE.configure(
                new OreFeatureConfig(canReplaceIn, DecorativeMain.RockyAsphalt.getDefaultState(), ore.veinSize)).createDecoratedFeature(Decorator.COUNT_RANGE.configure(
                new RangeDecoratorConfig(ore.veinsPerChunk, ore.minY, ore.minY, ore.maxY))));
    }
}