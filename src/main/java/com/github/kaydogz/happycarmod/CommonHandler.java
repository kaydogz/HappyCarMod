package com.github.kaydogz.happycarmod;

import com.github.kaydogz.happycarmod.item.HCMSpawnEggItem;
import com.github.kaydogz.happycarmod.network.PacketHandler;
import net.minecraft.entity.EntityType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class CommonHandler {

    public static void onCommonSetup(final FMLCommonSetupEvent event) {
        PacketHandler.registerPackets();
    }

    @Mod.EventBusSubscriber(modid = HappyCarMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEvents {

        /**
         * Exists to work around a limitation with Spawn Eggs:
         * Spawn Eggs require an EntityType, but EntityTypes are created AFTER Items.
         * Therefore it is "impossible" for modded spawn eggs to exist.
         * To get around this we have our own custom SpawnEggItem, but it needs
         * some extra setup after Item and EntityType registration completes.
         * #TODO Remove when forge fixes
         */
        @SubscribeEvent(priority = EventPriority.LOWEST)
        public static void postRegisterEntities(final RegistryEvent.Register<EntityType<?>> event) {
            HCMSpawnEggItem.initUnaddedEggs();
        }
    }
}
