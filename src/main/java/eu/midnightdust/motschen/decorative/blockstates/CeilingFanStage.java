package eu.midnightdust.motschen.decorative.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum CeilingFanStage implements StringIdentifiable {
    OFF("off"),
    LEVEL_1("level1"),
    LEVEL_2("level2"),
    LEVEL_3("level3");

    private final String name;

    CeilingFanStage(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
