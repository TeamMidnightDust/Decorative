package eu.midnightdust.motschen.decorative.polymer;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;

public class TexturedSimpleBlock extends Block implements PolymerTexturedBlock {
    private final BlockState MODEL;

    public TexturedSimpleBlock(Block base, Identifier id) {
        this(AbstractBlock.Settings.copy(base), id);
    }
    public TexturedSimpleBlock(Settings settings, Identifier id) {
        super(settings);
        MODEL = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(id("block/"+id.getPath())));
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return MODEL;
    }
}
