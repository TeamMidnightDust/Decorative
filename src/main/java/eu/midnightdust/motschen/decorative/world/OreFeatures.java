package eu.midnightdust.motschen.decorative.world;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.block.Blocks;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.CountPlacementModifier;
import net.minecraft.world.gen.decorator.SquarePlacementModifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class OreFeatures {
    public static final ConfiguredFeature<?, ?> ROCKY_ASPHALT_FEATURE = Feature.ORE.configure(new OreFeatureConfig(new BlockMatchRuleTest(Blocks.STONE), DecorativeMain.RockyAsphalt.getDefaultState(), 7));
    public static final PlacedFeature ROCKY_ASPHALT_PLACED_FEATURE = ROCKY_ASPHALT_FEATURE.withPlacement(SquarePlacementModifier.of());

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DecorativeMain.MOD_ID, "rocky_asphalt"), ROCKY_ASPHALT_FEATURE);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DecorativeMain.MOD_ID, "placed_rocky_asphalt"), ROCKY_ASPHALT_PLACED_FEATURE);
        BiomeModifications.addFeature(biome -> (biome.getBiome().getCategory() != Biome.Category.NETHER && biome.getBiome().getCategory() != Biome.Category.THEEND),
                GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(OreFeatures.ROCKY_ASPHALT_PLACED_FEATURE).get());
    }
}
