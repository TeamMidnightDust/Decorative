package eu.midnightdust.motschen.decorative.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum PoolShape implements StringIdentifiable {
    STRAIGHT("straight"),
    INNER_LEFT("inner_left"),
    INNER_RIGHT("inner_right");

    private final String name;

    PoolShape(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
