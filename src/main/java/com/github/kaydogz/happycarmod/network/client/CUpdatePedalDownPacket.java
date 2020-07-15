package com.github.kaydogz.happycarmod.network.client;

import com.github.kaydogz.happycarmod.entity.CarEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CUpdatePedalDownPacket {

    private final boolean pedalDown;
    private final boolean reverse;

    public CUpdatePedalDownPacket(boolean pedalDownIn, boolean reverseIn) {
        this.pedalDown = pedalDownIn;
        this.reverse = reverseIn;
    }

    public static void encode(CUpdatePedalDownPacket msg, PacketBuffer buf) {
        buf.writeBoolean(msg.pedalDown);
        buf.writeBoolean(msg.reverse);
    }

    public static CUpdatePedalDownPacket decode(PacketBuffer buf) {
        return new CUpdatePedalDownPacket(buf.readBoolean(), buf.readBoolean());
    }

    public static class Handler {

        public static void handle(final CUpdatePedalDownPacket msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayerEntity player = ctx.get().getSender();

                if (player != null) {
                    Entity ridingEntity = player.getRidingEntity();

                    if (ridingEntity instanceof CarEntity) {
                        CarEntity carEntity = (CarEntity) ridingEntity;
                        carEntity.setPedalDown(msg.pedalDown);
                        carEntity.setReverse(msg.reverse);
                    }
                }
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
