package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.ChoppingLog;
import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.item.BathTireItem;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;

import static eu.midnightdust.motschen.decorative.DecorativeMain.PoolGroup;
import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerItem;

public class BathTires {
    public static EntityType<BathTireEntity> WHITE_BATH_TIRE;
    public static EntityType<BathTireEntity> ORANGE_BATH_TIRE;
    public static EntityType<BathTireEntity> MAGENTA_BATH_TIRE;
    public static EntityType<BathTireEntity> LIGHT_BLUE_BATH_TIRE;
    public static EntityType<BathTireEntity> YELLOW_BATH_TIRE;
    public static EntityType<BathTireEntity> LIME_BATH_TIRE;
    public static EntityType<BathTireEntity> PINK_BATH_TIRE;
    public static EntityType<BathTireEntity> GRAY_BATH_TIRE;
    public static EntityType<BathTireEntity> LIGHT_GRAY_BATH_TIRE;
    public static EntityType<BathTireEntity> CYAN_BATH_TIRE;
    public static EntityType<BathTireEntity> PURPLE_BATH_TIRE;
    public static EntityType<BathTireEntity> BLUE_BATH_TIRE;
    public static EntityType<BathTireEntity> BROWN_BATH_TIRE;
    public static EntityType<BathTireEntity> GREEN_BATH_TIRE;
    public static EntityType<BathTireEntity> RED_BATH_TIRE;
    public static EntityType<BathTireEntity> BLACK_BATH_TIRE;

    public static EntityType<BathTireEntity> DUCK_BATH_TIRE;

    public static void init() {
        WHITE_BATH_TIRE = registerBathTire(id("white_bath_tire"));
        ORANGE_BATH_TIRE = registerBathTire(id("orange_bath_tire"));
        MAGENTA_BATH_TIRE= registerBathTire(id("magenta_bath_tire"));
        LIGHT_BLUE_BATH_TIRE = registerBathTire(id("light_blue_bath_tire"));
        YELLOW_BATH_TIRE = registerBathTire(id("yellow_bath_tire"));
        LIME_BATH_TIRE = registerBathTire(id("lime_bath_tire"));
        PINK_BATH_TIRE = registerBathTire(id("pink_bath_tire"));
        GRAY_BATH_TIRE = registerBathTire(id("gray_bath_tire"));
        LIGHT_GRAY_BATH_TIRE = registerBathTire(id("light_gray_bath_tire"));
        CYAN_BATH_TIRE = registerBathTire(id("cyan_bath_tire"));
        PURPLE_BATH_TIRE = registerBathTire(id("purple_bath_tire"));
        BLUE_BATH_TIRE = registerBathTire(id("blue_bath_tire"));
        BROWN_BATH_TIRE = registerBathTire(id("brown_bath_tire"));
        GREEN_BATH_TIRE = registerBathTire(id("green_bath_tire"));
        RED_BATH_TIRE = registerBathTire(id("red_bath_tire"));
        BLACK_BATH_TIRE = registerBathTire(id("black_bath_tire"));

        DUCK_BATH_TIRE = registerBathTire(id("duck_bath_tire"));
    }
    private static EntityType<BathTireEntity> registerBathTire(Identifier id) {
        EntityType<BathTireEntity> entity = Registry.register(Registries.ENTITY_TYPE, id, EntityType.Builder.create(BathTireEntity::new, SpawnGroup.AMBIENT).dimensions(1.5f,1).maxTrackingRange(100).trackingTickInterval(4).build());
        FabricDefaultAttributeRegistry.register(entity, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        registerItem(id, new BathTireItem(entity, new Item.Settings()), PoolGroup);
        return entity;
    }
}
