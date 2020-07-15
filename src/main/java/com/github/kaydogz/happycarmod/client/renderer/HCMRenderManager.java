package com.github.kaydogz.happycarmod.client.renderer;

import com.github.kaydogz.happycarmod.entity.HCMEntities;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class HCMRenderManager {

    public static void registerEntityRenderers() {
        RenderingRegistry.registerEntityRenderingHandler(HCMEntities.CAR.get(), new CarRenderer.RenderFactory<>());
    }
}
