package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplayChristmasTreeModel extends BlockModel {
    public static ItemStack TREE;

    public static void initModels() {
        TREE = BaseItemProvider.requestModel(id("block/christmas_tree"));
    }

    public ItemDisplayChristmasTreeModel() {
        ItemDisplayElement main = ItemDisplayElementUtil.createSimple(TREE);
        main.setDisplaySize(1, 1);
        main.setScale(new Vector3f(2));
        main.setOffset(new Vec3d(0, 0.4d, 0));
        main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(main);
    }
}

