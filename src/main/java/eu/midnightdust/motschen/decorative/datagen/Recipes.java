package eu.midnightdust.motschen.decorative.datagen;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import eu.midnightdust.motschen.decorative.block.Sign;
import eu.midnightdust.motschen.decorative.init.LogsWithAxes;
import eu.midnightdust.motschen.decorative.init.Pool;
import eu.midnightdust.motschen.decorative.init.Signs;
import eu.midnightdust.motschen.decorative.util.ColorUtil;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

import static eu.midnightdust.motschen.decorative.DecorativeMain.Road;
import static eu.midnightdust.motschen.decorative.DecorativeMain.RockyAsphalt;
import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class Recipes extends FabricRecipeProvider {
    public Recipes(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    @Override
    public void generate(RecipeExporter exporter) {
        generateCrafting(exporter);
        generateStonecutting(exporter);
    }

        private void generateCrafting(RecipeExporter exporter) {
            LogsWithAxes.TYPES.forEach(log -> createLogWithAxeRecipe(log).offerTo(exporter));
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Pool.BEACH_BALL_ITEM, 3)
                    .input('R', Blocks.RED_CONCRETE)
                    .input('Y', Blocks.YELLOW_CONCRETE)
                    .input('B', Blocks.LIGHT_BLUE_CONCRETE)
                    .pattern("RYB")
                    .pattern("RYB")
                    .pattern("RYB")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.YELLOW_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.YELLOW_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.BirdBath)
                    .input('_', Blocks.COBBLESTONE_SLAB)
                    .input('C', Blocks.COBBLESTONE_WALL)
                    .pattern("_ _")
                    .pattern(" C ")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.COBBLESTONE_WALL), FabricRecipeProvider.conditionsFromItem(Blocks.COBBLESTONE_WALL))
                    .offerTo(exporter);
            Arrays.stream(ColorUtil.VanillaColor.values()).toList().forEach(color -> {
                        createBathTireRecipe(color).offerTo(exporter);
                        createDigitalClockRecipe(color).offerTo(exporter);
                        createLampRecipe(color).offerTo(exporter);
                        createDoubleLampRecipe(color).offerTo(exporter);
                    });
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.CeilingFan)
                    .input('/', Items.STICK)
                    .input('_', Blocks.QUARTZ_SLAB)
                    .input('R', Items.REDSTONE)
                    .pattern(" / ")
                    .pattern("_R_")
                    .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.ChristmasLights)
                    .input('/', Items.STICK)
                    .input('R', Blocks.REDSTONE_LAMP)
                    .input('I', Blocks.RED_STAINED_GLASS)
                    .input('G', Blocks.GREEN_STAINED_GLASS)
                    .pattern("///")
                    .pattern("RRR")
                    .pattern("IGI")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.REDSTONE_LAMP), FabricRecipeProvider.conditionsFromItem(Blocks.REDSTONE_LAMP))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.ChristmasTree)
                    .input('#', Blocks.SPRUCE_SAPLING)
                    .input('G', Blocks.GREEN_TERRACOTTA)
                    .input('I', Blocks.GRAY_TERRACOTTA)
                    .pattern(" # ")
                    .pattern("GIG")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.SPRUCE_SAPLING), FabricRecipeProvider.conditionsFromItem(Blocks.SPRUCE_SAPLING))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, Signs.EmptySign)
                    .input('#', Items.RED_DYE)
                    .input('W', Items.WHITE_DYE)
                    .input('I', DecorativeMain.SignPost)
                    .pattern("###")
                    .pattern("#W#")
                    .pattern("#I#")
                    .criterion(FabricRecipeProvider.hasItem(DecorativeMain.SignPost), FabricRecipeProvider.conditionsFromItem(DecorativeMain.SignPost))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, DecorativeMain.FireHydrant, 2)
                    .input('#', Blocks.RED_TERRACOTTA)
                    .pattern("#")
                    .pattern("#")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.RED_TERRACOTTA), FabricRecipeProvider.conditionsFromItem(Blocks.RED_TERRACOTTA))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.TRANSPORTATION, DecorativeMain.Guardrail, 2)
                    .input('#', Blocks.HEAVY_WEIGHTED_PRESSURE_PLATE)
                    .input('I', Blocks.IRON_BARS)
                    .pattern("#I")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.IRON_BARS), FabricRecipeProvider.conditionsFromItem(Blocks.IRON_BARS))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.KitchenTiles, 4)
                    .input('B', Blocks.BLACK_CONCRETE)
                    .input('W', Blocks.WHITE_CONCRETE)
                    .pattern("BW")
                    .pattern("WB")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_CONCRETE))
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.KitchenTiles, 4)
                    .input('W', Blocks.WHITE_CONCRETE)
                    .input('B', Blocks.BLACK_CONCRETE)
                    .pattern("WB")
                    .pattern("BW")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.BLACK_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.BLACK_CONCRETE))
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .showNotification(false)
                    .offerTo(exporter, id("kitchen_tiles_inverted"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.Television)
                    .input('#', Blocks.BLACK_CONCRETE)
                    .input('R', Items.REDSTONE)
                    .pattern("###")
                    .pattern("#R#")
                    .pattern(" # ")
                    .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.OldTelevision)
                    .input('#', Blocks.GRAY_TERRACOTTA)
                    .input('R', Items.REDSTONE)
                    .pattern("###")
                    .pattern("#R#")
                    .pattern("###")
                    .criterion(FabricRecipeProvider.hasItem(Items.REDSTONE), FabricRecipeProvider.conditionsFromItem(Items.REDSTONE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Pool.PoolSprinkler, 3)
                    .input('#', Blocks.IRON_BLOCK)
                    .pattern("##")
                    .pattern("# ")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.IRON_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.IRON_BLOCK))
                    .offerTo(exporter);
            ShapelessRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Pool.PoolWall, 6)
                    .input(Blocks.WHITE_CONCRETE, 3)
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.ShowerHead, 2)
                    .input('#', Blocks.LEVER)
                    .input('G', Blocks.GRAY_CONCRETE)
                    .pattern(" # ")
                    .pattern("GGG")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.GRAY_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.GRAY_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.SignPost, 6)
                    .input('#', Blocks.IRON_BLOCK)
                    .pattern("#")
                    .pattern("#")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.IRON_BLOCK), FabricRecipeProvider.conditionsFromItem(Blocks.IRON_BLOCK))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.SlidingDoor, 3)
                    .input('#', Blocks.WHITE_CONCRETE)
                    .input('G', Blocks.GLASS_PANE)
                    .pattern("##")
                    .pattern("GG")
                    .pattern("##")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Pool.Springboard)
                    .input('#', Blocks.WHITE_CONCRETE)
                    .input('G', Blocks.GRAY_CONCRETE)
                    .pattern("###")
                    .pattern("  G")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, Pool.Springboard)
                    .input('#', Blocks.WHITE_CONCRETE)
                    .input('G', Blocks.GRAY_CONCRETE)
                    .pattern("###")
                    .pattern("G  ")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .offerTo(exporter, id("springboard_inverted"));
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.StonePath)
                    .input('#', Blocks.STONE_BUTTON)
                    .pattern("##")
                    .pattern("##")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.STONE_BUTTON), FabricRecipeProvider.conditionsFromItem(Blocks.STONE_BUTTON))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.TrafficCone, 6)
                    .input('W', Blocks.WHITE_CONCRETE)
                    .input('O', Blocks.ORANGE_CONCRETE)
                    .pattern(" O ")
                    .pattern("WWW")
                    .pattern("OOO")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.WHITE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.WHITE_CONCRETE))
                    .criterion(FabricRecipeProvider.hasItem(Blocks.ORANGE_CONCRETE), FabricRecipeProvider.conditionsFromItem(Blocks.ORANGE_CONCRETE))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.WallClock, 2)
                    .input('#', Blocks.QUARTZ_BLOCK)
                    .input('C', Items.CLOCK)
                    .pattern(" # ")
                    .pattern("#C#")
                    .pattern(" # ")
                    .criterion(FabricRecipeProvider.hasItem(Items.CLOCK), FabricRecipeProvider.conditionsFromItem(Items.CLOCK))
                    .offerTo(exporter);
            ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, DecorativeMain.WaterPump, 2)
                    .input('#', Blocks.GREEN_TERRACOTTA)
                    .pattern("#")
                    .pattern("#")
                    .criterion(FabricRecipeProvider.hasItem(Blocks.GREEN_TERRACOTTA), FabricRecipeProvider.conditionsFromItem(Blocks.GREEN_TERRACOTTA))
                    .offerTo(exporter);

        }
        private ShapedRecipeJsonBuilder createLogWithAxeRecipe(ChoppingLog log) {
            return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, log)
                    .input('#', Items.IRON_AXE)
                    .input('O', log.baseLog.asItem())
                    .pattern("#").pattern( "O")
                    .criterion(FabricRecipeProvider.hasItem(Items.IRON_AXE), FabricRecipeProvider.conditionsFromItem(Items.IRON_AXE))
                    .criterion(FabricRecipeProvider.hasItem(log.baseLog), FabricRecipeProvider.conditionsFromItem(log.baseLog));
        }
        private ShapedRecipeJsonBuilder createBathTireRecipe(ColorUtil.VanillaColor color) {
            Item bathTire = Registries.ITEM.get(id(color.getName()+"_bath_tire"));
            Block concreteType = Registries.BLOCK.get(Identifier.ofVanilla(color.getName()+"_concrete"));
            return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, bathTire, 3)
                    .input('#', concreteType)
                    .pattern("###")
                    .pattern("# #")
                    .pattern("###")
                    .criterion(FabricRecipeProvider.hasItem(concreteType), FabricRecipeProvider.conditionsFromItem(concreteType));
        }
        private ShapedRecipeJsonBuilder createDigitalClockRecipe(ColorUtil.VanillaColor color) {
            Block digitalClock = Registries.BLOCK.get(id(color.getName()+"_digital_clock"));
            Block concreteType = Registries.BLOCK.get(Identifier.ofVanilla(color.getName()+"_concrete"));
            return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, digitalClock, 3)
                    .input('#', concreteType)
                    .input('B', Blocks.BLACK_CONCRETE)
                    .input('C', Items.CLOCK)
                    .pattern("#B#")
                    .pattern("#C#")
                    .criterion(FabricRecipeProvider.hasItem(concreteType), FabricRecipeProvider.conditionsFromItem(concreteType));
        }
        private ShapedRecipeJsonBuilder createLampRecipe(ColorUtil.VanillaColor color) {
            Block lamp = Registries.BLOCK.get(id(color.getName()+"_lamp"));
            Block woolType = Registries.BLOCK.get(Identifier.ofVanilla(color.getName()+"_wool"));
            return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, lamp, 3)
                    .input('#', woolType)
                    .input('R', Blocks.REDSTONE_LAMP)
                    .input('B', Blocks.BLACK_CONCRETE)
                    .pattern("###")
                    .pattern("#R#")
                    .pattern(" B ")
                    .criterion(FabricRecipeProvider.hasItem(woolType), FabricRecipeProvider.conditionsFromItem(woolType));
        }
        private ShapedRecipeJsonBuilder createDoubleLampRecipe(ColorUtil.VanillaColor color) {
            Block doubleLamp = Registries.BLOCK.get(id(color.getName()+"_double_lamp"));
            Block lamp = Registries.BLOCK.get(id(color.getName()+"_lamp"));
            return ShapedRecipeJsonBuilder.create(RecipeCategory.DECORATIONS, doubleLamp)
                    .input('#', lamp)
                    .pattern("#")
                    .pattern("#")
                    .criterion(FabricRecipeProvider.hasItem(lamp), FabricRecipeProvider.conditionsFromItem(lamp));
        }

        private void generateStonecutting(RecipeExporter exporter) {
            Signs.SIGNS.forEach(sign -> StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Signs.EmptySign), RecipeCategory.TRANSPORTATION, sign).criterion(FabricRecipeProvider.hasItem(Signs.EmptySign), FabricRecipeProvider.conditionsFromItem(Signs.EmptySign)).offerTo(exporter));
            StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(RockyAsphalt), RecipeCategory.TRANSPORTATION, DecorativeMain.Road, 4).criterion(FabricRecipeProvider.hasItem(RockyAsphalt), FabricRecipeProvider.conditionsFromItem(RockyAsphalt)).offerTo(exporter);
            StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(RockyAsphalt), RecipeCategory.TRANSPORTATION, DecorativeMain.RoadWhiteShort, 4).criterion(FabricRecipeProvider.hasItem(RockyAsphalt), FabricRecipeProvider.conditionsFromItem(RockyAsphalt)).offerTo(exporter);
            StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(RockyAsphalt), RecipeCategory.TRANSPORTATION, DecorativeMain.RoadWhiteLong, 4).criterion(FabricRecipeProvider.hasItem(RockyAsphalt), FabricRecipeProvider.conditionsFromItem(RockyAsphalt)).offerTo(exporter);
            StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Road), RecipeCategory.TRANSPORTATION, DecorativeMain.RoadWhiteShort).criterion(FabricRecipeProvider.hasItem(Road), FabricRecipeProvider.conditionsFromItem(Road)).offerTo(exporter, "road_white_short_from_road");
            StonecuttingRecipeJsonBuilder.createStonecutting(Ingredient.ofItems(Road), RecipeCategory.TRANSPORTATION, DecorativeMain.RoadWhiteLong).criterion(FabricRecipeProvider.hasItem(Road), FabricRecipeProvider.conditionsFromItem(Road)).offerTo(exporter, "road_long_short_from_road");
        }
}
