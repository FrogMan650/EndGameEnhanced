package net.Lucas.endgameenhanced.event;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.entity.client.LeviathansAxeModel;
import net.Lucas.endgameenhanced.entity.client.ObsidianElytraLayer;
import net.Lucas.endgameenhanced.entity.client.ObsidianElytraModel;
import net.Lucas.endgameenhanced.entity.client.TideBreakerModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
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
    }
    @SubscribeEvent
    public static void addPlayerLayers(EntityRenderersEvent.AddLayers event) {
        LivingEntityRenderer<Player, PlayerModel<Player>> rendererr = event.getSkin("default");
        LivingEntityRenderer<Player, PlayerModel<Player>> renderer = event.getRenderer(EntityType.PLAYER);
        ObsidianElytraLayer<Player, PlayerModel<Player>> layer = new ObsidianElytraLayer<>(renderer, event.getEntityModels());
        rendererr.addLayer(layer);
    }

}
