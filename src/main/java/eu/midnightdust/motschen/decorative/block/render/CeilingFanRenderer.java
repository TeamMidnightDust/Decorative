package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.CeilingFanBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class CeilingFanRenderer extends BlockEntityRenderer<CeilingFanBlockEntity> {
    private final ModelPart blades;
    private final ModelPart point;

    public CeilingFanRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
        blades = new ModelPart(64, 64, 0, 0);
        blades.setPivot(0.0F, 0.0F, 0.0F);
        blades.addCuboid(-1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 10.0F, 0.0F);
        blades.addCuboid(-1.0F, 0.0F, -11.0F, 2.0F, 1.0F, 10.0F, 0.0F);
        blades.addCuboid(1.0F, 0.0F, -1.0F, 10.0F, 1.0F, 2.0F, 0.0F);
        blades.addCuboid(-11.0F, 0.0F, -1.0F, 10.0F, 1.0F, 2.0F, 0.0F);
        point = new ModelPart(32, 32, 16, 0);
        point.addCuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F);
        blades.addChild(point);
    }

    @Override
    public boolean rendersOutsideBoundingBox(CeilingFanBlockEntity blockEntity) {
        return true;
    }


    @Override
    public void render(CeilingFanBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(new Identifier("decorative:textures/block/ceilingfan.png")));
        matrices.translate(0.5,0.31,0.5);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getRot()));
        blades.render(matrices, vertexConsumer, light, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
