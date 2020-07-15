package com.github.kaydogz.happycarmod.network;

import com.github.kaydogz.happycarmod.HappyCarMod;
import com.github.kaydogz.happycarmod.network.client.CUpdatePedalDownPacket;
import com.github.kaydogz.happycarmod.network.client.CUpdateTurnChangePacket;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.simple.SimpleChannel;

public class PacketHandler {

    private static final String PROTOCOL_VERSION = Integer.toString(1);
    private static final SimpleChannel HANDLER = NetworkRegistry.ChannelBuilder
            .named(HappyCarMod.modLocation("main"))
            .clientAcceptedVersions(PROTOCOL_VERSION::equals)
            .serverAcceptedVersions(PROTOCOL_VERSION::equals)
            .networkProtocolVersion(() -> PROTOCOL_VERSION)
            .simpleChannel();

    /**
     * Registers network packets for HappyCarMod.
     */
    public static void registerPackets() {
        int packetId = 0;

        // Client to Server
        HANDLER.registerMessage(packetId++, CUpdatePedalDownPacket.class, CUpdatePedalDownPacket::encode, CUpdatePedalDownPacket::decode, CUpdatePedalDownPacket.Handler::handle);
        HANDLER.registerMessage(packetId, CUpdateTurnChangePacket.class, CUpdateTurnChangePacket::encode, CUpdateTurnChangePacket::decode, CUpdateTurnChangePacket.Handler::handle);
    }

    /**
     * Sends a packet from a client to the server.
     * @param msg an instance of the packet to be sent.
     */
    public static <MSG> void sendToServer(MSG msg) {
        HANDLER.send(PacketDistributor.SERVER.noArg(), msg);
    }
}
