package com.github.kaydogz.happycarmod.util;

import com.github.kaydogz.happycarmod.HappyCarMod;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HCMSoundEvents {

    private static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HappyCarMod.MODID);

    public static void registerSoundEvents(final IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }

    public static final RegistryObject<SoundEvent> ENTITY_CAR_START = SOUND_EVENTS.register("entity.car.start", () -> new SoundEvent(HappyCarMod.modLocation("entity.car.start")));
    public static final RegistryObject<SoundEvent> ENTITY_CAR_DRIVING = SOUND_EVENTS.register("entity.car.driving", () -> new SoundEvent(HappyCarMod.modLocation("entity.car.driving")));
}
