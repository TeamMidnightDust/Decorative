package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

public class ItemDisplayChoppingLogModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack AXE = new ItemStack(Items.IRON_AXE);
    double axe_x;
    double axe_z;
    int rotation;

    public ItemDisplayChoppingLogModel(BlockState state, BlockPos pos) {
        this.main = ItemDisplayElementUtil.createSimple(AXE);
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(1.25f));

        setupTranslation(state);
        this.main.setOffset(new Vec3d(this.axe_x, 0.9D, this.axe_z));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(this.rotation).rotateZ(2.792527f));
        this.main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            setupTranslation(state);
            this.main.setOffset(new Vec3d(this.axe_x, 0.9D, this.axe_z));
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(this.rotation).rotateZ(2.792527f));

            this.tick();
        }
    }
    public void setupTranslation(BlockState state) {
        switch (state.get(ChoppingLog.FACING)) {
            case EAST -> {
                rotation = 180; axe_x = -0.3D; axe_z = 0.0D;
            }
            case SOUTH -> {
                rotation = 90; axe_x = 0.0D; axe_z = -0.3D;
            }
            case WEST -> {
                rotation = 0; axe_x = 0.3D; axe_z = 0.0D;
            }
            default -> {
                rotation = 270; axe_x = 0.0D; axe_z = 0.3D;
            }
        }
    }
}
