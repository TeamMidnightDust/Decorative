package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.ChristmasLights;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import org.joml.Vector3f;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplayChristmasLightsModel extends BlockModel {
    private final ItemDisplayElement main;
    public static ItemStack OFF;
    public static ItemStack ON;

    public static void initModels() {
        OFF = BaseItemProvider.requestModel(id("block/christmas_lights_off"));
        ON = BaseItemProvider.requestModel(id("block/christmas_lights_off"));
    }

    public ItemDisplayChristmasLightsModel(BlockState state, BlockPos pos, ServerWorld world) {
        this.main = ItemDisplayElementUtil.createSimple(state.get(ChristmasLights.LIT) ? ON : OFF);
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(state.get(ChristmasLights.FACING).asRotation()));
        this.main.setViewRange(0.75f * (DecorativeConfig.viewDistance / 100f));
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(state.get(ChristmasLights.LIT) ? ON : OFF);
            this.main.setRightRotation(RotationAxis.POSITIVE_Y.rotationDegrees(state.get(ChristmasLights.FACING).asRotation()));

            this.tick();
        }
    }
}

