package net.jukoz.me.network;

import net.fabricmc.fabric.api.networking.v1.PayloadTypeRegistry;
import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;
import net.jukoz.me.network.connections.IConnectionToClient;
import net.jukoz.me.network.contexts.ServerPacketContext;
import net.jukoz.me.network.packets.ClientToServerPacket;
import net.jukoz.me.network.packets.C2S.*;
import net.jukoz.me.network.packets.S2C.*;
import net.minecraft.server.network.ServerPlayerEntity;

import java.util.function.BiConsumer;

public class ModServerNetworkHandler {
    public static void register(IConnectionToClient connection) {
        // REGISTRY : Server to client
        PayloadTypeRegistry.playS2C().register(PacketOnboardingResult.ID, PacketOnboardingResult.CODEC);

        // REGISTRY : Client to server
        PayloadTypeRegistry.playC2S().register(PacketSetAffiliation.ID, PacketSetAffiliation.CODEC);
        PayloadTypeRegistry.playC2S().register(PacketTeleportToCustomCoordinate.ID, PacketTeleportToCustomCoordinate.CODEC);
        PayloadTypeRegistry.playC2S().register(PacketTeleportToDynamicCoordinate.ID, PacketTeleportToDynamicCoordinate.CODEC);
        PayloadTypeRegistry.playC2S().register(PacketTeleportToCurrentSpawn.ID, PacketTeleportToCurrentSpawn.CODEC);
        PayloadTypeRegistry.playC2S().register(PacketSetSpawnData.ID, PacketSetSpawnData.CODEC);
        PayloadTypeRegistry.playC2S().register(PacketOnboardingRequest.ID, PacketOnboardingRequest.CODEC);

        // Application [SERVER SIDE]
        ServerPlayNetworking.registerGlobalReceiver(PacketSetAffiliation.ID, wrapServerHandler(connection, PacketSetAffiliation::process));
        ServerPlayNetworking.registerGlobalReceiver(PacketTeleportToCustomCoordinate.ID, wrapServerHandler(connection, PacketTeleportToCustomCoordinate::process));
        ServerPlayNetworking.registerGlobalReceiver(PacketTeleportToDynamicCoordinate.ID, wrapServerHandler(connection, PacketTeleportToDynamicCoordinate::process));
        ServerPlayNetworking.registerGlobalReceiver(PacketTeleportToCurrentSpawn.ID, wrapServerHandler(connection, PacketTeleportToCurrentSpawn::process));
        ServerPlayNetworking.registerGlobalReceiver(PacketSetSpawnData.ID, wrapServerHandler(connection, PacketSetSpawnData::process));
        ServerPlayNetworking.registerGlobalReceiver(PacketOnboardingRequest.ID, wrapServerHandler(connection, PacketOnboardingRequest::process));
    }

    private static <T extends ClientToServerPacket<T>> ServerPlayNetworking.PlayPayloadHandler<T> wrapServerHandler(
            IConnectionToClient connection,
            BiConsumer<T, ServerPacketContext> consumer
    ) {
        return (t, payloadContext) -> {
            ServerPlayerEntity player = payloadContext.player();
            var serverPacketContext = new ServerPacketContext(player, connection);
            consumer.accept(t, serverPacketContext);
        };
    }
}