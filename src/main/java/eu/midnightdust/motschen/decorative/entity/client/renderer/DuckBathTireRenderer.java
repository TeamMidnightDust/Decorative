package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.DuckBathTireModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

@Environment(EnvType.CLIENT)
public class DuckBathTireRenderer extends MobEntityRenderer<BathTireEntity, DuckBathTireModel> {
    public DuckBathTireRenderer(EntityRendererFactory.Context context) {
        super(context, new DuckBathTireModel(context.getPart(DuckBathTireModel.DUCK_BATH_TIRE_MODEL_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BathTireEntity entity) {
        return id("textures/entity/duck_bath_tire.png");
    }
}
