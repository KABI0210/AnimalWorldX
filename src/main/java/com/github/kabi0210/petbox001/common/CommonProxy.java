package com.github.kabi0210.petbox001.common;


import com.github.kabi0210.petbox001.AnimalWorldX;
import com.github.kabi0210.petbox001.common.entity.EntityPetBox001;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber

public class CommonProxy {
    @SubscribeEvent
    public static void  registerEntities(RegistryEvent.Register<EntityEntry> event){
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(EntityPetBox001.class)
                .id(new ResourceLocation(AnimalWorldX.MOD_ID,"pet_box_001"),1)
                .name("pet_box_001")
                .tracker(64,64,true)
                .egg(000000,000000)
                .build()
        );


    }
}
