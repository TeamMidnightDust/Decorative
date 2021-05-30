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
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.util.DyeColor;

@SuppressWarnings({"deprecation", "UnstableApiUsage"})
public class DecorativeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityModelLayerRegistry.registerModelLayer(BathTireModel.BATH_TIRE_MODEL_LAYER, BathTireModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(DuckBathTireModel.DUCK_BATH_TIRE_MODEL_LAYER, DuckBathTireModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(BeachBallModel.BEACH_BALL_MODEL_LAYER, BeachBallModel::getTexturedModelData);

        EntityModelLayerRegistry.registerModelLayer(CeilingFanBladesModel.CEILING_FAN_MODEL_LAYER, CeilingFanBladesModel::getTexturedModelData);
        EntityModelLayerRegistry.registerModelLayer(WallClockHandsModel.CLOCK_HANDS_MODEL_LAYER, WallClockHandsModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(Pool.BEACH_BALL, BeachBallRenderer::new);

        EntityRendererRegistry.INSTANCE.register(BathTires.WHITE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.WHITE));
        EntityRendererRegistry.INSTANCE.register(BathTires.ORANGE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.ORANGE));
        EntityRendererRegistry.INSTANCE.register(BathTires.MAGENTA_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.MAGENTA));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIGHT_BLUE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIGHT_BLUE));
        EntityRendererRegistry.INSTANCE.register(BathTires.YELLOW_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.YELLOW));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIME_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIME));
        EntityRendererRegistry.INSTANCE.register(BathTires.PINK_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.PINK));
        EntityRendererRegistry.INSTANCE.register(BathTires.GRAY_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.GRAY));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIGHT_GRAY_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.LIGHT_GRAY));
        EntityRendererRegistry.INSTANCE.register(BathTires.CYAN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.CYAN));
        EntityRendererRegistry.INSTANCE.register(BathTires.PURPLE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.PURPLE));
        EntityRendererRegistry.INSTANCE.register(BathTires.BLUE_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BLUE));
        EntityRendererRegistry.INSTANCE.register(BathTires.BROWN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BROWN));
        EntityRendererRegistry.INSTANCE.register(BathTires.GREEN_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.GREEN));
        EntityRendererRegistry.INSTANCE.register(BathTires.RED_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.RED));
        EntityRendererRegistry.INSTANCE.register(BathTires.BLACK_BATH_TIRE, (context) -> new BathTireRenderer(context, DyeColor.BLACK));

        EntityRendererRegistry.INSTANCE.register(BathTires.DUCK_BATH_TIRE, DuckBathTireRenderer::new);


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

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.CeilingFanBlockEntity, CeilingFanRenderer::new);

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.ChoppingLogBlockEntity, ChoppingLogBlockEntityRenderer::new);

        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.WallClockBlockEntity, WallClockRenderer::new);
        BlockEntityRendererRegistry.INSTANCE.register(BlockEntities.DigitalClockBlockEntity, DigitalClockRenderer::new);
    }
    public void registerBlockColor(Block block, Block templateBlock) {
        ColorProviderRegistry.BLOCK.register((type, pos, world, layer) -> {
            BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
            return provider == null ? -1 : provider.getColor(type, pos, world, layer);
        }, block);
    }

}
