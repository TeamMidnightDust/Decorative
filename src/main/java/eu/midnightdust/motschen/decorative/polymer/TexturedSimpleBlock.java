package eu.midnightdust.motschen.decorative.polymer;

import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;

public class TexturedSimpleBlock extends Block implements PolymerTexturedBlock {
    public TexturedSimpleBlock(Block base) {
        this(AbstractBlock.Settings.copy(base));
    }
    public TexturedSimpleBlock(Settings settings) {
        super(settings);
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return Blocks.BARRIER.getDefaultState();
    }
}
