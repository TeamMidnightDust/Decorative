package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BathTireModel extends EntityModel<BathTireEntity> {
	private final ModelPart body;

	public BathTireModel() {
		textureWidth = 16;
		textureHeight = 16;

		body = new ModelPart(this);
		body.setPivot(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 0).addCuboid(6.0F, -9.0F, -11.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addCuboid(-10.0F, -9.0F, -11.0F, 4.0F, 4.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addCuboid(-8.0F, -8.99F, -13.0F, 16.0F, 4.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addCuboid(-8.0F, -8.99F, 3.0F, 16.0F, 4.0F, 4.0F, 0.0F, false);
	}

	@Override
	public void setAngles(BathTireEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
		//previously the render function, render code was moved to a method below
	}

	@Override
	public void render(MatrixStack matrixStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha){
		body.render(matrixStack, buffer, packedLight, packedOverlay);
	}

	public void setRotationAngle(ModelPart modelRenderer, float x, float y, float z) {
		modelRenderer.pivotX = x;
		modelRenderer.pivotY = y;
		modelRenderer.pivotZ = z;
	}
}