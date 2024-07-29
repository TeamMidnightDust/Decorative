package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.PoolWall;
import eu.midnightdust.motschen.decorative.blockstates.PoolShape;
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

public class ItemDisplayPoolWallModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack REGULAR;
    public static ItemStack CORNER;

    public static void initModels() {
        REGULAR = BaseItemProvider.requestModel(id("block/pool_wall"));
        CORNER = BaseItemProvider.requestModel(id("block/pool_wall_corner"));
    }

    public ItemDisplayPoolWallModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
        this.main.setViewRange((DecorativeConfig.viewDistance / 100f));
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(getRotation(state)));
            this.main.setItem(getModel(state));

            this.tick();
        }
    }
    public ItemStack getModel(BlockState state) {
        return state.get(PoolWall.SHAPE) == PoolShape.STRAIGHT ? REGULAR : CORNER;
    }
    public float getRotation(BlockState state) {
        return state.get(PoolWall.FACING).getHorizontal() * -90 + (state.get(PoolWall.SHAPE) == PoolShape.INNER_RIGHT ? 0 : 90);
    }
}

