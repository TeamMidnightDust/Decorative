package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.DigitalClock;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.midnightdust.motschen.decorative.util.ColorUtil;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import eu.pb4.polymer.virtualentity.api.elements.TextDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Pair;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.TimeUtil.getTime;

public class ItemDisplayDigitalClockModel extends BlockModel {
    private final ItemDisplayElement main;
    private final TextDisplayElement text;
    private static final Map<String, ItemStack> models = new HashMap<>();

    public static void initModels() {
        for (int i = 0; i < ColorUtil.VanillaColor.length(); i++) {
            String color = ColorUtil.VanillaColor.byNumber(i).getName();
            models.put(color, BaseItemProvider.requestModel(id("block/"+color+"_digital_clock")));
        }
    }

    public ItemDisplayDigitalClockModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
        this.main.setViewRange(0.75f * (DecorativeConfig.viewDistance / 100f));
        this.addElement(this.main);
        this.text = new TextDisplayElement(Text.of(getTime()));
        this.text.setDisplaySize(1, 1);
        this.text.setScale(new Vector3f(1));
        var offset = getOffset(state);
        this.text.setOffset(new Vec3d(offset.getLeft(), -0.4d, offset.getRight()));
        this.text.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
        this.text.setBackground(0x0000000);
        this.text.setShadow(true);
        this.addElement(this.text);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
            var offset = getOffset(state);
            this.text.setOffset(new Vec3d(offset.getLeft(), -0.4d, offset.getRight()));
            this.text.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));

            this.tick();
        }
    }
    @Override
    public void onTick() {
        this.text.setText(Text.of(getTime()));
    }
    public ItemStack getModel(BlockState state) {
        return models.get(ColorUtil.VanillaColor.fromBlockName(state.getBlock().getTranslationKey()).getName());
    }
    public float getRotation(BlockState state) {
        return state.get(DigitalClock.FACING).getHorizontal() * -90;
    }
    public Pair<Float, Float> getOffset(BlockState state) {
       return switch (state.get(HorizontalFacingBlock.FACING)) {
           case NORTH -> new Pair<>(0.025f, -0.12599999f);
           case EAST -> new Pair<>(0.12599999f, 0.025f);
           case SOUTH -> new Pair<>(-0.025f, 0.12599999f);
           default -> new Pair<>(-0.12599999f, -0.025f);
        };
    }
}

