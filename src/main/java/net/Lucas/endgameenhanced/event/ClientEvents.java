package net.Lucas.endgameenhanced.event;

import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.Lucas.endgameenhanced.Networking.ModMessages;
import net.Lucas.endgameenhanced.Networking.packet.ToolEffectChangeC2SPacket;
import net.Lucas.endgameenhanced.util.KeyBinding;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.neoforge.client.event.InputEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;

public class ClientEvents {
    @Mod.EventBusSubscriber(modid = EndGameEnhanced.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {
        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {
            if (KeyBinding.CHANGE_TOOL_EFFECT_KEY.consumeClick()) {
                ModMessages.sendToServer(new ToolEffectChangeC2SPacket());
            }
        }

    }
    @Mod.EventBusSubscriber(modid = EndGameEnhanced.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.CHANGE_TOOL_EFFECT_KEY);
        }

    }
}
