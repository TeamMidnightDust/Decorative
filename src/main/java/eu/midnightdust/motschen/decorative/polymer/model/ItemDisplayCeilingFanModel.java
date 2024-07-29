package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.DecorativeMain;
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

public class ItemDisplayCeilingFanModel extends BlockModel {
    private final ItemDisplayElement main;
    private final ItemDisplayElement blades;
    public static ItemStack MAIN;
    public static ItemStack BLADES;
    private int speed;
    private int rot;

    public static void initModels() {
        MAIN = BaseItemProvider.requestModel(id("block/ceilingfan"));
        BLADES = BaseItemProvider.requestModel(id("block/polymer/ceilingfan_blades"));
    }

    public ItemDisplayCeilingFanModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(MAIN);
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setViewRange(0.75f * (DecorativeConfig.viewDistance / 100f));
        this.addElement(this.main);

        this.blades = ItemDisplayElementUtil.createSimple(BLADES);
        this.blades.setDisplaySize(1, 1);
        this.blades.setScale(new Vector3f(2));
        this.blades.setViewRange(0.75f * (DecorativeConfig.viewDistance / 100f));
        this.addElement(this.blades);
        this.speed = state.get(DecorativeMain.STAGE).getSpeed();
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.speed = state.get(DecorativeMain.STAGE).getSpeed();

            this.tick();
        }
    }
    @Override
    public void onTick() {
        if (this.speed > 0) this.rot = this.rot + 2 + (4*this.speed);
        this.blades.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(this.rot));
    }
}

