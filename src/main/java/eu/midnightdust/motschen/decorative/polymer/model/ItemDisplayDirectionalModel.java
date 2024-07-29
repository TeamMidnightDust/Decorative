package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.FireHydrant;
import eu.midnightdust.motschen.decorative.block.Guardrail;
import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.block.ShowerHead;
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

public class ItemDisplayDirectionalModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack FIRE_HYDRANT;
    public static ItemStack GUARDRAIL;
    public static ItemStack POOL_SPRINKLER;
    public static ItemStack SHOWER_HEAD;

    public static void initModels() {
        FIRE_HYDRANT = BaseItemProvider.requestModel(id("block/fire_hydrant"));
        GUARDRAIL = BaseItemProvider.requestModel(id("block/guardrail"));
        POOL_SPRINKLER = BaseItemProvider.requestModel(id("block/pool_sprinkler"));
        SHOWER_HEAD = BaseItemProvider.requestModel(id("block/shower_head"));
    }

    public ItemDisplayDirectionalModel(BlockState state) {
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

            this.tick();
        }
    }
    public ItemStack getModel(BlockState state) {
        if (state.getBlock() instanceof FireHydrant) return FIRE_HYDRANT;
        else if (state.getBlock() instanceof PoolSprinkler) return POOL_SPRINKLER;
        else if (state.getBlock() instanceof ShowerHead) return SHOWER_HEAD;
        else return GUARDRAIL;
    }
    public float getRotation(BlockState state) {
        if (state.getBlock() instanceof FireHydrant) return state.get(FireHydrant.FACING).getHorizontal() * -90;
        else if (state.getBlock() instanceof PoolSprinkler) return state.get(PoolSprinkler.FACING).getHorizontal() * -90;
        else if (state.getBlock() instanceof ShowerHead) return state.get(ShowerHead.FACING).getHorizontal() * -90 + 90;
        else return state.get(Guardrail.FACING).getHorizontal() * -90;
    }
}

