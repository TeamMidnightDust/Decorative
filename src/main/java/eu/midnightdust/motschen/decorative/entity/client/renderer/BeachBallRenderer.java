package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BeachBallModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

@Environment(EnvType.CLIENT)
public class BeachBallRenderer extends MobEntityRenderer<BeachBallEntity, BeachBallModel> {

    public BeachBallRenderer(EntityRendererFactory.Context context) {
        super(context, new BeachBallModel(context.getPart(BeachBallModel.BEACH_BALL_MODEL_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BeachBallEntity entity) {
        return id("textures/entity/beach_ball.png");
    }
}
