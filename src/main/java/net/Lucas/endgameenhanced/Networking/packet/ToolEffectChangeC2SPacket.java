package net.Lucas.endgameenhanced.Networking.packet;

import net.Lucas.endgameenhanced.toolChange.PlayerToolChangeProvider;
import net.minecraft.ChatFormatting;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ToolEffectChangeC2SPacket {
    String oneByOne = "endgameenhanced.translated.destruction.1.x.1";
    String threeByThree = "endgameenhanced.translated.destruction.3.x.3";
    int effectSetting = 0;
    public ToolEffectChangeC2SPacket() {

    }

    public ToolEffectChangeC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            //ANYTHING IN HERE IS DONE ONLY ON SERVER
            ServerPlayer player = context.getSender();
            ServerLevel level = player.serverLevel();
            player.getCapability(PlayerToolChangeProvider.PLAYER_TOOL_CHANGE).ifPresent(toolChange -> {
                int currentToolChange = toolChange.getToolChange();
                if (currentToolChange == 1) {
                    toolChange.changeToZero();
                    level.playSound(null, player.getOnPos(), SoundEvents.ALLAY_HURT, SoundSource.PLAYERS, 0.25F, level.random.nextFloat() * 0.1F + 0.9F);
                } else {
                    toolChange.changeToOne();
                    level.playSound(null, player.getOnPos(), SoundEvents.ALLAY_HURT, SoundSource.PLAYERS, 0.25F, level.random.nextFloat() * 0.1F + 0.9F);
                }
                if (currentToolChange == 1) {
                    player.sendSystemMessage(Component.translatable(oneByOne).withStyle(ChatFormatting.BLUE));
                } else player.sendSystemMessage(Component.translatable(threeByThree).withStyle(ChatFormatting.BLUE));
             });

        });
        return true;
    }
}
