package eu.midnightdust.motschen.decorative.block.render;

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
        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(Objects.requireNonNull(blockEntity.getWorld()), blockEntity.getPos().up());
        matrices.translate(blockEntity.getAxeX(), 1.5D, blockEntity.getAxeZ());
        matrices.scale(2.5f,2.5f,2.5f);
        matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(blockEntity.getFacing()));
        matrices.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(160));
        client.getItemRenderer().renderItem(new ItemStack(Items.IRON_AXE), ModelTransformationMode.GROUND, lightAbove, overlay, matrices, vertexConsumers, blockEntity.getWorld(), 0);
        matrices.pop();
    }
}
