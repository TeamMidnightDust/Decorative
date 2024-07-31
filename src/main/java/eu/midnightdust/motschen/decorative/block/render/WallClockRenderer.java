package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.WallClockBlockEntity;
import eu.midnightdust.motschen.decorative.block.render.model.WallClockHandsModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.RotationAxis;

import java.time.LocalTime;

import static eu.midnightdust.motschen.decorative.util.TimeUtil.getHour12hFormat;

@Environment(EnvType.CLIENT)
public class WallClockRenderer implements BlockEntityRenderer<WallClockBlockEntity> {
    private final WallClockHandsModel handsModel;

    public WallClockRenderer(BlockEntityRendererFactory.Context ctx) {
        handsModel = new WallClockHandsModel(ctx.getLayerModelPart(WallClockHandsModel.CLOCK_HANDS_MODEL_LAYER));
    }

    @Override
    public void render(WallClockBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        int facing;
        double x, z;
        switch (blockEntity.getCachedState().get(HorizontalFacingBlock.FACING)) {
            case NORTH -> {
                facing = 0; x = 0.5; z = 0.95;
            }
            case EAST -> {
                facing = 270; x = 0.05; z = 0.5;
            }
            case SOUTH -> {
                facing = 180; x = 0.5; z = 0.05;
            }
            default -> {
                facing = 90; x = 0.95; z = 0.5;
            }
        }
        VertexConsumer vertex = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(Identifier.ofVanilla("textures/block/red_concrete.png")));

        matrices.push();
        matrices.translate(x,0.5,z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(LocalTime.now().getSecond() * 6));
        handsModel.seconds.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(1.0F, 1.0F, 1.0F, 1.0F));
        matrices.pop();

        matrices.push();
        matrices.translate(x,0.5,z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(LocalTime.now().getMinute() * 6));
        handsModel.minutes.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(0.0F, 0.0F, 0.0F, 1.0F));
        matrices.pop();

        matrices.push();
        matrices.translate(x,0.5,z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(getHour12hFormat() * 30));
        handsModel.hours.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(0.0F, 0.0F, 0.0F, 1.0F));
        matrices.pop();
    }
}
