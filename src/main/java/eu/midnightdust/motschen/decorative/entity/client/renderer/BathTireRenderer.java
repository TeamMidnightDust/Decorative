package eu.midnightdust.motschen.decorative.entity.client.renderer;

import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.entity.client.model.BathTireModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BathTireRenderer extends MobEntityRenderer<BathTireEntity, BathTireModel> {
    private final Identifier TEXTURE;
    public BathTireRenderer(EntityRendererFactory.Context context, DyeColor color) {
        super(context, new BathTireModel(context.getPart(BathTireModel.BATH_TIRE_MODEL_LAYER)), 0.5F);
        TEXTURE = Identifier.tryParse("textures/block/"+color.getName()+"_concrete.png");
    }

    @Override
    public Identifier getTexture(BathTireEntity entity) {
        return TEXTURE;
    }
}
