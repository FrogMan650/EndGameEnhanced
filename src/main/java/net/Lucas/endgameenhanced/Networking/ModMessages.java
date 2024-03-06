package net.Lucas.endgameenhanced.Networking;

import net.Lucas.endgameenhanced.Networking.packet.PlayerBlockFacingC2SPacket;
import net.Lucas.endgameenhanced.Networking.packet.ToolEffectChangeC2SPacket;
import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

public class ModMessages {
    private static SimpleChannel INSTANCE = NetworkRegistry.ChannelBuilder
            .named(new ResourceLocation(EndGameEnhanced.MOD_ID, "messages"))
            .networkProtocolVersion(() -> "1.0")
            .clientAcceptedVersions(s -> true)
            .serverAcceptedVersions(s -> true)
            .simpleChannel();

    private static int packetId = 0;
    private static int id() {
        return packetId++;
    }

    public static void register() {
        INSTANCE.messageBuilder(ToolEffectChangeC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(ToolEffectChangeC2SPacket::new)
                .encoder(ToolEffectChangeC2SPacket::toBytes)
                .consumerMainThread(ToolEffectChangeC2SPacket::handle)
                .add();
        INSTANCE.messageBuilder(PlayerBlockFacingC2SPacket.class, id(), NetworkDirection.PLAY_TO_SERVER)
                .decoder(PlayerBlockFacingC2SPacket::new)
                .encoder(PlayerBlockFacingC2SPacket::toBytes)
                .consumerMainThread(PlayerBlockFacingC2SPacket::handle)
                .add();

    }

    public static <MSG> void sendToServer(MSG message) {
        INSTANCE.sendToServer(message);
    }

    public static <MSG> void sendToPlayer(MSG message, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), message);
    }
}