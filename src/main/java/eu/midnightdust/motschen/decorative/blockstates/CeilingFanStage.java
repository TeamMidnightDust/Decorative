package eu.midnightdust.motschen.decorative.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum CeilingFanStage implements StringIdentifiable {
    OFF("off", 0),
    LEVEL_1("level1", 1),
    LEVEL_2("level2", 2),
    LEVEL_3("level3", 3);

    private final String name;
    private final int speed;
    private static final CeilingFanStage[] vals = values();

    CeilingFanStage(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }
    public int getSpeed() {
        return speed;
    }

    public CeilingFanStage next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
