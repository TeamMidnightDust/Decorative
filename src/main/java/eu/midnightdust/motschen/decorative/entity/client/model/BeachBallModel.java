package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class BeachBallModel extends EntityModel<BeachBallEntity> {
	private final ModelPart body;
	public static final EntityModelLayer BEACH_BALL_MODEL_LAYER = new EntityModelLayer(new Identifier("decorative", "beach_ball"), "main");

	public BeachBallModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		body = root;
		body.setPivot(0.0F, 20.0F, 0.0F);
	}

	public static TexturedModelData getTexturedModelData() {
		return TexturedModelData.of(getModelData(), 64, 64);
	}

	public static ModelData getModelData(){
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("cube1", ModelPartBuilder.create().uv(0, 22).cuboid(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F), ModelTransform.NONE);
		modelPartData.addChild("cube2", ModelPartBuilder.create().uv(0, 22).cuboid(-4.0F, -12.0F, -4.0F, 8.0F, 1.0F, 8.0F), ModelTransform.NONE);
		modelPartData.addChild("cube3", ModelPartBuilder.create().uv(0, 48).cuboid(-6.0F, -10.0F, -4.0F, 1.0F, 8.0F, 8.0F), ModelTransform.NONE);
		modelPartData.addChild("cube4", ModelPartBuilder.create().uv(20, 48).cuboid(5.0F, -10.0F, -4.0F, 1.0F, 8.0F, 8.0F), ModelTransform.NONE);
		modelPartData.addChild("cube5", ModelPartBuilder.create().uv(0, 33).cuboid(-4.0F, -10.0F, -6.0F, 8.0F, 8.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube6", ModelPartBuilder.create().uv(20, 33).cuboid(-4.0F, -10.0F, 5.0F, 8.0F, 8.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube7", ModelPartBuilder.create().uv(0,0).cuboid(-5.0F, -11.0F, -5.0F, 10.0F, 10.0F, 10.0F), ModelTransform.NONE);
		return modelData;
	}

	@Override
	public void setAngles(BeachBallEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}