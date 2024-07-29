package eu.midnightdust.motschen.decorative.util;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;

public class ColorUtil {
    public static int convertRgbToArgb(int rgb) {
        int red = 0xFF & (rgb >> 16);
        int green = 0xFF & (rgb >> 8);
        int blue = 0xFF & (rgb);
        int alpha = 200; // Makes water bottles transparent, 255 would be opaque

        return (alpha << 24) | (red << 16) | (green << 8) | blue;
    }
    public static int getWaterColor(ServerWorld world, BlockPos pos) {
        var biome = world.getBiome(pos);
        return biome == null ? 4159204 : biome.value().getWaterColor();
    }

    public enum VanillaColor {
        WHITE("white"), ORANGE("orange"), MAGENTA("magenta"), LIGHT_BLUE("light_blue"), YELLOW("yellow"), LIME("lime"),
        PINK("pink"), GRAY("gray"), LIGHT_GRAY("light_gray"), CYAN("cyan"), PURPLE("purple"), BLUE("blue"),
        BROWN("brown"), GREEN("green"), RED("red"), BLACK("black");
        private final String name;
        private static final VanillaColor[] vals = values();

        VanillaColor(String name) {
            this.name = name;
        }
        public VanillaColor next() {
            return vals[(this.ordinal() + 1) % vals.length];
        }

        public String getName() {
            return name;
        }
        public static VanillaColor byNumber(int id) {
            return vals[id];
        }
        public static int length() {
            return vals.length;
        }
        public static VanillaColor fromBlockName(String name) {
            return Arrays.stream(vals).filter(color -> name
                    .replace("block.decorative.", "")
                    .replace("_digital_clock", "")
                    .replace("_double_lamp", "")
                    .replace("_lamp", "")
                    .equals(color.getName())).findFirst().orElse(VanillaColor.BLACK);
        }
    }
}