package com.github.kabi0210.animalworldx.common;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.ILevelProvider;
import com.github.kabi0210.animalworldx.api.event.RegisterMagicBookLevelEvent;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import com.github.kabi0210.animalworldx.common.init.AWSound;
import com.github.ksgfk.dawnfoundation.api.annotations.RegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.registries.GameData;

import static com.github.kabi0210.animalworldx.common.init.AWSound.A_NEW_SOUND;

@Mod.EventBusSubscriber
public class CommonProxy {


    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.post(new RegisterMagicBookLevelEvent((ILevelProvider) AWItems.MagicBookOfPortal));
    }

    public void init(FMLInitializationEvent event) {
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegisterManager.getInstance().registerItems(AnimalWorldX.MOD_ID, event);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegisterManager.getInstance().registerBlocks(AnimalWorldX.MOD_ID, event);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        RegisterManager.getInstance().registerEntities(AnimalWorldX.MOD_ID, event);
    }
    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event){
        event.getRegistry().register(A_NEW_SOUND.setRegistryName(new ResourceLocation("animalworldx", "entity_petbox01_death")));
    }
}
