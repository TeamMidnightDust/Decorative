package eu.midnightdust.motschen.decorative.init;

import eu.midnightdust.motschen.decorative.DecorativeMain;
import eu.midnightdust.motschen.decorative.entity.BathTireEntity;
import eu.midnightdust.motschen.decorative.item.BathTireItem;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BathTires {
    public static final EntityType<BathTireEntity> WHITE_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","white_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> ORANGE_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","orange_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> MAGENTA_BATH_TIRE=
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","magenta_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> LIGHT_BLUE_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","light_blue_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> YELLOW_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","yellow_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> LIME_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","lime_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> PINK_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","pink_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> GRAY_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","gray_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> LIGHT_GRAY_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","light_gray_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> CYAN_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","cyan_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> PURPLE_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","purple_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> BLUE_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","blue_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> BROWN_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","brown_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> GREEN_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","green_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> RED_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","red_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());
    public static final EntityType<BathTireEntity> BLACK_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","black_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());

    public static final EntityType<BathTireEntity> DUCK_BATH_TIRE =
            Registry.register(Registry.ENTITY_TYPE,new Identifier("decorative","duck_bath_tire"), FabricEntityTypeBuilder.create(SpawnGroup.AMBIENT,BathTireEntity::new).dimensions(EntityDimensions.fixed(1.5f,1)).trackable(100,4).build());

    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("decorative","white_bath_tire"), new BathTireItem(WHITE_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(WHITE_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","orange_bath_tire"), new BathTireItem(ORANGE_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(ORANGE_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","magenta_bath_tire"), new BathTireItem(MAGENTA_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(MAGENTA_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","light_blue_bath_tire"), new BathTireItem(LIGHT_BLUE_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(LIGHT_BLUE_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","yellow_bath_tire"), new BathTireItem(YELLOW_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(YELLOW_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","lime_bath_tire"), new BathTireItem(LIME_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(LIME_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","pink_bath_tire"), new BathTireItem(PINK_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(PINK_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","gray_bath_tire"), new BathTireItem(GRAY_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(GRAY_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","light_gray_bath_tire"), new BathTireItem(LIGHT_GRAY_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(LIGHT_GRAY_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","cyan_bath_tire"), new BathTireItem(CYAN_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(CYAN_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","purple_bath_tire"), new BathTireItem(PURPLE_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(PURPLE_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","blue_bath_tire"), new BathTireItem(BLUE_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(BLUE_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","brown_bath_tire"), new BathTireItem(BROWN_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(BROWN_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","green_bath_tire"), new BathTireItem(GREEN_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(GREEN_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","red_bath_tire"), new BathTireItem(RED_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(RED_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
        Registry.register(Registry.ITEM, new Identifier("decorative","black_bath_tire"), new BathTireItem(BLACK_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(BLACK_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));

        Registry.register(Registry.ITEM, new Identifier("decorative","duck_bath_tire"), new BathTireItem(DUCK_BATH_TIRE, new Item.Settings().group(DecorativeMain.PoolGroup)));
        FabricDefaultAttributeRegistry.register(DUCK_BATH_TIRE, MobEntity.createMobAttributes().add(EntityAttributes.GENERIC_MAX_HEALTH, 2.0D));
    }
}
