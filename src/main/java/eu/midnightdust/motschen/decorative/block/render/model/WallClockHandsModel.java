package eu.midnightdust.motschen.decorative.block.render.model;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class WallClockHandsModel extends Model {
    private final ModelPart hands;
    public final ModelPart seconds;
    public final ModelPart minutes;
    public final ModelPart hours;
    public static final EntityModelLayer CLOCK_HANDS_MODEL_LAYER = new EntityModelLayer(id("clock_hands"), "main");

    public WallClockHandsModel(ModelPart root) {
        super(RenderLayer::getEntitySolid);
        hands = root;
        hands.setPivot(0.0F, 0.0F, 0.0F);

        seconds = hands.getChild("seconds");//new ModelPart(16, 16, 8, 0);
        minutes = hands.getChild("minutes");//new ModelPart(16, 16, 0, 0);
        hours = hands.getChild("hours");//new ModelPart(16, 16, 0, 0);
    }
    public ModelPart getPart() {
        return hands;
    }

    public static TexturedModelData getTexturedModelData() {
        return TexturedModelData.of(getModelData(), 16, 16);
    }

    public static ModelData getModelData(){
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("seconds", ModelPartBuilder.create().uv(0, 0).cuboid(-0.175F, 0.0F, 0.01F, 0.25F, 7.0F, 0.2F), ModelTransform.NONE);
        modelPartData.addChild("minutes", ModelPartBuilder.create().uv(0, 0).cuboid(-0.25F, 0.0F, 0.0F, 0.5F, 6.0F, 0.2F), ModelTransform.NONE);
        modelPartData.addChild("hours", ModelPartBuilder.create().uv(0, 0).cuboid(-0.25F, 0.0F, 0.0F, 0.5F, 4.0F, 0.2F), ModelTransform.NONE);
        return modelData;
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
        hands.render(matrices, vertices, light, overlay, color);
    }
}
