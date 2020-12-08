package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.WallClockBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.util.Identifier;

import java.time.LocalTime;

@Environment(EnvType.CLIENT)
public class WallClockRenderer extends BlockEntityRenderer<WallClockBlockEntity> {
    private final ModelPart blades;
    private final ModelPart seconds;
    private final ModelPart minutes;
    private final ModelPart hours;

    public WallClockRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
        blades = new ModelPart(16, 16, 0, 0);
        blades.setPivot(0.0F, 0.0F, 0.0F);

        seconds = new ModelPart(16, 16, 8, 0);
        seconds.addCuboid(-0.175F, 0.0F, 0.0F, 0.25F, 7.0F, 0.2F, 0.0F);
        blades.addChild(seconds);

        minutes = new ModelPart(16, 16, 0, 0);
        minutes.addCuboid(-0.25F, 0.0F, 0.0F, 0.5F, 6.0F, 0.2F, 0.0F);
        blades.addChild(minutes);

        hours = new ModelPart(16, 16, 0, 0);
        hours.addCuboid(-0.25F, 0.0F, 0.0F, 0.5F, 4.0F, 0.2F, 0.0F);
        blades.addChild(hours);
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

        int lightAtBlock = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos());

        matrices.push();
        VertexConsumer redVertex = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(new Identifier("textures/block/red_concrete.png")));
        int lightAtBlock1 = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos());
        matrices.translate(blockEntity.getX(),0.5,blockEntity.getZ());
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(LocalTime.now().getSecond() * 6));
        seconds.render(matrices, redVertex, lightAtBlock1, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();

        matrices.push();
        VertexConsumer blackVertex = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(new Identifier("textures/block/black_concrete.png")));
        int lightAtBlock2 = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos());
        matrices.translate(blockEntity.getX(),0.5,blockEntity.getZ());
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(LocalTime.now().getMinute() * 6));
        minutes.render(matrices, blackVertex, lightAtBlock2, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();

        matrices.push();
        VertexConsumer blackVertex2 = vertexConsumers.getBuffer(RenderLayer.getEntityCutoutNoCull(new Identifier("textures/block/black_concrete.png")));
        int lightAtBlock3 = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos());
        matrices.translate(blockEntity.getX(),0.5,blockEntity.getZ());
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(getHour12hFormat() * 30));
        hours.render(matrices, blackVertex2, lightAtBlock3, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
        matrices.pop();
    }
}
