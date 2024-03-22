package net.Lucas.endgameenhanced;

import com.mojang.logging.LogUtils;
import net.Lucas.endgameenhanced.Networking.ModMessages;
import net.Lucas.endgameenhanced.block.ModBlocks;
import net.Lucas.endgameenhanced.entity.ModEntities;
import net.Lucas.endgameenhanced.entity.client.*;
import net.Lucas.endgameenhanced.item.ModCreativeModeTabs;
import net.Lucas.endgameenhanced.item.ModItems;
import net.Lucas.endgameenhanced.loot.ModLootModifier;
import net.Lucas.endgameenhanced.potions.ExperienceBottleOneOfThree;
import net.Lucas.endgameenhanced.potions.ExperienceBottleThreeOfThree;
import net.Lucas.endgameenhanced.potions.ExperienceBottleTwoOfThree;
import net.Lucas.endgameenhanced.util.ModItemProperties;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

//Massive thanks to Kaupenjoe on Youtube.
//His tutorials helped me learn a HUGE part of what I know about minecraft coding
//and he helped me improve my java skills considerably
//https://www.youtube.com/playlist?list=PLKGarocXCE1H9Y21-pxjt5Pt8bW14twa-

//can change mod name and description in gradle.properties

@Mod(EndGameEnhanced.MOD_ID)
public class EndGameEnhanced {
    public static final String MOD_ID = "endgameenhanced";
    private static final Logger LOGGER = LogUtils.getLogger();

    public EndGameEnhanced() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModLootModifier.register(modEventBus);
        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModMessages.register();

            BrewingRecipeRegistry.addRecipe(new ExperienceBottleOneOfThree(
                    ModItems.EXPERIENCE_BOTTLE_NETHER_WART.get()));
            BrewingRecipeRegistry.addRecipe(new ExperienceBottleTwoOfThree(ModItems.EXPERIENCE_BOTTLE_NETHER_WART_CHORUS_FRUIT.get()));
            BrewingRecipeRegistry.addRecipe(new ExperienceBottleThreeOfThree(ModItems.BASIC_ESSENCE.get()));
        });
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            ModItemProperties.addCustomItemProperties();
            EntityRenderers.register(ModEntities.TIDE_BREAKER.get(), TideBreakerRenderer::new);
            EntityRenderers.register(ModEntities.LEVIATHANS_AXE.get(), LeviathansAxeRenderer::new);
            EntityRenderers.register(ModEntities.SAPPHIRE_ARROW.get(), SapphireArrowRenderer::new);
            EntityRenderers.register(ModEntities.EMERALD_ARROW.get(), EmeraldArrowRenderer::new);
            EntityRenderers.register(ModEntities.RUBY_ARROW.get(), RubyArrowRenderer::new);
            EntityRenderers.register(ModEntities.DIAMOND_ARROW.get(), DiamondArrowRenderer::new);
            EntityRenderers.register(ModEntities.ONYX_ARROW.get(), OnyxArrowRenderer::new);
            EntityRenderers.register(ModEntities.UNKEMPT_HAROLD_PROJECTILE.get(), UnkemptHaroldProjectileRenderer::new);
            EntityRenderers.register(ModEntities.WEBWEAVER_DEFAULT_ARROW_ENTITY.get(), DefaultWebweaverArrowRenderer::new);
            EntityRenderers.register(ModEntities.SCULK_SLINGER_DEFAULT_ARROW_ENTITY.get(), DefaultSculkSlingerArrowRenderer::new);
        }
    }
}
