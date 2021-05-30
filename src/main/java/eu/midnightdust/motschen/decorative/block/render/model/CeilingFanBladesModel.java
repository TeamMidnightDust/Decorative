package eu.midnightdust.motschen.decorative.block.render.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class CeilingFanBladesModel extends Model {
    private final ModelPart blades;
    public static final EntityModelLayer CEILING_FAN_MODEL_LAYER = new EntityModelLayer(new Identifier("decorative", "ceiling_fan"), "main");

    public CeilingFanBladesModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        blades = root;
        blades.setPivot(0.0F, 0.0F, 0.0F);
    }
    public ModelPart getPart() {
        return blades;
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getModelData(), 64, 64);
    }

    public static ModelData getModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("blade1", ModelPartBuilder.create().cuboid(-1.0F, 0.0F, 1.0F, 2.0F, 1.0F, 10.0F), ModelTransform.NONE);
        modelPartData.addChild("blade2", ModelPartBuilder.create().cuboid(-1.0F, 0.0F, -11.0F, 2.0F, 1.0F, 10.0F), ModelTransform.NONE);
        modelPartData.addChild("blade3", ModelPartBuilder.create().cuboid(1.0F, 0.0F, -1.0F, 10.0F, 1.0F, 2.0F), ModelTransform.NONE);
        modelPartData.addChild("blade4", ModelPartBuilder.create().cuboid(-11.0F, 0.0F, -1.0F, 10.0F, 1.0F, 2.0F), ModelTransform.NONE);
        modelPartData.addChild("point", ModelPartBuilder.create().uv(32,0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F), ModelTransform.NONE);
        return modelData;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        blades.render(matrices, vertices, light, overlay, red, green, blue, alpha);
    }
}
