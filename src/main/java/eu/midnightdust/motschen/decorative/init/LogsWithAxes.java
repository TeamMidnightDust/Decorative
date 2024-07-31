package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import net.minecraft.block.WoodType;
import net.minecraft.registry.Registries;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerGarden;

public class LogsWithAxes {
    public static final List<ChoppingLog> TYPES = new ArrayList<>();

    public static void init() {
        WoodType.stream().forEach(woodType -> {
            String logName = woodType.name() + "_";
            if (woodType.soundType() == BlockSoundGroup.NETHER_WOOD) logName += "stem";
            else if (woodType.soundType() == BlockSoundGroup.BAMBOO_WOOD) logName += "block";
            else logName += "log";

            if (Registries.BLOCK.containsId(Identifier.of(logName))) {
                var choppingLog = new ChoppingLog(Registries.BLOCK.get(Identifier.of(logName)));
                register(id(logName + "_with_axe"), choppingLog);
            }
        });
    }
    public static void register(Identifier id, ChoppingLog block) {
        registerGarden(id, block);
        TYPES.add(block);
    }
}
