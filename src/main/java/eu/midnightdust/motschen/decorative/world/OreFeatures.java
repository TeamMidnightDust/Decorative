package eu.midnightdust.motschen.decorative.world;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

import java.util.List;

public class OreFeatures {
//    private static final ConfiguredFeature<?, ?> ROCKY_ASPHALT_FEATURE = new ConfiguredFeature<>(Feature.ORE, new OreFeatureConfig(
//                    OreConfiguredFeatures.STONE_ORE_REPLACEABLES, DecorativeMain.RockyAsphalt.getDefaultState(),10));
//    public static PlacedFeature ROCKY_ASPHALT_PLACED_FEATURE = new PlacedFeature(
//            RegistryEntry.of(ROCKY_ASPHALT_FEATURE),
//            List.of(
//                    CountPlacementModifier.of(40),
//                    SquarePlacementModifier.of(),
//                    HeightRangePlacementModifier.uniform(YOffset.BOTTOM, YOffset.TOP)
//            ));

    public static void init() {
//        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DecorativeMain.MOD_ID, "rocky_asphalt"), ROCKY_ASPHALT_FEATURE);
//        Registry.register(BuiltinRegistries.PLACED_FEATURE, new Identifier(DecorativeMain.MOD_ID, "placed_rocky_asphalt"), ROCKY_ASPHALT_PLACED_FEATURE);
//        BiomeModifications.addFeature(biome -> (!biome.hasTag(BiomeTags.IS_NETHER) && !biome.hasTag(BiomeTags.END_CITY_HAS_STRUCTURE)),
//                GenerationStep.Feature.UNDERGROUND_ORES, BuiltinRegistries.PLACED_FEATURE.getKey(OreFeatures.ROCKY_ASPHALT_PLACED_FEATURE).get());
    }
}
