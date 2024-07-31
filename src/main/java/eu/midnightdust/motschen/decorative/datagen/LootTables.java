package eu.midnightdust.motschen.decorative.datagen;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.loot.LootTable;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.state.property.Properties;

import java.util.concurrent.CompletableFuture;

public class LootTables {
    public static class BlockLootTables extends FabricBlockLootTableProvider {
        public BlockLootTables(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
            super(dataOutput, registryLookup);
        }

        @Override
        public void generate() {
            DecorativeMain.BLOCKS.forEach(block -> {
                System.out.println(block);
                if (block.getDefaultState().contains(Properties.DOUBLE_BLOCK_HALF)) {
                    System.out.println("Only drop for lower half");
                    addDrop(block, doubleBlockDrops(block));
                } else addDrop(block);
            });
        }

        public LootTable.Builder doubleBlockDrops(Block block) {
            return this.dropsWithProperty(block, Properties.DOUBLE_BLOCK_HALF, DoubleBlockHalf.LOWER);
        }
    }
}

