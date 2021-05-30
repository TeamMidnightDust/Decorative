package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BeachBallModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.*;
import net.minecraft.client.render.entity.feature.ArmorFeatureRenderer;
import net.minecraft.client.render.entity.feature.SlimeOverlayFeatureRenderer;
import net.minecraft.client.render.entity.model.*;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BeachBallRenderer extends MobEntityRenderer<BeachBallEntity, BeachBallModel> {

    public BeachBallRenderer(EntityRendererFactory.Context context) {
        super(context, new BeachBallModel(context.getPart(BeachBallModel.BEACH_BALL_MODEL_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BeachBallEntity entity) {
        return new Identifier(DecorativeMain.MOD_ID, "textures/entity/beach_ball.png");
    }
}
