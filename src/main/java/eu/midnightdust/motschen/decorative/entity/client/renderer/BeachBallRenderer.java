package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BeachBallModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BeachBallRenderer extends MobEntityRenderer<BeachBallEntity, BeachBallModel> {

    public BeachBallRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new BeachBallModel(), 0.5F);
    }

    @Override
    public Identifier getTexture(BeachBallEntity entity) {
        return new Identifier(DecorativeMain.MOD_ID, "textures/entity/beach_ball.png");
    }
}
