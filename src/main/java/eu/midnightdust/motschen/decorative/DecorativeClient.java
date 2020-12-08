package eu.midnightdust.motschen.decorative;

import eu.midnightdust.motschen.decorative.block.render.*;
import eu.midnightdust.motschen.decorative.entity.client.renderer.*;
import eu.midnightdust.motschen.decorative.init.BathTires;
import eu.midnightdust.motschen.decorative.init.BlockEntities;
import eu.midnightdust.motschen.decorative.init.Pool;
import eu.midnightdust.motschen.decorative.init.Signs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.model.ModelLoadingRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.BlockEntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.command.argument.ItemEnchantmentArgumentType;

import java.util.function.Supplier;

public class DecorativeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

        EntityRendererRegistry.INSTANCE.register(Pool.BEACH_BALL, (dispatcher, context) -> new BeachBallRenderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(BathTires.WHITE_BATH_TIRE, (dispatcher, context) -> new WhiteBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.ORANGE_BATH_TIRE, (dispatcher, context) -> new OrangeBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.MAGENTA_BATH_TIRE, (dispatcher, context) -> new MagentaBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIGHT_BLUE_BATH_TIRE, (dispatcher, context) -> new LightBlueBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.YELLOW_BATH_TIRE, (dispatcher, context) -> new YellowBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIME_BATH_TIRE, (dispatcher, context) -> new LimeBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.PINK_BATH_TIRE, (dispatcher, context) -> new PinkBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.GRAY_BATH_TIRE, (dispatcher, context) -> new GrayBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.LIGHT_GRAY_BATH_TIRE, (dispatcher, context) -> new LightGrayBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.CYAN_BATH_TIRE, (dispatcher, context) -> new CyanBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.PURPLE_BATH_TIRE, (dispatcher, context) -> new PurpleBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.BLUE_BATH_TIRE, (dispatcher, context) -> new BlueBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.BROWN_BATH_TIRE, (dispatcher, context) -> new BrownBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.GREEN_BATH_TIRE, (dispatcher, context) -> new GreenBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.RED_BATH_TIRE, (dispatcher, context) -> new RedBathTireRenderer(dispatcher));
        EntityRendererRegistry.INSTANCE.register(BathTires.BLACK_BATH_TIRE, (dispatcher, context) -> new BlackBathTireRenderer(dispatcher));

        EntityRendererRegistry.INSTANCE.register(BathTires.DUCK_BATH_TIRE, (dispatcher, context) -> new DuckBathTireRenderer(dispatcher));


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
