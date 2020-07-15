package com.github.kaydogz.happycarmod.client;

import com.github.kaydogz.happycarmod.HappyCarMod;
import com.github.kaydogz.happycarmod.client.audio.CarDrivingTickableSound;
import com.github.kaydogz.happycarmod.client.renderer.HCMRenderManager;
import com.github.kaydogz.happycarmod.entity.CarEntity;
import com.github.kaydogz.happycarmod.network.PacketHandler;
import com.github.kaydogz.happycarmod.network.client.CUpdatePedalDownPacket;
import com.github.kaydogz.happycarmod.network.client.CUpdateTurnChangePacket;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import org.lwjgl.glfw.GLFW;

public class ClientHandler {

    public static void onClientSetup(final FMLClientSetupEvent event) {
        HCMRenderManager.registerEntityRenderers();
    }

    public static void playDrivingSound(CarEntity carEntityIn) {
        Minecraft.getInstance().getSoundHandler().playDelayed(new CarDrivingTickableSound(carEntityIn), 20);
    }

    @Mod.EventBusSubscriber(modid = HappyCarMod.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
    public static class ForgeBus {

        @SubscribeEvent
        public static void onKeyInput(final InputEvent.KeyInputEvent event) {
            Minecraft minecraft = Minecraft.getInstance();
            ClientPlayerEntity player = minecraft.player;

            if (player != null && player.getRidingEntity() instanceof CarEntity) {
                int forwardKeyCode = minecraft.gameSettings.keyBindForward.getKey().getKeyCode();
                int rightKeyCode = minecraft.gameSettings.keyBindRight.getKey().getKeyCode();
                int leftKeyCode = minecraft.gameSettings.keyBindLeft.getKey().getKeyCode();
                int backKeyCode = minecraft.gameSettings.keyBindBack.getKey().getKeyCode();

                if (event.getAction() == GLFW.GLFW_RELEASE) {
                    if (event.getKey() == forwardKeyCode) PacketHandler.sendToServer(new CUpdatePedalDownPacket(false, false));
                    else if (event.getKey() == backKeyCode) PacketHandler.sendToServer(new CUpdatePedalDownPacket(false, false));
                    else if (event.getKey() == rightKeyCode || event.getKey() == leftKeyCode) PacketHandler.sendToServer(new CUpdateTurnChangePacket(0.0F));
                } else if (event.getAction() == GLFW.GLFW_PRESS) {
                    if (event.getKey() == forwardKeyCode) PacketHandler.sendToServer(new CUpdatePedalDownPacket(true, false));
                    else if (event.getKey() == backKeyCode) PacketHandler.sendToServer(new CUpdatePedalDownPacket(true, true));
                    else if (event.getKey() == rightKeyCode) PacketHandler.sendToServer(new CUpdateTurnChangePacket(0.05F));
                    else if (event.getKey() == leftKeyCode) PacketHandler.sendToServer(new CUpdateTurnChangePacket(-0.05F));
                }
            }
        }
    }
}
