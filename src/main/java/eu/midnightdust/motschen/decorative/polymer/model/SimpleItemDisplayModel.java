package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.SignPost;
import eu.midnightdust.motschen.decorative.block.TrafficCone;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class SimpleItemDisplayModel extends BlockModel {
    public static ItemStack SIGN_POST;
    public static ItemStack TRAFFIC_CONE;

    public static void initModels() {
        SIGN_POST = BaseItemProvider.requestModel(id("block/sign_post"));
        TRAFFIC_CONE = BaseItemProvider.requestModel(id("block/traffic_cone"));
    }

    public SimpleItemDisplayModel(BlockState state) {
        ItemDisplayElement main = ItemDisplayElementUtil.createSimple(getModel(state));
        main.setDisplaySize(1, 1);
        main.setScale(new Vector3f(2));
        main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(main);
    }

    public ItemStack getModel(BlockState state) {
        if (state.getBlock() instanceof SignPost) return SIGN_POST;
        else if (state.getBlock() instanceof TrafficCone) return TRAFFIC_CONE;
        else return null;
    }
}

