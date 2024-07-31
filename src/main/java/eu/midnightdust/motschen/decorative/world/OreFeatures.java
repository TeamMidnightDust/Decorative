package eu.midnightdust.motschen.decorative.world;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.register;

public class OreFeatures {
    private static final ConfiguredFeature<?, ?> ROCKY_ASPHALT_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(
            new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES), DecorativeMain.RockyAsphalt.getDefaultState(),10));
    public static PlacedFeature ROCKY_ASPHALT_PLACED_FEATURE = new PlacedFeature(
            RegistryEntry.of(ROCKY_ASPHALT_FEATURE),
            List.of(
                    CountPlacementModifier.of(40),
                    SquarePlacementModifier.of(),
                    HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP)
            ));

    public static void init() {
        BiomeModifications.addFeature(biome -> (!biome.hasTag(BiomeTags.IS_NETHER) && !biome.hasTag(BiomeTags.END_CITY_HAS_STRUCTURE)),
                GenerationStep.Feature.UNDERGROUND_ORES, getKey(id("rocky_asphalt")));
    }
    public static RegistryKey<PlacedFeature> getKey(Identifier id) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, id);
    }

    public static void initConfigured(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, "rocky_asphalt", ROCKY_ASPHALT_FEATURE);
    }
    public static void initPlaced(Registerable<PlacedFeature> context) {
        register(context, "rocky_asphalt", ROCKY_ASPHALT_PLACED_FEATURE);
    }
}
