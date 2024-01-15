package net.Lucas.tutorialmod.entity;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.entity.custom.TideBreakerEntity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, TutorialMod.MOD_ID);

    public static final RegistryObject<EntityType<TideBreakerEntity>> TIDE_BREAKER =
            ENTITY_TYPES.register("tide_breaker", () -> EntityType.Builder.<TideBreakerEntity>of(TideBreakerEntity::new,
                    MobCategory.MISC).sized(0.5F, 0.5F).clientTrackingRange(4)
                    .updateInterval(20).build("tide_breaker"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
