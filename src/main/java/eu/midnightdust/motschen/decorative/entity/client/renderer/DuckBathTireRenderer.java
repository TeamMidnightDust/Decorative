package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BeachBallModel;
import eu.midnightdust.motschen.decorative.entity.client.model.DuckBathTireModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DuckBathTireRenderer extends MobEntityRenderer<BathTireEntity, DuckBathTireModel> {

    public DuckBathTireRenderer(EntityRenderDispatcher dispatcher) { super(dispatcher, new DuckBathTireModel(), 0.5F); }

    @Override
    public Identifier getTexture(BathTireEntity entity) {
        return new Identifier(DecorativeMain.MOD_ID, "textures/entity/duck_bath_tire.png");
    }
}
