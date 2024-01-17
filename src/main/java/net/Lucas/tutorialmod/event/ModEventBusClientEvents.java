package net.Lucas.tutorialmod.event;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.entity.client.LeviathansAxeModel;
import net.Lucas.tutorialmod.entity.client.TideBreakerModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TideBreakerModel.TIDE_BREAKER_LAYER_LOCATION, TideBreakerModel::createBodyLayer);
        event.registerLayerDefinition(LeviathansAxeModel.LEVIATHANS_AXE_LAYER_LOCATION, LeviathansAxeModel::createBodyLayer);
    }
}
