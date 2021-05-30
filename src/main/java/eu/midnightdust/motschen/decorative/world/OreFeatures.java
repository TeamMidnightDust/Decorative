package eu.midnightdust.motschen.decorative.world;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;

public class OreFeatures {
    public static final ConfiguredFeature<?, ?> ROCKY_ASPHALT_FEATURE = Feature.ORE.configure(new OreFeatureConfig(OreFeatureConfig.Rules.BASE_STONE_OVERWORLD, DecorativeMain.RockyAsphalt.getDefaultState(), 7)).applyChance(200).spreadHorizontally().repeat(20);

    public static void init() {
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(DecorativeMain.MOD_ID, "rocky_asphalt"), ROCKY_ASPHALT_FEATURE);
    }
}
