package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.block.PoolWall;
import eu.midnightdust.motschen.decorative.block.Springboard;
import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.item.BathTireItem;
import eu.pb4.polymer.core.api.entity.PolymerEntityUtils;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static eu.midnightdust.motschen.decorative.DecorativeMain.PoolGroup;
import static eu.midnightdust.motschen.decorative.DecorativeMain.id;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerItem;
import static eu.midnightdust.motschen.decorative.util.RegistryUtil.registerPool;

public class Pool {

    public static final EntityType<BeachBallEntity> BEACH_BALL = registerBeachBall(id("beach_ball"));
    public static final Item BEACH_BALL_ITEM = new BathTireItem(BEACH_BALL, new Item.Settings());
    public static Block PoolWall = new PoolWall();
    public static Block Springboard = new Springboard();
    public static Block PoolSprinkler = new PoolSprinkler();

    public static void init() {
        registerPool(id("pool_wall"), PoolWall);
        registerPool(id("springboard"), Springboard);
        registerPool(id("pool_sprinkler"), PoolSprinkler);
        registerItem(id("beach_ball"), BEACH_BALL_ITEM, PoolGroup);
        BathTires.init();
    }
    private static EntityType<BeachBallEntity> registerBeachBall(Identifier id) {
        EntityType<BeachBallEntity> entity = Registry.register(Registries.ENTITY_TYPE, id, EntityType.Builder.create(BeachBallEntity::new, SpawnGroup.AMBIENT).dimensions(0.9f,0.9f).maxTrackingRange(100).trackingTickInterval(4).build());
        FabricDefaultAttributeRegistry.register(entity, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100000.0D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, -10D));
        PolymerEntityUtils.registerType(entity);
        return entity;
    }
}
