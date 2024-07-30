package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.DigitalClock;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Pair;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import java.time.LocalTime;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.TimeUtil.getHour12hFormat;

public class ItemDisplayWallClockModel extends BlockModel {
    private final ItemDisplayElement main;
    private final ItemDisplayElement hours;
    private final ItemDisplayElement minutes;
    private final ItemDisplayElement seconds;
    private static ItemStack CASE;
    private static ItemStack HAND;
    private static ItemStack HAND_RED;
    private float yRotation;
    private Pair<Float, Float> offset;

    public static void initModels() {
        CASE = BaseItemProvider.requestModel(id("block/wall_clock"));
        HAND = BaseItemProvider.requestModel(id("block/polymer/wall_clock_hand"));
        HAND_RED = BaseItemProvider.requestModel(id("block/polymer/wall_clock_hand_red"));
    }

    public ItemDisplayWallClockModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(1));
        this.yRotation = getRotation(state);
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation));
        this.main.setViewRange((DecorativeConfig.viewDistance / 100f));
        offset = getOffset(state);
        this.main.setOffset(new Vec3d(offset.getLeft(), 0.0d, offset.getRight()));
        this.addElement(this.main);

        this.hours = ItemDisplayElementUtil.createSimple(HAND);
        this.hours.setDisplaySize(1, 1);
        this.hours.setScale(new Vector3f(0.083333336f, 1.0f, 0.05f));
        this.hours.setOffset(new Vec3d(offset.getLeft(), 0.0d, offset.getRight()));
        this.hours.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(getHour12hFormat() * 30d)));
        this.hours.setViewRange((DecorativeConfig.viewDistance / 100f));
        this.addElement(hours);

        this.minutes = ItemDisplayElementUtil.createSimple(HAND);
        this.minutes.setDisplaySize(1, 1);
        this.minutes.setScale(new Vector3f(0.083333336f, 1.3333f, 0.05f));
        this.minutes.setOffset(new Vec3d(offset.getLeft(), 0.0d, offset.getRight()));
        this.minutes.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(LocalTime.now().getMinute() * 6d)));
        this.minutes.setViewRange((DecorativeConfig.viewDistance / 100f));
        this.addElement(minutes);

        this.seconds = ItemDisplayElementUtil.createSimple(HAND_RED);
        this.seconds.setDisplaySize(1, 1);
        this.seconds.setScale(new Vector3f(0.041666668f, 1.5f, 0.05f));
        this.seconds.setOffset(new Vec3d(offset.getLeft(), 0, offset.getRight()));
        this.seconds.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(LocalTime.now().getSecond() * 6d)));
        this.seconds.setViewRange((DecorativeConfig.viewDistance / 100f));
        this.addElement(seconds);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.yRotation = getRotation(state);
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation));
            offset = getOffset(state);
            this.getElements().forEach(e -> e.setOffset(new Vec3d(offset.getLeft(), 0.0d, offset.getRight())));

            this.tick();
        }
    }
    @Override
    public void onTick() {
        this.hours.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(getHour12hFormat() * 30d)));
        this.minutes.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(LocalTime.now().getMinute() * 6d)));
        this.seconds.setLeftRotation(RotationAxis.POSITIVE_Y.rotationDegrees(yRotation).rotateZ(-(float) Math.toRadians(LocalTime.now().getSecond() * 6d)));
    }
    public ItemStack getModel(BlockState state) {
        return CASE;
    }
    public float getRotation(BlockState state) {
        return state.get(DigitalClock.FACING).getHorizontal() * -90;
    }
    public Pair<Float, Float> getOffset(BlockState state) {
       return switch (state.get(HorizontalFacingBlock.FACING)) {
           case NORTH -> new Pair<>(0.0f, 0.45f);
           case EAST -> new Pair<>(-0.45f, 0.0f);
           case SOUTH -> new Pair<>(0.0f, -0.45f);
           default -> new Pair<>(0.45f, 0.0f);
        };
    }
}

