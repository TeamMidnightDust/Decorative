package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BeachBallModel extends EntityModel<BeachBallEntity> {
	private final ModelPart body;

	public BeachBallModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this);
		body.setPivot(0.0F, 24.0F, 0.0F);
		body.setTextureOffset(0, 22).addCuboid(-4.0F, -1.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 22).addCuboid(-4.0F, -12.0F, -4.0F, 8.0F, 1.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 48).addCuboid(-6.0F, -10.0F, -4.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(20, 48).addCuboid(5.0F, -10.0F, -4.0F, 1.0F, 8.0F, 8.0F, 0.0F, false);
		body.setTextureOffset(0, 33).addCuboid(-4.0F, -10.0F, -6.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(20, 33).addCuboid(-4.0F, -10.0F, 5.0F, 8.0F, 8.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(0, 0).addCuboid(-5.0F, -11.0F, -5.0F, 10.0F, 10.0F, 10.0F, 0.0F, false);
	}

	@Override
	public void setAngles(BeachBallEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch){
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