package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.CeilingFanBlockEntity;
import eu.midnightdust.motschen.decorative.block.render.model.CeilingFanBladesModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.ColorHelper;
import net.minecraft.util.math.RotationAxis;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer implements BlockEntityRenderer<CeilingFanBlockEntity> {
    private final CeilingFanBladesModel blades;

    public CeilingFanRenderer(BlockEntityRendererFactory.Context ctx) {
        blades = new CeilingFanBladesModel(ctx.getLayerModelPart(CeilingFanBladesModel.CEILING_FAN_MODEL_LAYER));
    }

    @Override
    public boolean rendersOutsideBoundingBox(CeilingFanBlockEntity blockEntity) {
        return true;
    }


    @Override
    public void render(CeilingFanBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(id("textures/block/ceilingfan.png")));
        matrices.translate(0.5,0.31,0.5);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.getRot()));
        blades.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, ColorHelper.Argb.fromFloats(1.0F, 1.0F, 1.0F, 1.0F));
        matrices.pop();
    }
}
