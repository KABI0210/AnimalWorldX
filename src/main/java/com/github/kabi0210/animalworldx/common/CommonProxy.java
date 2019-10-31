package com.github.kabi0210.animalworldx.common;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.annotations.RegisterManager;
import com.github.kabi0210.animalworldx.common.entity.EntityPetBox001;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;

@Mod.EventBusSubscriber
public class CommonProxy {
    public void preInit(FMLPreInitializationEvent event) throws ClassNotFoundException, IllegalAccessException {
        RegisterManager.getInstance().processRegistries(event.getAsmData());
        RegisterManager.getInstance().registerOreDict();
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegisterManager.getInstance().registerItems(event);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegisterManager.getInstance().registerBlocks(event);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        event.getRegistry().register(EntityEntryBuilder.create()
                .entity(EntityPetBox001.class)
                .id(new ResourceLocation(AnimalWorldX.MOD_ID, AnimalWorldX.MOD_ID + ".pet_box_001"), 233)
                .name(AnimalWorldX.MOD_ID + ".pet_box_001")
                .tracker(64, 64, true)
                .egg(0, 0)
                .build());
    }
}
