package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.block.blockentity.AcaciaChoppingLogBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;

@Environment(EnvType.CLIENT)
public class AcaciaChoppingLogBlockEntityRenderer extends BlockEntityRenderer<AcaciaChoppingLogBlockEntity> {

    public AcaciaChoppingLogBlockEntityRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }

    @Override
    public boolean rendersOutsideBoundingBox(AcaciaChoppingLogBlockEntity blockEntity) {
        return true;
    }


    @Override
    public void render(AcaciaChoppingLogBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        BlockPos pos = blockEntity.getPos();
        BlockState state = blockEntity.getWorld().getBlockState(pos);

        matrices.push();
        int lightAbove = WorldRenderer.getLightmapCoordinates(blockEntity.getWorld(), blockEntity.getPos().up());

        matrices.translate(blockEntity.getAxeX(), 1.5D, blockEntity.getAxeZ());
        matrices.scale(2.5f,2.5f,2.5f);

        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));

        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(160));
        MinecraftClient.getInstance().getItemRenderer().renderItem(new ItemStack(Items.IRON_AXE),
                ModelTransformation.Mode.GROUND, lightAbove, overlay, matrices, vertexConsumers);


        matrices.pop();
    }
}
