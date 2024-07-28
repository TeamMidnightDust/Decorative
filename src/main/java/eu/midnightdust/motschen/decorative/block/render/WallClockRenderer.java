package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.WallClockBlockEntity;
import eu.midnightdust.motschen.decorative.block.render.model.WallClockHandsModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.RotationAxis;

import java.time.LocalTime;

@Environment(EnvType.CLIENT)
public class WallClockRenderer implements BlockEntityRenderer<WallClockBlockEntity> {
    private final WallClockHandsModel handsModel;

    public WallClockRenderer(BlockEntityRendererFactory.Context ctx) {
        handsModel = new WallClockHandsModel(ctx.getLayerModelPart(WallClockHandsModel.CLOCK_HANDS_MODEL_LAYER));
    }

    private int getHour12hFormat() {
        int hour;
        hour = LocalTime.now().getHour();
        if (hour >= 12) {
            hour = hour - 12;
        }
        return hour;
    }

    @Override
    public void render(WallClockBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        VertexConsumer vertex = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(Identifier.ofVanilla("textures/block/red_concrete.png")));

        matrices.push();
        matrices.translate(blockEntity.x,0.5,blockEntity.z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(LocalTime.now().getSecond() * 6));
        handsModel.seconds.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(1.0F, 1.0F, 1.0F, 1.0F));
        matrices.pop();

        matrices.push();
        matrices.translate(blockEntity.x,0.5,blockEntity.z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(LocalTime.now().getMinute() * 6));
        handsModel.minutes.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(0.0F, 0.0F, 0.0F, 1.0F));
        matrices.pop();

        matrices.push();
        matrices.translate(blockEntity.x,0.5,blockEntity.z);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(getHour12hFormat() * 30));
        handsModel.hours.render(matrices, vertex, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(0.0F, 0.0F, 0.0F, 1.0F));
        matrices.pop();
    }
}
