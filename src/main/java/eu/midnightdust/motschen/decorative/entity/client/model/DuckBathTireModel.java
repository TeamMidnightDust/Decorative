package eu.midnightdust.motschen.decorative.entity.client.model;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class DuckBathTireModel extends EntityModel<BathTireEntity> {
	private final ModelPart body;

	public DuckBathTireModel() {
		textureWidth = 64;
		textureHeight = 64;

		body = new ModelPart(this);
		body.setPivot(0.0F, 19.0F, 0.0F);
		body.setTextureOffset(0, 9).addCuboid(6.0F, -3.0F, -8.0F, 4.0F, 3.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 37).addCuboid(-10.0F, -3.0F, -8.0F, 4.0F, 3.0F, 16.0F, 0.0F, false);
		body.setTextureOffset(0, 57).addCuboid(-8.0F, -2.99F, -10.0F, 16.0F, 3.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(0, 29).addCuboid(-8.0F, -2.99F, 6.0F, 16.0F, 3.0F, 4.0F, 0.0F, false);
		body.setTextureOffset(50, 0).addCuboid(-2.0F, -8.0F, -10.0F, 4.0F, 5.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(46, 11).addCuboid(-2.999F, -10.0F, -12.0F, 6.0F, 5.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(15, 31).addCuboid(-2.499F, -10.5F, -12.001F, 5.0F, 1.0F, 3.0F, 0.0F, false);
		body.setTextureOffset(58, 20).addCuboid(-0.999F, -8.0F, -13.0F, 2.0F, 2.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(58, 20).addCuboid(-1.999F, -7.0F, -13.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(53, 21).addCuboid(-1.999F, -10.0F, -12.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(53, 21).addCuboid(1.001F, -10.0F, -12.5F, 1.0F, 1.0F, 1.0F, 0.0F, false);
		body.setTextureOffset(58, 20).addCuboid(1.001F, -7.0F, -13.0F, 1.0F, 1.0F, 1.0F, 0.0F, false);
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