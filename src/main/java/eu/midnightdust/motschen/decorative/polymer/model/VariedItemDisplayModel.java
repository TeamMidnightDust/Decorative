package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.StonePath;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class VariedItemDisplayModel extends BlockModel {
    public static ItemStack STONE_PATH;

    public static void initModels() {
        STONE_PATH = BaseItemProvider.requestModel(id("block/stone_path"));
    }

    public VariedItemDisplayModel(BlockState state, BlockPos pos) {
        ItemDisplayElement main = ItemDisplayElementUtil.createSimple(getModel(state));
        main.setDisplaySize(1, 1);
        main.setScale(new Vector3f(2));
        main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(90 * (pos.hashCode() % 4)));
        main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(main);
    }

    public ItemStack getModel(BlockState state) {
        if (state.getBlock() instanceof StonePath) return STONE_PATH;
        else return null;
    }
}

