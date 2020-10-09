package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.block.PoolSprinkler;
import eu.midnightdust.motschen.decorative.block.PoolWall;
import eu.midnightdust.motschen.decorative.block.Springboard;
import eu.midnightdust.motschen.decorative.entity.BeachBallEntity;
import eu.midnightdust.motschen.decorative.item.BathTireItem;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Pool {

    public static final EntityType<BeachBallEntity> BEACH_BALL =
            Registry.register(Registry.ENTITY_TYPE,new Identifier(DecorativeMain.MOD_ID,"beach_ball"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT, BeachBallEntity::new).dimensions(EntityDimensions.fixed(0.9f,0.9f)).trackable(100,4).build());
    public static Item BEACH_BALL_ITEM = new BathTireItem(BEACH_BALL, new Item.Settings().group(DecorativeMain.PoolGroup));
    public static Block PoolWall = new PoolWall();
    public static Block Springboard = new Springboard();
    public static Block PoolSprinkler = new PoolSprinkler();

    public static void init() {
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"pool_wall"), PoolWall);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"pool_wall"), new BlockItem(PoolWall, new Item.Settings().group(DecorativeMain.PoolGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"springboard"), Springboard);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"springboard"), new BlockItem(Springboard, new Item.Settings().group(DecorativeMain.PoolGroup)));
        Registry.register(Registry.BLOCK, new Identifier(DecorativeMain.MOD_ID,"pool_sprinkler"), PoolSprinkler);
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"pool_sprinkler"), new BlockItem(PoolSprinkler, new Item.Settings().group(DecorativeMain.PoolGroup)));
        Registry.register(Registry.ITEM, new Identifier(DecorativeMain.MOD_ID,"beach_ball"), BEACH_BALL_ITEM);
        FabricDefaultAttributeRegistry.register(BEACH_BALL, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 100000.0D).add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE, -10D));
        BathTires.init();
    }
}
