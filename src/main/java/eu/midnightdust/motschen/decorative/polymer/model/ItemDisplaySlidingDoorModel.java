package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.SlidingDoor;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.block.enums.DoorHinge;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplaySlidingDoorModel extends BlockModel {
    private final ItemDisplayElement main;
    private static ItemStack DOOR_BOTTOM;
    private static ItemStack DOOR_TOP;

    public static void initModels() {
        DOOR_BOTTOM = BaseItemProvider.requestModel(id("block/sliding_door_bottom"));
        DOOR_TOP = BaseItemProvider.requestModel(id("block/sliding_door_top"));
    }

    public ItemDisplaySlidingDoorModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(1.99f));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
        this.main.setViewRange(DecorativeConfig.viewDistance / 100f);
        handleSliding(state);
        this.main.setTeleportDuration(10);
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(getModel(state));
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
            handleSliding(state);

            this.tick();
        }
    }
    public void handleSliding(BlockState state) {
        if (state.get(SlidingDoor.OPEN)) {
            var slidingDirection = state.get(SlidingDoor.HINGE) == DoorHinge.RIGHT ?
                    state.get(SlidingDoor.FACING).rotateYClockwise() :
                    state.get(SlidingDoor.FACING).rotateYCounterclockwise();
            this.main.setOffset(Vec3d.of(slidingDirection.getVector()).multiply(0.9d));
        }
        else this.main.setOffset(Vec3d.ZERO);
    }
    public ItemStack getModel(BlockState state) {
        return (state.get(SlidingDoor.HALF) == DoubleBlockHalf.LOWER) ? DOOR_BOTTOM : DOOR_TOP;
    }
    public float getRotation(BlockState state) {
        return state.get(SlidingDoor.FACING).getHorizontal() * -90 + (state.get(SlidingDoor.HINGE) == DoorHinge.RIGHT ? 90 : -90);
    }

}

