package com.github.kaydogz.happycarmod.entity;

import com.github.kaydogz.happycarmod.HappyCarMod;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HCMEntities {

    private static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, HappyCarMod.MODID);

    public static void registerEntities(final IEventBus eventBus) {
        ENTITIES.register(eventBus);
    }

    public static final RegistryObject<EntityType<CarEntity>> CAR = ENTITIES.register("car", () -> EntityType.Builder.create(CarEntity::new, EntityClassification.MISC).size(2.0F, 2.0F).immuneToFire().build("car"));
}
