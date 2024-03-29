package net.Lucas.endgameenhanced.Networking;

import net.Lucas.endgameenhanced.Networking.packet.PlayerBlockFacingC2SPacket;
import net.Lucas.endgameenhanced.Networking.packet.ToolEffectChangeC2SPacket;
import net.Lucas.endgameenhanced.EndGameEnhanced;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.ChannelBuilder;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.SimpleChannel;

public class ModMessages {
    private static final SimpleChannel INSTANCE = ChannelBuilder
            .named(new ResourceLocation(EndGameEnhanced.MOD_ID, "messages"))
            .clientAcceptedVersions((status, version) -> true)
            .serverAcceptedVersions((status, version) -> true)
            .networkProtocolVersion(1)
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
        INSTANCE.send(message, PacketDistributor.SERVER.noArg());
    }

}
