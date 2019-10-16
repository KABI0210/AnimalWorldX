package com.github.kabi0210.petbox001.client;

import com.github.kabi0210.petbox001.client.renderer.RenderPetBox001;
import com.github.kabi0210.petbox001.common.CommonProxy;
import com.github.kabi0210.petbox001.common.entity.EntityPetBox001;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber
public class ClientProxy extends CommonProxy {
    @SubscribeEvent
    public static void bindEntitiesTexture(ModelRegistryEvent event){
        RenderingRegistry.registerEntityRenderingHandler(EntityPetBox001.class,RenderPetBox001::new);


    }

}
