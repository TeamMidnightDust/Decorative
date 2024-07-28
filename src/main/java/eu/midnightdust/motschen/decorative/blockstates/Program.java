package eu.midnightdust.motschen.decorative.blockstates;

import net.minecraft.util.StringIdentifiable;

public enum Program implements StringIdentifiable {
    OFF("off"),
    NYANCAT("nyancat"),
    CREEPER("creeper"),
    CRABRAVE("crabrave"),
    TATER("tater");

    private final String name;
    private static final Program[] vals = values();

    Program(String name) {
        this.name = name;
    }

    public Program next() {
        return vals[(this.ordinal() + 1) % vals.length];
    }

    public String toString() {
        return this.name;
    }

    public String asString() {
        return this.name;
    }
}
