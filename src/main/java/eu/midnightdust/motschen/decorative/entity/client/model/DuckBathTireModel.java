package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class DuckBathTireModel extends EntityModel<BathTireEntity> {
	private final ModelPart body;
	public static final EntityModelLayer DUCK_BATH_TIRE_MODEL_LAYER = new EntityModelLayer(new Identifier("decorative", "duck_bath_tire"), "main");

	public DuckBathTireModel(ModelPart root) {
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
		modelPartData.addChild("cube1", ModelPartBuilder.create().uv(0, 9).cuboid(6.0F, -3.0F, -8.0F, 4.0F, 3.0F, 16.0F), ModelTransform.NONE);
		modelPartData.addChild("cube2", ModelPartBuilder.create().uv(0, 37).cuboid(-10.0F, -3.0F, -8.0F, 4.0F, 3.0F, 16.0F), ModelTransform.NONE);
		modelPartData.addChild("cube3", ModelPartBuilder.create().uv(0, 57).cuboid(-8.0F, -2.99F, -10.0F, 16.0F, 3.0F, 4.0F), ModelTransform.NONE);
		modelPartData.addChild("cube4", ModelPartBuilder.create().uv(0, 29).cuboid(-8.0F, -2.99F, 6.0F, 16.0F, 3.0F, 4.0F), ModelTransform.NONE);
		modelPartData.addChild("cube5", ModelPartBuilder.create().uv(50, 0).cuboid(-2.0F, -8.0F, -10.0F, 4.0F, 5.0F, 3.0F), ModelTransform.NONE);
		modelPartData.addChild("cube6", ModelPartBuilder.create().uv(46, 11).cuboid(-2.999F, -10.0F, -12.0F, 6.0F, 5.0F, 3.0F), ModelTransform.NONE);
		modelPartData.addChild("cube7", ModelPartBuilder.create().uv(15, 31).cuboid(-2.499F, -10.5F, -12.001F, 5.0F, 1.0F, 3.0F), ModelTransform.NONE);
		modelPartData.addChild("cube8", ModelPartBuilder.create().uv(58, 20).cuboid(-0.999F, -8.0F, -13.0F, 2.0F, 2.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube9", ModelPartBuilder.create().uv(58, 20).cuboid(-1.999F, -7.0F, -13.0F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube10", ModelPartBuilder.create().uv(53, 21).cuboid(-1.999F, -10.0F, -12.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube11", ModelPartBuilder.create().uv(53, 21).cuboid(1.001F, -10.0F, -12.5F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
		modelPartData.addChild("cube12", ModelPartBuilder.create().uv(58, 20).cuboid(1.001F, -7.0F, -13.0F, 1.0F, 1.0F, 1.0F), ModelTransform.NONE);
		return modelData;
	}

	@Override
	public void setAngles(BathTireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}