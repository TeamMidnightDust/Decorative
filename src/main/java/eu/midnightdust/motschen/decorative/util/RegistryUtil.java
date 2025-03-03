package eu.midnightdust.motschen.decorative.util;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.item.FactoryBlockItem;
import eu.pb4.polymer.core.api.block.PolymerBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;

import java.util.ArrayList;
import java.util.List;

import static eu.midnightdust.motschen.decorative.DecorativeMain.BLOCKS;
import static eu.midnightdust.motschen.decorative.DecorativeMain.MOD_ID;

public class RegistryUtil {
    public static List<ItemEntry> groupItems = new ArrayList<>();

    public static void registerFurniture(Identifier id, Block block) {
        registerBlockWithItem(id, block, DecorativeMain.IndoorGroup);
    }
    public static void registerGarden(Identifier id, Block block) {
        registerBlockWithItem(id, block, DecorativeMain.GardenGroup);
    }
    public static void registerTraffic(Identifier id, Block block) {
        registerBlockWithItem(id, block, DecorativeMain.TrafficGroup);
    }
    public static void registerPool(Identifier id, Block block) {
        registerBlockWithItem(id, block, DecorativeMain.PoolGroup);
    }

    public static void registerBlockWithItem(Identifier id, Block block, ItemGroup group) {
        BLOCKS.add(block);
        Registry.register(Registries.BLOCK, id, block);
        registerItem(id, blockItem(block), group);
    }

    public static Item blockItem(Block block) {
        if (DecorativeConfig.polymerIntegration) {
            if (block instanceof PolymerBlock) return new FactoryBlockItem((Block & PolymerBlock) block, new Item.Settings());
            else System.out.println(block);
        }
        return new BlockItem(block, new Item.Settings());
    }

    public static void registerItem(Identifier id, Item item, ItemGroup group) {
        Registry.register(Registries.ITEM, id, item);
        ItemStack stack = new ItemStack(item);
        groupItems.add(new ItemEntry(group.getDisplayName(), stack));
    }

    public static void register(Registerable<ConfiguredFeature<?, ?>> context, String name, ConfiguredFeature<?, ?> feature) {
        context.register(RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(MOD_ID, name)), feature);
    }

    public static void register(Registerable<PlacedFeature> context, String name, PlacedFeature feature) {
        context.register(RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of(MOD_ID, name)), feature);
    }
}