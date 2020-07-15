package com.github.kaydogz.happycarmod.network.client;

import com.github.kaydogz.happycarmod.entity.CarEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.network.NetworkEvent;

import java.util.function.Supplier;

public class CUpdateTurnChangePacket {

    private final float turnChange;

    public CUpdateTurnChangePacket(float turnChangeIn) {
        this.turnChange = turnChangeIn;
    }

    public static void encode(CUpdateTurnChangePacket msg, PacketBuffer buf) {
        buf.writeFloat(msg.turnChange);
    }

    public static CUpdateTurnChangePacket decode(PacketBuffer buf) {
        return new CUpdateTurnChangePacket(buf.readFloat());
    }

    public static class Handler {

        public static void handle(final CUpdateTurnChangePacket msg, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                ServerPlayerEntity player = ctx.get().getSender();

                if (player != null) {
                    Entity ridingEntity = player.getRidingEntity();

                    if (ridingEntity instanceof CarEntity) {
                        ((CarEntity) ridingEntity).setTurnChange(msg.turnChange);
                    }
                }
            });
            ctx.get().setPacketHandled(true);
        }
    }
}
