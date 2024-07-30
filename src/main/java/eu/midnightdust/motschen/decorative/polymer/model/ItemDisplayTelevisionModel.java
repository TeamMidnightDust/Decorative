package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.OldTelevision;
import eu.midnightdust.motschen.decorative.block.Television;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplayTelevisionModel extends BlockModel {
    private final ItemDisplayElement main;
    private static ItemStack MODERN;
    private static ItemStack OLD_OFF;
    private static ItemStack OLD_ON;

    public static void initModels() {
        MODERN = BaseItemProvider.requestModel(id("block/television"));
        OLD_OFF = BaseItemProvider.requestModel(id("block/old_television_off"));
        OLD_ON = BaseItemProvider.requestModel(id("block/old_television_on"));
    }

    public ItemDisplayTelevisionModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
        this.main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(getModel(state));
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));

            this.tick();
        }
    }
    public ItemStack getModel(BlockState state) {
        return state.getBlock() instanceof OldTelevision ?
                (state.get(OldTelevision.POWERED) ? OLD_ON : OLD_OFF) :
                MODERN;
    }
    public float getRotation(BlockState state) {
        return state.getBlock() instanceof OldTelevision ?
                state.get(OldTelevision.FACING).getHorizontal() * -90 - 180 :
                state.get(Television.FACING).getHorizontal() * -90 - 180;
    }

}

