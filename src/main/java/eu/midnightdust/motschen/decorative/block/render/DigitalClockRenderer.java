package eu.midnightdust.motschen.decorative.block.render;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.blockentity.DigitalClockBlockEntity;
import eu.midnightdust.motschen.decorative.config.DecorativeConfig;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.render.*;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import java.time.LocalTime;

@Environment(EnvType.CLIENT)
public class DigitalClockRenderer extends BlockEntityRenderer<DigitalClockBlockEntity> {

    public DigitalClockRenderer(BlockEntityRenderDispatcher blockEntityRenderDispatcher) {
        super(blockEntityRenderDispatcher);
    }

    private int getHour12hFormat() {
        int hour;
        hour = LocalTime.now().getHour();
        if (hour > 12) {
            hour = hour - 12;
        }
        return hour;
    }
    private String getTime() {
        String hour;
        String minute;

        // Hour
        if (DecorativeMain.DECORATIVE_CONFIG.timeFormat.equals(DecorativeConfig.TimeFormat.h12)) {
            if (getHour12hFormat() <= 9) {
                hour = "0" + getHour12hFormat();
            } else {
                hour = "" + getHour12hFormat();
            }
        }
        else {
            if (LocalTime.now().getHour() <= 9) {
                hour = "0" + LocalTime.now().getHour();
            } else {
                hour = "" + LocalTime.now().getHour();
            }
        }

        // Minute
        if (LocalTime.now().getMinute() <= 9) {
            minute = "0" + LocalTime.now().getMinute();
        }
        else {
            minute = "" + LocalTime.now().getMinute();
        }

        String time = hour +":"+ minute;
        return time;
    }


    @Override
    public void render(DigitalClockBlockEntity blockEntity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        matrices.push();
        TextRenderer textRenderer = dispatcher.getTextRenderer();
        matrices.translate(blockEntity.getX(),0.35,blockEntity.getZ());

        matrices.scale(0.025f, 0.025f, 0.025f);
        matrices.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(blockEntity.getFacing()));
        matrices.translate(0,0,-0.1);
        matrices.multiply(Vector3f.POSITIVE_Z.getDegreesQuaternion(180));
        textRenderer.draw(getTime(), 0, 0, 16382457, false, matrices.peek().getModel(), vertexConsumers, false, 0, 15);
        matrices.pop();
    }
}