package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BathTireModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class OrangeBathTireRenderer extends MobEntityRenderer<BathTireEntity, BathTireModel> {

    public OrangeBathTireRenderer(EntityRenderDispatcher dispatcher) {
        super(dispatcher, new BathTireModel(), 0.5F);
    }

    @Override
    public Identifier getTexture(BathTireEntity entity) {
        return new Identifier("minecraft", "textures/block/orange_concrete.png");
    }
}
