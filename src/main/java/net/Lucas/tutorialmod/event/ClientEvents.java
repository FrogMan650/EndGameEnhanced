package net.Lucas.tutorialmod.event;

import net.Lucas.tutorialmod.TutorialMod;
import net.Lucas.tutorialmod.item.custom.UnkemptHarold;
import net.Lucas.tutorialmod.util.KeyBinding;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.CHANGE_TOOL_EFFECT_KEY.consumeClick()) {

            }
        }

    }
    @Mod.EventBusSubscriber(modid = TutorialMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.CHANGE_TOOL_EFFECT_KEY);
        }

    }
}
