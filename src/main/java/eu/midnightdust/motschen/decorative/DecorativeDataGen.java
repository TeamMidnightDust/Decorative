package eu.midnightdust.motschen.decorative;

import eu.midnightdust.motschen.decorative.datagen.LootTables;
import eu.midnightdust.motschen.decorative.world.OreFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

import static eu.midnightdust.motschen.decorative.DecorativeMain.MOD_ID;

public class DecorativeDataGen implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
        pack.addProvider(WorldGenData::new);
        pack.addProvider(LootTables.BlockLootTables::new);
        System.out.println("Initialized dataGen");
    }
    @Override
    public String getEffectiveModId() {
        return MOD_ID;
    }

    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
        System.out.println("building registry");
        registryBuilder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, OreFeatures::initConfigured);
        registryBuilder.addRegistry(RegistryKeys.PLACED_FEATURE, OreFeatures::initPlaced);

    }
    public static class WorldGenData extends FabricDynamicRegistryProvider {
        public WorldGenData(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
            super(output, registriesFuture);
        }

        @Override
        protected void configure(RegistryWrapper.WrapperLookup registries, Entries entries) {
            System.out.println("configure");
            entries.addAll(registries.getWrapperOrThrow(RegistryKeys.CONFIGURED_FEATURE));
            entries.addAll(registries.getWrapperOrThrow(RegistryKeys.PLACED_FEATURE));
        }

        @Override
        public String getName() {
            return MOD_ID;
        }
    }
}
