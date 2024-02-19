package net.Lucas.endgameenhanced.entity;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.custom.LeviathansAxeEntity;
import net.Lucas.endgameenhanced.entity.custom.TideBreakerEntity;
import net.Lucas.endgameenhanced.entity.projectile.*;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, EndGameEnhanced.MOD_ID);

    public static final RegistryObject<EntityType<TideBreakerEntity>> TIDE_BREAKER =
            ENTITY_TYPES.register("tide_breaker", () -> EntityType.Builder.<TideBreakerEntity>of(TideBreakerEntity::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("tide_breaker"));
    public static final RegistryObject<EntityType<LeviathansAxeEntity>> LEVIATHANS_AXE =
            ENTITY_TYPES.register("leviathans_axe", () -> EntityType.Builder.<LeviathansAxeEntity>of(LeviathansAxeEntity::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("leviathans_axe"));

    public static final RegistryObject<EntityType<SapphireArrowEntity>> SAPPHIRE_ARROW =
            ENTITY_TYPES.register("sapphire_arrow", () -> EntityType.Builder.<SapphireArrowEntity>of(SapphireArrowEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("sapphire_arrow"));
    public static final RegistryObject<EntityType<EmeraldArrowEntity>> EMERALD_ARROW =
            ENTITY_TYPES.register("emerald_arrow", () -> EntityType.Builder.<EmeraldArrowEntity>of(EmeraldArrowEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("emerald_arrow"));

    public static final RegistryObject<EntityType<RubyArrowEntity>> RUBY_ARROW =
            ENTITY_TYPES.register("ruby_arrow", () -> EntityType.Builder.<RubyArrowEntity>of(RubyArrowEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("ruby_arrow"));
    public static final RegistryObject<EntityType<DiamondArrowEntity>> DIAMOND_ARROW =
            ENTITY_TYPES.register("diamond_arrow", () -> EntityType.Builder.<DiamondArrowEntity>of(DiamondArrowEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("diamond_arrow"));
    public static final RegistryObject<EntityType<OnyxArrowEntity>> ONYX_ARROW =
            ENTITY_TYPES.register("onyx_arrow", () -> EntityType.Builder.<OnyxArrowEntity>of(OnyxArrowEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("onyx_arrow"));
    public static final RegistryObject<EntityType<UnkemptHaroldProjectileEntity>> UNKEMPT_HAROLD_PROJECTILE =
            ENTITY_TYPES.register("unkempt_projectile", () -> EntityType.Builder.<UnkemptHaroldProjectileEntity>of(UnkemptHaroldProjectileEntity::new,
                            MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("unkempt_projectile"));



    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
