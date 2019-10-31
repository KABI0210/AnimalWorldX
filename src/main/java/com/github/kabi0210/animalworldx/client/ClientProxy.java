package com.github.kabi0210.animalworldx.client;

import com.github.kabi0210.animalworldx.annotations.RegisterManager;
import com.github.kabi0210.animalworldx.client.render.RenderPetBox001;
import com.github.kabi0210.animalworldx.common.CommonProxy;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void bindEntitiesTexture(ModelRegistryEvent event) {
        RenderingRegistry.registerEntityRenderingHandler(EntityPetBox001.class, RenderPetBox001::new);
    }

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
        RegisterManager.getInstance().registerItemModel(event);
    }

    @SubscribeEvent
    public static void registerBlockModels(ModelRegistryEvent event) {
        RegisterManager.getInstance().registerBlockModel(event);
    }
}
