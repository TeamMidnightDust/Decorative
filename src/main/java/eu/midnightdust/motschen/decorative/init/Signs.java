package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.Sign;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerTraffic;

public class Signs {
    public static Block EmptySign = new Sign();
    public static final List<Block> SIGNS = new ArrayList<>();

    public static void init() {
        registerTraffic(id("empty_sign"), EmptySign);

        Arrays.stream(Sign.Type.values()).toList().forEach(type -> {
            if (type != Sign.Type.EMPTY) register(id(type.getName()), new Sign());
        });
    }
    public static void register(Identifier id, Block block) {
        registerTraffic(id, block);
        SIGNS.add(block);
    }
}
