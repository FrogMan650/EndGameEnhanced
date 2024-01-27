package net.Lucas.endgameenhanced.entity;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.custom.LeviathansAxeEntity;
import net.Lucas.endgameenhanced.entity.custom.TideBreakerEntity;
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


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
