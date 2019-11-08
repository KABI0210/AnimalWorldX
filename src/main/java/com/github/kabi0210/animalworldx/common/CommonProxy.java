package com.github.kabi0210.animalworldx.common;

import com.github.kabi0210.animalworldx.AnimalWorldX;
import com.github.kabi0210.animalworldx.api.event.RegisterMagicBookLevelEvent;
import com.github.kabi0210.animalworldx.common.init.AWItems;
import com.github.ksgfk.dawnfoundation.api.ModInfo;
import com.github.ksgfk.dawnfoundation.api.annotations.RegisterManager;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;

@Mod.EventBusSubscriber
public class CommonProxy {
    private ModInfo info;

    public void preInit(FMLPreInitializationEvent event) {
        info = ModInfo.create().setModId(AnimalWorldX.MOD_ID).build();
        MinecraftForge.EVENT_BUS.post(new RegisterMagicBookLevelEvent(AWItems.MagicBookOfPortal));
    }

    public void init(FMLInitializationEvent event) {
        RegisterManager.registerOreDict(info);
        RegisterManager.registerSmelt(info);
        RegisterManager.registerGuiHandler(info, AnimalWorldX.getInstance());
    }

    public void postInit(FMLPostInitializationEvent event) {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        RegisterManager.registerItem(AnimalWorldX.proxy.info, event);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event) {
        RegisterManager.registerBlock(AnimalWorldX.proxy.info, event);
    }

    @SubscribeEvent
    public static void registerEntities(RegistryEvent.Register<EntityEntry> event) {
        RegisterManager.registerEntity(AnimalWorldX.proxy.info, event);
    }

    @SubscribeEvent
    public static void onSoundEventRegistration(RegistryEvent.Register<SoundEvent> event) {
        RegisterManager.registerSoundEvent(AnimalWorldX.proxy.info, event);
    }

    public ModInfo getInfo() {
        return info;
    }
}
