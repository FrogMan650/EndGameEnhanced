package net.Lucas.endgameenhanced.event;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.client.*;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.resources.PlayerSkin;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EndGameEnhanced.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventBusClientEvents {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(TideBreakerModel.TIDE_BREAKER_LAYER_LOCATION, TideBreakerModel::createBodyLayer);
        event.registerLayerDefinition(LeviathansAxeModel.LEVIATHANS_AXE_LAYER_LOCATION, LeviathansAxeModel::createBodyLayer);
        event.registerLayerDefinition(ObsidianElytraModel.WINGS_LAYER_LOCATION, ObsidianElytraModel::createLayer);
        event.registerLayerDefinition(UnkemptHaroldProjectileModel.UNKEMPT_HAROLD_LAYER_LOCATION, UnkemptHaroldProjectileModel::createMobHeadLayer);
    }

    @SubscribeEvent @SuppressWarnings({"unchecked", "rawtypes"})
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        for (PlayerSkin.Model skin : event.getSkins()) {

            LivingEntityRenderer renderer = event.getPlayerSkin(skin);

            if (renderer != null) {
                renderer.addLayer(new ObsidianElytraLayer<>(renderer, event.getEntityModels()));
            }
        }
        EntityRenderer renderer = event.getEntityRenderer(EntityType.ARMOR_STAND);
        if (renderer != null) {
            ((LivingEntityRenderer)renderer).addLayer(new ObsidianElytraLayer<>(((LivingEntityRenderer)renderer), event.getEntityModels()));
        }
    }

}
