package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.Springboard;
import eu.midnightdust.motschen.decorative.blockstates.Part;
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
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplaySpringboardModel extends BlockModel {
    private final ItemDisplayElement main;
    private static ItemStack BACK;
    private static ItemStack FRONT;

    public static void initModels() {
        BACK = BaseItemProvider.requestModel(id("block/springboard_back"));
        FRONT = BaseItemProvider.requestModel(id("block/springboard_front"));
    }

    public ItemDisplaySpringboardModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(1));
        //this.main.setOffset(new Vec3d(0d, 0.25d, 0d));
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
        return  state.get(Springboard.PART) == Part.BACK ? BACK : FRONT;
    }
    public float getRotation(BlockState state) {
        return state.get(Springboard.FACING).getHorizontal() * -90 - 90;
    }

}

