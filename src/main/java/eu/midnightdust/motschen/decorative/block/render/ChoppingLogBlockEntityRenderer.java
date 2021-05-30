package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.ChoppingLogBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.Vec3f;

import java.util.Objects;

@Environment(EnvType.CLIENT)
public class ChoppingLogBlockEntityRenderer implements BlockEntityRenderer<ChoppingLogBlockEntity> {

    public ChoppingLogBlockEntityRenderer(BlockEntityRendererFactory.Context ctx) {
    }

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
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));
        matrices.multiply(Vec3f.POSITIVE_Z.getDegreesQuaternion(160));
        MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.IRON_AXE), ModelTransformation.Mode.GROUND, lightAbove, overlay, matrices, vertexConsumers, 0);
        matrices.pop();
    }
}
