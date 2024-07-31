package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import eu.midnightdust.motschen.decorative.block.blockentity.ChoppingLogBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.RotationAxis;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class ChoppingLogBlockEntityRenderer implements BlockEntityRenderer<ChoppingLogBlockEntity> {
    private static final MinecraftClient client = MinecraftClient.getInstance();

    public ChoppingLogBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {}

    @Override
    public boolean rendersOutsideBoundingBox(ChoppingLogBlockEntity blockEntity) {
        return true;
    }

    @Override
    public void render(ChoppingLogBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        int facing;
        double x, z;
        switch (blockEntity.getCachedState().get(ChoppingLog.FACING)) {
            case EAST -> {
                facing = 180; x = 0.2D; z = 0.5D;
            }
            case SOUTH -> {
                facing = 90; x = 0.5D; z = 0.2D;
            }
            case WEST -> {
                facing = 0; x = 0.8D; z = 0.5D;
            }
            default -> {
                facing = 270; x = 0.5D; z = 0.8D;
            }
        }
        int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(blockEntity.getWorld()), blockEntity.getPos().up());
        matrices.push();
        matrices.translate(x, 1.5D, z);
        matrices.scale(2.5f,2.5f,2.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(facing));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(160));
        client.getItemRenderer().renderItem(new ItemStack(Items.IRON_AXE), ModelTransformationMode.GROUND, lightAbove, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0);
        matrices.pop();
    }
}
