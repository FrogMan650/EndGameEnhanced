package net.Lucas.endgameenhanced.Networking.packet;

import net.Lucas.endgameenhanced.blockFacing.PlayerBlockFacingProvider;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.network.CustomPayloadEvent;

public class PlayerBlockFacingC2SPacket {
    public PlayerBlockFacingC2SPacket() {

    }

    public PlayerBlockFacingC2SPacket(FriendlyByteBuf buf) {

    }

    public void toBytes(FriendlyByteBuf buf) {

    }

    public boolean handle(CustomPayloadEvent.Context context) {
        context.enqueueWork(() -> {
            //ANYTHING IN HERE IS DONE ONLY ON SERVER
            ServerPlayer player = context.getSender();
            if (player != null) {
                player.getCapability(PlayerBlockFacingProvider.PLAYER_BLOCK_FACING).ifPresent(blockFacing -> {
                    int blockFacings = blockFacing.getBlockFacing();
                    if (blockFacings == 0) {
                        player.sendSystemMessage(Component.literal("facing up or down"));
                    }
                    if (blockFacings == 1) {
                        player.sendSystemMessage(Component.literal("facing north or south"));
                    }
                    if (blockFacings == 2) {
                        player.sendSystemMessage(Component.literal("facing east or west"));
                    }
                });
            }
        });
        return true;
    }
}
