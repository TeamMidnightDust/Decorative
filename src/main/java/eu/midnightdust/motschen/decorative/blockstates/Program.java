package eu.midnightdust.motschen.decorative.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum Program implements StringIdentifiable {
    OFF("off"),
    NYANCAT("nyancat"),
    CREEPER("creeper"),
    WOODYS("woodys"),
    TATER("tater");

    private final String name;

    Program(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
