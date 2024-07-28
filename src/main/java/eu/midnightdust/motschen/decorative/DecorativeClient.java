package eu.midnightdust.motschen.decorative;

import eu.midnightdust.motschen.decorative.block.render.*;
import eu.midnightdust.motschen.decorative.block.render.model.CeilingFanBladesModel;
import eu.midnightdust.motschen.decorative.block.render.model.WallClockHandsModel;
import eu.midnightdust.motschen.decorative.entity.client.model.BathTireModel;
import eu.midnightdust.motschen.decorative.entity.client.model.BeachBallModel;
import eu.midnightdust.motschen.decorative.entity.client.model.DuckBathTireModel;
import eu.midnightdust.motschen.decorative.entity.client.renderer.*;
import eu.midnightdust.motschen.decorative.init.BathTires;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.init.Pool;
import eu.midnightdust.motschen.decorative.init.Signs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.util.DyeColor;

public class DecorativeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BathTireModel.BATH_TIRE_MODEL_LAYER, BathTireModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DuckBathTireModel.DUCK_BATH_TIRE_MODEL_LAYER, DuckBathTireModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(BeachBallModel.BEACH_BALL_MODEL_LAYER, BeachBallModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(CeilingFanBladesModel.CEILING_FAN_MODEL_LAYER, CeilingFanBladesModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WallClockHandsModel.CLOCK_HANDS_MODEL_LAYER, WallClockHandsModel::getTexturedModelData);

        EntityRendererRegistry.register(Pool.BEACH_BALL, BeachBallRenderer::new);

        EntityRendererRegistry.register(BathTires.WHITE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.WHITE));
        EntityRendererRegistry.register(BathTires.ORANGE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.ORANGE));
        EntityRendererRegistry.register(BathTires.MAGENTA_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.MAGENTA));
        EntityRendererRegistry.register(BathTires.LIGHT_BLUE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIGHT_BLUE));
        EntityRendererRegistry.register(BathTires.YELLOW_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.YELLOW));
        EntityRendererRegistry.register(BathTires.LIME_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIME));
        EntityRendererRegistry.register(BathTires.PINK_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.PINK));
        EntityRendererRegistry.register(BathTires.GRAY_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.GRAY));
        EntityRendererRegistry.register(BathTires.LIGHT_GRAY_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIGHT_GRAY));
        EntityRendererRegistry.register(BathTires.CYAN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.CYAN));
        EntityRendererRegistry.register(BathTires.PURPLE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.PURPLE));
        EntityRendererRegistry.register(BathTires.BLUE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BLUE));
        EntityRendererRegistry.register(BathTires.BROWN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BROWN));
        EntityRendererRegistry.register(BathTires.GREEN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.GREEN));
        EntityRendererRegistry.register(BathTires.RED_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.RED));
        EntityRendererRegistry.register(BathTires.BLACK_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BLACK));

        EntityRendererRegistry.register(BathTires.DUCK_BATH_TIRE, DuckBathTireRenderer::new);


        registerBlockColor(DecorativeMain.BirdBath, Blocks.WATER);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.RoadWhiteShort);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.RoadWhiteLong);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.EmptySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.StopSign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.FiveSign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.TenSign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.TwentySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.ThirtySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.FortySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.FiftySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.SixtySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.SeventySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.EightySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.NinetySign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.OnehundredSign);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(), Signs.OnehundredtenSign);

        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.ChristmasTree);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.CeilingFan);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.SlidingDoor);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getCutout(),DecorativeMain.WallClock);
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),DecorativeMain.BirdBath);

        BlockEntityRendererFactories.register(BlockEntities.CeilingFanBlockEntity, CeilingFanRenderer::new);
        BlockEntityRendererFactories.register(BlockEntities.ChoppingLogBlockEntity, ChoppingLogBlockEntityRenderer::new);
        BlockEntityRendererFactories.register(BlockEntities.WallClockBlockEntity, WallClockRenderer::new);
        BlockEntityRendererFactories.register(BlockEntities.DigitalClockBlockEntity, DigitalClockRenderer::new);
    }
    public void registerBlockColor(Block block, Block templateBlock) {
        ColorProviderRegistry.BLOCK.register((type, pos, world, layer) -> {
            BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
            return provider == null ? -1 : provider.getColor(type, pos, world, layer);
        }, block);
    }
}
