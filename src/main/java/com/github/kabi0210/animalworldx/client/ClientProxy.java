package com.github.kabi0210.animalworldx.client;

import com.github.kabi0210.animalworldx.common.CommonProxy;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void bindEntitiesRenderer(ModelRegistryEvent event) {
    }

    @SubscribeEvent
    public static void registerItemModels(ModelRegistryEvent event) {
    }

    @SubscribeEvent
    public static void registerBlockModels(ModelRegistryEvent event) {
    }
}
