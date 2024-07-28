package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class BathTireModel extends EntityModel<BathTireEntity> {
	private final ModelPart body;
	public static final EntityModelLayer BATH_TIRE_MODEL_LAYER = new EntityModelLayer(id("bath_tire"), "main");

	public BathTireModel(ModelPart root) {
		super(RenderLayer::getEntitySolid);
		body = root;
		body.setPivot(0.0F, 24.0F, 0.0F);
	}

	public static TexturedModelData getTexturedModelData() {
		return TexturedModelData.of(getModelData(), 16, 16);
	}

	public static ModelData getModelData(){
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		modelPartData.addChild("cube1", ModelPartBuilder.create().cuboid(6.0F, -9.0F, -11.0F, 4.0F, 4.0F, 16.0F), ModelTransform.NONE);
		modelPartData.addChild("cube2", ModelPartBuilder.create().cuboid(-10.0F, -9.0F, -11.0F, 4.0F, 4.0F, 16.0F), ModelTransform.NONE);
		modelPartData.addChild("cube3", ModelPartBuilder.create().cuboid(-8.0F, -8.99F, -13.0F, 16.0F, 4.0F, 4.0F), ModelTransform.NONE);
		modelPartData.addChild("cube4", ModelPartBuilder.create().cuboid(-8.0F, -8.99F, 3.0F, 16.0F, 4.0F, 4.0F), ModelTransform.NONE);
		return modelData;
	}

	@Override
	public void setAngles(BathTireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, int color){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}
}