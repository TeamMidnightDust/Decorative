package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.DoubleLamp;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.midnightdust.motschen.decorative.util.ColorUtil;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import org.joml.Vector3f;

import java.util.HashMap;
import java.util.Map;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplayLampModel extends BlockModel {
    private final ItemDisplayElement main;
    private static final Map<String, ItemStack> MODELS_OFF = new HashMap<>();
    private static final Map<String, ItemStack> MODELS_ON = new HashMap<>();

    public static void initModels() {
        for (int i = 0; i < ColorUtil.VanillaColor.length(); i++) {
            String color = ColorUtil.VanillaColor.byNumber(i).getName();
            MODELS_OFF.put(color, BaseItemProvider.requestModel(id("block/"+color+"_lamp_off")));
            MODELS_ON.put(color, BaseItemProvider.requestModel(id("block/"+color+"_lamp_on")));
        }
    }

    public ItemDisplayLampModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(getModel(state));
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setViewRange(DecorativeConfig.viewDistance / 100f);
        this.addElement(this.main);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.main.setItem(getModel(state));

            this.tick();
        }
    }
    public ItemStack getModel(BlockState state) {
        String color = ColorUtil.VanillaColor.fromBlockName(state.getBlock().getTranslationKey()).getName();
        return state.get(DoubleLamp.LIT) ? MODELS_ON.get(color) : MODELS_OFF.get(color);
    }
}

