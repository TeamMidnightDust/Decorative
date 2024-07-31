package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.DigitalClockBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.HorizontalFacingBlock;
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
        int facing;
        double x, z;
        switch (blockEntity.getCachedState().get(HorizontalFacingBlock.FACING)) {
            case NORTH -> {
                facing = 0;
                x = 0.825;
                z = 0.374;
            }
            case EAST -> {
                facing = 270;
                x = 0.626;
                z = 0.825;
            }
            case SOUTH -> {
                facing = 180;
                x = 0.175;
                z = 0.626;
            }
            default -> {
                facing = 90;
                x = 0.374;
                z = 0.175;
            }
        }
        matrices.push();
        matrices.translate(x,0.35,z);

        matrices.scale(0.025f, 0.025f, 0.025f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(facing));
        matrices.translate(0,0,-0.1);
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(180));
        textRenderer.draw(getTime(), 0, 0, 16382457, false, matrices.peek().getPositionMatrix(), vertexConsumers, TextRenderer.TextLayerType.POLYGON_OFFSET, 0, light);
        matrices.pop();
    }
}