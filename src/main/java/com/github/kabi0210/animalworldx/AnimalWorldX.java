package com.github.kabi0210.animalworldx;

import com.github.kabi0210.animalworldx.common.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(
        modid = AnimalWorldX.MOD_ID,
        name = AnimalWorldX.MOD_NAME,
        version = AnimalWorldX.VERSION
)
public enum AnimalWorldX {
    INSTANCE;

    public static final String MOD_ID = "animalworldx";
    public static final String MOD_NAME = "AnimalWorldX";
    public static final String VERSION = "@version@";
    public static final String CLIENT = "com.github.kabi0210.animalworldx.client.ClientProxy";
    public static final String COMMON = "com.github.kabi0210.animalworldx.common.CommonProxy";

    @SidedProxy(clientSide = AnimalWorldX.CLIENT, serverSide = AnimalWorldX.COMMON, modId = AnimalWorldX.MOD_ID)
    public static CommonProxy proxy;

    @Mod.InstanceFactory
    public static AnimalWorldX getInstance() {
        return INSTANCE;
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
