package com.github.kaydogz.happycarmod.item;

import com.github.kaydogz.happycarmod.HappyCarMod;
import com.github.kaydogz.happycarmod.entity.HCMEntities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class HCMItems {

    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HappyCarMod.MODID);

    public static void registerItems(final IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final RegistryObject<HCMSpawnEggItem> CAR_SPAWN_EGG = ITEMS.register("car_spawn_egg", () -> new HCMSpawnEggItem(HCMEntities.CAR, 0xcb1140, 0x399cbd, new Item.Properties().group(ItemGroup.MISC)));
}
