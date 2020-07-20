package eu.midnightdust.motschen.decorative;

import net.minecraft.util.StringIdentifiable;

public enum Part implements StringIdentifiable {
    FRONT("front"),
    BACK("back");

    private final String name;

    Part(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
