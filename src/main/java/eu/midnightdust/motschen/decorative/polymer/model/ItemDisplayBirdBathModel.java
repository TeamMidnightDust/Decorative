package eu.midnightdust.motschen.decorative.polymer.model;

import eu.midnightdust.motschen.decorative.block.BirdBath;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import eu.midnightdust.motschen.decorative.util.ColorUtil;
import eu.pb4.factorytools.api.resourcepack.BaseItemProvider;
import eu.pb4.factorytools.api.virtualentity.BlockModel;
import eu.pb4.factorytools.api.virtualentity.ItemDisplayElementUtil;
import eu.pb4.polymer.virtualentity.api.attachment.BlockAwareAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.ChunkAttachment;
import eu.pb4.polymer.virtualentity.api.attachment.HolderAttachment;
import eu.pb4.polymer.virtualentity.api.elements.ItemDisplayElement;
import net.minecraft.block.BlockState;
import net.minecraft.component.ComponentMap;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.Optional;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class ItemDisplayBirdBathModel extends BlockModel {
    private final ItemDisplayElement main;
    private final ItemDisplayElement water;
    private int waterColor = ColorUtil.convertRgbToArgb(4159204);
    public static ItemStack STONE;
    public static ItemStack WATER;

    public static void initModels() {
        STONE = BaseItemProvider.requestModel(id("block/bird_bath"));
        WATER = BaseItemProvider.requestModel(Items.POTION, id("block/polymer/bird_bath_water"));
    }

    public ItemDisplayBirdBathModel(BlockState state) {
        this.main = ItemDisplayElementUtil.createSimple(STONE);
        this.main.setDisplaySize(1, 1);
        this.main.setScale(new Vector3f(2));
        this.main.setViewRange(0.75f * (DecorativeConfig.viewDistance / 100f));
        this.addElement(this.main);

        this.water = ItemDisplayElementUtil.createSimple();
        this.water.setDisplaySize(1, 1);
        this.water.setScale(new Vector3f(state.get(BirdBath.LEVEL) >= 2 ? 1.9f : 1.65f));
        this.water.setOffset(new Vec3d(0d, -0.025 * (3-(state.get(BirdBath.LEVEL))), 0d));
        this.water.setViewRange(state.get(BirdBath.LEVEL) != 0 ? (0.75f * (DecorativeConfig.viewDistance / 100f)) : 0);
        this.addElement(this.water);
    }

    @Override
    public void notifyUpdate(HolderAttachment.UpdateType updateType) {
        if (updateType == BlockAwareAttachment.BLOCK_STATE_UPDATE) {
            var state = this.blockState();
            this.water.setViewRange(state.get(BirdBath.LEVEL) != 0 ? (0.75f * (DecorativeConfig.viewDistance / 100f)) : 0);
            this.water.setScale(new Vector3f(state.get(BirdBath.LEVEL) >= 2 ? 1.9f : 1.65f));
            this.water.setOffset(new Vec3d(0d, -0.025 * (3-(state.get(BirdBath.LEVEL))), 0d));

            this.tick();
        }
    }
    @Override
    protected void onAttachmentSet(HolderAttachment attachment, @Nullable HolderAttachment oldAttachment) {
        if (attachment instanceof ChunkAttachment chunkAttachment) {
            this.waterColor = ColorUtil.convertRgbToArgb(ColorUtil.getWaterColor(chunkAttachment.getChunk(), blockPos()));
            this.water.setItem(getColoredWater());
        }
    }
    private ItemStack getColoredWater() {
        var colWater = WATER.copy();
        colWater.applyComponentsFrom(ComponentMap.builder().add(DataComponentTypes.POTION_CONTENTS,
                new PotionContentsComponent(Optional.of(Potions.WATER), Optional.of(this.waterColor), List.of())).build());
        return colWater;
    }
}

