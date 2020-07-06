package eu.midnightdust.motschen.decorative;

import eu.midnightdust.motschen.decorative.init.Signs;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.color.block.BlockColorProvider;
import net.minecraft.client.color.item.ItemColorProvider;
import net.minecraft.client.render.RenderLayer;

public class DecorativeClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
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
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(),DecorativeMain.BirdBath);

    }
    public void registerBlockColor(Block block, Block templateBlock) {
        ColorProviderRegistry.BLOCK.register((type, pos, world, layer) -> {
            BlockColorProvider provider = ColorProviderRegistry.BLOCK.get(templateBlock);
            return provider == null ? -1 : provider.getColor(type, pos, world, layer);
        }, block);
    }

}
