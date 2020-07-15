package com.github.kaydogz.happycarmod;

import com.github.kaydogz.happycarmod.client.ClientHandler;
import com.github.kaydogz.happycarmod.entity.HCMEntities;
import com.github.kaydogz.happycarmod.item.HCMItems;
import com.github.kaydogz.happycarmod.util.HCMSoundEvents;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(HappyCarMod.MODID)
public class HappyCarMod {

    public static final String MODID = "happycarmod";
    public static final Logger LOGGER = LogManager.getLogger(MODID);

    public HappyCarMod() {

        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        HCMItems.registerItems(eventBus);
        HCMEntities.registerEntities(eventBus);
        HCMSoundEvents.registerSoundEvents(eventBus);

        eventBus.addListener(CommonHandler::onCommonSetup);
        eventBus.addListener(ClientHandler::onClientSetup);
    }

    public static ResourceLocation modLocation(String pathIn) {
        return new ResourceLocation(MODID, pathIn);
    }

    public static void debug(Object msg) {
        LOGGER.debug(msg);
    }
}
