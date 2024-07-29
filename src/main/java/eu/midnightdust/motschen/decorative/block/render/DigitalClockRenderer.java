package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.DigitalClockBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;

import static eu.midnightdust.motschen.decorative.util.TimeUtil.getTime;

@Environment(EnvType.CLIENT)
public class DigitalClockRenderer implements BlockEntityRenderer<DigitalClockBlockEntity> {
    private final TextRenderer textRenderer;

    public DigitalClockRenderer(BlockEntityRendererFactory.Context ctx) {
        textRenderer = ctx.getTextRenderer();
    }


    @Override
    public void render(DigitalClockBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        matrices.translate(blockEntity.getX(),0.35,blockEntity.getZ());

        matrices.scale(0.025f, 0.025f, 0.025f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.getFacing()));
        matrices.translate(0,0,-0.1);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        textRenderer.draw(getTime(), 0, 0, 16382457, false, matrices.peek().getPositionMatrix(), vertexConsumers, TextRenderer.TextLayerType.POLYGON_OFFSET, 0, light);
        matrices.pop();
    }
}